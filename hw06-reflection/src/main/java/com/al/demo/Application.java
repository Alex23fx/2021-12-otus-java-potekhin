package com.al.demo;

import com.al.demo.testfw.TestFWRunner;

public class Application {
    public static void main(String[] args) throws Exception {
        TestFWRunner testFWRunner = new TestFWRunner();
        testFWRunner.runTest(DemoTest.class);
    }
}