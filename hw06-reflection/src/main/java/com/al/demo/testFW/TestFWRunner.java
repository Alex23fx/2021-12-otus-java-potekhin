package com.al.demo.testFW;

import com.al.demo.testFW.annotation.After;
import com.al.demo.testFW.annotation.Before;
import com.al.demo.testFW.annotation.Test;

import java.lang.reflect.Method;
import java.util.Optional;

public class TestFWRunner {
    private final static String MSG_ERROR_CALL_METHOD = "Filed to call method: %s %n";
    private final static String MSG_ERROR_CALL_BEFORE_METHOD = "Filed to call @Before method: %s %n";
    private final static String MSG_ERROR_CALL_AFTER_METHOD = "Filed to call @After method: %s %n";
    private final static String MSG_ERROR_CALL_TEST_METHOD = "Filed to call @Test method: %s %n";
    private final static String MSG_ERROR_CREATE_OBJECT = "Filed to create object! %n";

    private final static String MSG_INFO_TEST_METHOD = "Test method: %s %n";
    private final static String MSQ_INFO_CREATE_OBJECT = "Create object: %s %n";

    private final static String MSQ_INFO_STATISTICS = "COUNT TESTS: %d, SUCCESSFUL TESTS: %d, FALL TESTS: %d %n";

    private final static String MSG_SEPARATOR = "--------------------------------------------  %n";

    public static void runTest(Class<?> clazz){
        TestStatistic testStatistic = new TestStatistic();

        // найдем методы, которые необходимо запускать
        MethodsInfo mInfo = new MethodsInfo();
        defineMethods(clazz, mInfo);

        // выполним запуск методов
        Method method;
        while ((method = mInfo.getMethodTest()) != null){
            System.out.print(MSG_SEPARATOR);
            System.out.printf((MSG_INFO_TEST_METHOD), method.getName());
            try{
                System.out.printf(MSQ_INFO_CREATE_OBJECT, clazz);
                Object objTest = ReflectionHelper.instantiate(clazz, (Object[]) null);
                // выполним запуск методов @Before
                callMethods(objTest, mInfo.getBeforeMethods(), MSG_ERROR_CALL_BEFORE_METHOD);
                // выполним запуск метода @Test
                callMethod(objTest, method, Optional.of(testStatistic), MSG_ERROR_CALL_TEST_METHOD);
                // выполним запусе методов @After
                callMethods(objTest, mInfo.getAfterMethods(), MSG_ERROR_CALL_AFTER_METHOD);
            } catch (Exception ex){
                System.out.print(MSG_ERROR_CREATE_OBJECT);
                System.out.println(ex);
            }
        }

        printStatisticsInfo(testStatistic);

    }

    /**
     * Метод определяет тестируемые методы тестового класса
     */
    private static void defineMethods(Class<?> clazz, MethodsInfo mInfo){
        Method[] methods = ReflectionHelper.getMethods(clazz);
        for (Method method : methods) {
            method.setAccessible(true);

            Before before = method.getAnnotation(Before.class);
            if (before != null)
                mInfo.addMethodBefore(method);

            After after = method.getAnnotation(After.class);
            if (after != null)
                mInfo.addMethodAfter(method);

            Test test = method.getAnnotation(Test.class);
            if (test != null)
                mInfo.addMethodTest(method);

        }
    }

    /**
     * Метод производит поочередный запуск переданного набора методов
     * @param methods набор методов
     */
    private static void callMethods(Object obj, Iterable<Method> methods, String msgErrorTemplate){
        for(Method method: methods){
            callMethod(obj, method, Optional.empty(), msgErrorTemplate);
        }
    }

    /**
     * Метод производит запуск переданного метода
     */
    private static void callMethod(Object obj, Method method, Optional<TestStatistic> testStatistics, String msgErrorTemplate){
        try {
            ReflectionHelper.callMethod(obj, method, (Object[]) null);
            if(testStatistics.isPresent()) testStatistics.get().incrementSuccessTest();
        } catch (Exception ex) {
            if(testStatistics.isPresent()) testStatistics.get().incrementFallTest();
            System.out.printf(msgErrorTemplate, method.getName());
            System.out.println(ex.toString());
        }
    }

    private static void callMethod(Object obj, Method method){
        callMethod(obj, method, Optional.empty(), MSG_ERROR_CALL_METHOD);
    }

    private static void printStatisticsInfo(TestStatistic testStatistic ){
        System.out.printf(MSQ_INFO_STATISTICS,
                testStatistic.getCountTotalTest(),
                testStatistic.getCountSuccessTest(),
                testStatistic.getCountFallTest());
    }

}
