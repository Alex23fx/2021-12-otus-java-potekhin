package com.al.demo;

import com.al.demo.testFW.annotation.After;
import com.al.demo.testFW.annotation.Before;
import com.al.demo.testFW.annotation.Test;

public class DemoTest {

    @Before
    public void init(){
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("Отработал метод init.........................");
        // метод производит предварительную инициализацию
        double f = Math.random()/Math.nextDown(1.0);
//        double x = x1*(1.0 - f) + x2*f;
    }

    @Test
    public void testMethod1(){
        System.out.println("Отработал метод testMethod1.........................");
    }

    @Test
    public void testMethod2(){
        System.out.println("Отработал метод testMethod2.........................");
    }

    @Test
    public void testMethod3(){
        System.out.println("Отработал метод testMethod3.........................");
        throw new RuntimeException("Ошибка при выполнении теста");
    }

    @Test
    public void testMethod4(){
        System.out.println("Отработал метод testMethod4.........................");
        //throw new RuntimeException("Ошибка при выполнении теста");
    }

    @After
    public void dropResources(){
        // метод производит предварительную инициализацию
        double f = Math.random()/Math.nextDown(1.0);
//        double x = x1*(1.0 - f) + x2*f;
        System.out.println("Отработал метод dropResources.........................");
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }
}
