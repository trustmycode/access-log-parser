package practice.oop.demo.stream;

import java.util.*;
import java.util.stream.*;

public class StreamDemo {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Jane", "Tom", "Mike", "Jill");

        // Фильтрация и вывод только тех имен, которые начинаются на "J"
        List<String> filteredNames = names.stream()
                .filter(name -> name.startsWith("J"))
                .collect(Collectors.toList());
        System.out.println("Names starting with J: " + filteredNames);

        // Преобразование имен в верхний регистр и их сортировка
        List<String> upperCaseNames = names.stream()
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Uppercase sorted names: " + upperCaseNames);

        // Подсчет количества имен длиннее 3 символов
        long count = names.stream()
                .filter(name -> name.length() > 3)
                .count();
        System.out.println("Count of names longer than 3 characters: " + count);
    }
}
