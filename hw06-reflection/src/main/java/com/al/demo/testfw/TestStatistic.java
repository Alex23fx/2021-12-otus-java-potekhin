package com.al.demo.testfw;

/**
 * Класс хранит информацию о кол-ве пройденных тестов
 */
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

    /**
     * Метод возвращает кол-во успешно пройденных тестов
     */
    public int getCountSuccessTest(){
        return successTest;
    }

    /**
     * Метод возвращает кол-во проваленных тестов
     */
    public int getCountFallTest(){
        return fallTest;
    }

    /**
     * Метод возвращает общее кол-во запущенных тестов
     */
    public int getCountTotalTest(){
        return fallTest + successTest;
    }
}
