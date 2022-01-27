package com.al.demo.testfw;

import com.al.demo.testfw.annotation.After;
import com.al.demo.testfw.annotation.Before;
import com.al.demo.testfw.annotation.Test;

import java.lang.reflect.Method;

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

    public void runTest(Class<?> clazz){
        TestStatistic testStatistic = new TestStatistic();

        // найдем методы, которые необходимо запускать
        MethodsInfo mInfo = defineMethods(clazz);

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
                callMethod(objTest, method, testStatistic, MSG_ERROR_CALL_TEST_METHOD);
                // выполним запусе методов @After
                callMethods(objTest, mInfo.getAfterMethods(), MSG_ERROR_CALL_AFTER_METHOD);
            } catch (Exception ex){
                System.out.print(MSG_ERROR_CREATE_OBJECT);
                ex.printStackTrace();
            }
        }

        printStatisticsInfo(testStatistic);

    }

    /**
     * Метод определяет тестируемые методы тестового класса
     */
    private MethodsInfo defineMethods(Class<?> clazz){
        MethodsInfo mInfo = new MethodsInfo();
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
        return mInfo;
    }

    /**
     * Метод производит поочередный запуск переданного набора методов
     * @param methods набор методов
     */
    private void callMethods(Object obj, Iterable<Method> methods, String msgErrorTemplate){
        for(Method method: methods){
            callMethod(obj, method, null, msgErrorTemplate);
        }
    }

    /**
     * Метод производит запуск переданного метода
     */
    private void callMethod(Object obj, Method method, TestStatistic testStatistic, String msgErrorTemplate) {
        try {
            ReflectionHelper.callMethod(obj, method, (Object[]) null);
            if (testStatistic != null) {
                testStatistic.incrementSuccessTest();
            }
        } catch (Exception ex) {
            if (testStatistic != null) {
                testStatistic.incrementFallTest();
            }
            System.out.printf(
                    msgErrorTemplate != null && !msgErrorTemplate.isEmpty() ? msgErrorTemplate : MSG_ERROR_CALL_METHOD,
                    method.getName());
            ex.printStackTrace();
        }
    }

    private void printStatisticsInfo(TestStatistic testStatistic ){
        System.out.printf(MSQ_INFO_STATISTICS,
                testStatistic.getCountTotalTest(),
                testStatistic.getCountSuccessTest(),
                testStatistic.getCountFallTest());
    }

}
