package com.al.demo.testFW;

public class TestStatistic {
    /**
     * Кол-во успешно выполенных тестов
     */
    private int successTest = 0;

    /**
     * Кол-во упавших тестов
     */
    private int fallTest = 0;

    /**
     * Метод увеличивает на 1 кол-во успешных тестов
     */
    public void incrementSuccessTest(){ successTest++; }

    /**
     * Метод увеличивает на 1 кол-во упавших тестов
     */
    public void incrementFallTest(){ fallTest++; }

    public int getCountSuccessTest(){
        return successTest;
    }

    public int getCountFallTest(){
        return fallTest;
    }

    public int getCountTotalTest(){
        return fallTest + successTest;
    }
}
