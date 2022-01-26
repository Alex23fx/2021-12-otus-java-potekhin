package com.al.demo.testFW;

import java.lang.reflect.Method;
import java.util.*;

/**
 * Класс хранит инфомрацюи по тестируемым методам
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
        methodsTest.add(method);
    }

    /**
     * Метод возвращает Название тестового метода и удаляет его из коллекции
     * @return
     */
    public Method getMethodTest(){
        return methodsTest.poll();
    }

    public Iterable getMethodBeforeIterable(){
        return (Iterable) methodsBefore;
    }

    public Iterable getMethodAfterIterable(){
        return (Iterable) methodsAfter;
    }
}
