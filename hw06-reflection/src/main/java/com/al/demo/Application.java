package com.al.demo;

import com.al.demo.testFW.TestFWRunner;

public class Application {
    public static void main(String[] args) throws Exception {
        TestFWRunner.runTest(DemoTest.class);
    }
}