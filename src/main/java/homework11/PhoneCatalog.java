package homework11;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PhoneCatalog {

    final private Map<String, ArrayList> catalog = new HashMap<>();

    public ArrayList get(String name) {
        return catalog.get(name);
    }

    public void add(String name, String phoneNumber) {
        ArrayList<String> value = catalog.get(name);
        ArrayList<String> phones;
        phones = Objects.requireNonNullElseGet(value, ArrayList::new);
        phones.add(phoneNumber);
        catalog.put(name, phones);
    }

    public void info() {
        catalog.forEach((key, value) -> System.out.printf("Name: %s \t\t phone: %s%n", key, value));
    }
}
