package practice.oop.demo;

import java.util.*;

public class CollectionDemo {

    public static void main(String[] args) {
        // List: хранит дубликаты, поддерживает порядок
        List<String> arrayList = new ArrayList<>();
        arrayList.add("Apple");
        arrayList.add("Banana");
        arrayList.add("Apple");  // дубликат
        System.out.println("ArrayList: " + arrayList);

        // Set: не хранит дубликаты, порядок не гарантируется
        Set<String> hashSet = new HashSet<>();
        hashSet.add("Apple");
        hashSet.add("Banana");
        hashSet.add("Apple");  // дубликат игнорируется
        System.out.println("HashSet: " + hashSet);

        // Map: хранит пары ключ-значение, уникальные ключи
        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "John");
        hashMap.put(2, "Jane");
        hashMap.put(1, "Mike");  // ключ 1 перезаписывается
        System.out.println("HashMap: " + hashMap);
    }
}

