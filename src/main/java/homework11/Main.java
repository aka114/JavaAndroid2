package homework11;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>(5);
        arrayList.add("Маша");
        arrayList.add("Мама");
        arrayList.add("Лама");
        arrayList.add("Рама");
        arrayList.add("Рама");
        arrayList.add("Рама");
        arrayList.add("Саша");
        arrayList.add("Маша");

        System.out.println(arrayList);

        System.out.println();

        Set<String> list = new HashSet<>(arrayList);
        System.out.println(list);

        System.out.println();

        Map<String, Object> map = new LinkedHashMap<>();

        for (String s : arrayList) {
            Object value = map.get(s);
            map.put(s, value == null ? 1 : (int)value + 1);
        }
        map.forEach((key, value) -> System.out.printf("Key: %s \t\t value: %s%n", key, value));

        System.out.println();

        PhoneCatalog phCat = new PhoneCatalog();
        phCat.add("Вася", "+79547563454");
        phCat.add("Вася", "+79547563455");
        phCat.add("Петя", "+79547513454");
        phCat.add("Гриша", "+79547566454");
        phCat.add("Миша", "+79547263454");
        phCat.add("Яша", "+79547593454");

        phCat.info();

        System.out.println();
        System.out.println(phCat.get("Вася"));
    }
}
