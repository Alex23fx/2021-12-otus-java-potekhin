package homework;


import java.util.*;

public class CustomerReverseOrder {

    //todo: 2. надо реализовать методы этого класса
    //надо подобрать подходящую структуру данных, тогда решение будет в "две строчки"
    private final LinkedList<Customer> customers = new LinkedList<>();

    public void add(Customer customer) {
        customers.offer(customer);
    }

    public Customer take() {
        return customers.pollLast();
    }
}
