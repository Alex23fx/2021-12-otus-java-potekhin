package com.al.demo.testfw;

import java.lang.reflect.Method;
import java.util.*;

/**
 * Класс хранит информацюи по тестируемым методам
 */
class MethodsInfo {

    private final List<Method> methodsBefore = new ArrayList<>();
    private final List<Method> methodsAfter = new ArrayList<>();
    private final Queue<Method> methodsTest = new LinkedList<>();

    public void addMethodBefore(Method method){
        methodsBefore.add(method);
    }

    public void addMethodAfter(Method method){
        methodsAfter.add(method);
    }

    public void addMethodTest(Method method){
        methodsTest.offer(method);
    }

    /**
     * Метод возвращает Название тестового метода и удаляет его из коллекции
     */
    public Method getMethodTest(){
        return methodsTest.poll();
    }

    public Iterable<Method> getBeforeMethods(){
        return (Iterable<Method>) methodsBefore;
    }

    public Iterable<Method> getAfterMethods(){
        return (Iterable<Method>) methodsAfter;
    }
}
