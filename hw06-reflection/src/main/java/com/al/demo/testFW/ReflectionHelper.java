package com.al.demo.testFW;

import java.lang.reflect.Method;
import java.util.Arrays;


public class ReflectionHelper {
    private ReflectionHelper() {
    }

    static Method[] getMethods(Class type){
        try {
            return type.getMethods();
        } catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

    static Object getFieldValue(Object object, String name) {
        try {
            var field = object.getClass().getDeclaredField(name);
            field.setAccessible(true);
            return field.get(object);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    static void setFieldValue(Object object, String name, Object value) {
        try {
            var field = object.getClass().getDeclaredField(name);
            field.setAccessible(true);
            field.set(object, value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    static Object callMethod(Object object, Method method, Object... args){
        try {
            method.setAccessible(true);
            return method.invoke(object, args);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    static Object callMethod(Object object, String name, Object... args) {
        try {
            var method = object.getClass().getDeclaredMethod(name, toClasses(args));
            return callMethod(object, method, args);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    static <T> T instantiate(Class<T> type, Object... args) {
        try {
            if (args == null || args.length == 0) {
                return type.getDeclaredConstructor().newInstance();
            } else {
                Class<?>[] classes = toClasses(args);
                return type.getDeclaredConstructor(classes).newInstance(args);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    static Class<?>[] toClasses(Object[] args) {
        return Arrays.stream(args).map(Object::getClass).toArray(Class<?>[]::new);
    }
}
