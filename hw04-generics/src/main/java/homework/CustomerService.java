package homework;


import java.util.AbstractMap;
import java.util.Map;
import java.util.TreeMap;

public class CustomerService {

    //todo: 3. надо реализовать методы этого класса
    //важно подобрать подходящую Map-у, посмотрите на редко используемые методы, они тут полезны

    private final TreeMap<Customer, String> customers;

    public CustomerService() {
        this.customers = new TreeMap<>();
    }

    public Map.Entry<Customer, String> getSmallest() {
        Map.Entry<Customer, String> mapEntry = customers.firstEntry();
        return getCopyMapEntry(mapEntry);
    }

    public Map.Entry<Customer, String> getNext(Customer customer) {
        // определим следующий ключ
        Customer customerNextKey = customers.navigableKeySet().stream()
                .filter(c -> c.getScores() > customer.getScores())
                .findFirst()
                .orElse(null);

        if(customerNextKey == null)
            return null;
        // определим Entry по слудуюему ключю
        Map.Entry<Customer, String> mapEntry = customers.ceilingEntry(customerNextKey);
        // вернем копию
        return getCopyMapEntry(mapEntry);
    }

    public void add(Customer customer, String data) {
        this.customers.put(customer, data);
    }

    /**
     * Метод возвращает копию Map.Entry<Customer, String>
     * @param mapEntry оригинальный объект
     * @return копия оригинального объекта
     */
    protected Map.Entry<Customer, String> getCopyMapEntry(Map.Entry<Customer, String> mapEntry) {
        return new AbstractMap.SimpleImmutableEntry<>(new Customer(mapEntry.getKey()), mapEntry.getValue());
    }

}
