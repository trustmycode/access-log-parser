package practice.oop.demo;

import java.lang.reflect.*;

class Person {
    private String name = "John Doe";
    private int age = 30;

    private void printInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

public class ReflectionDemo {

    public static void main(String[] args) {
        try {
            // Создание объекта класса Person
            Person person = new Person();

            // Получение информации о приватном поле "name"
            Field nameField = person.getClass().getDeclaredField("name");
            nameField.setAccessible(true);
            System.out.println("Private field 'name' value: " + nameField.get(person));

            // Изменение значения приватного поля "name"
            nameField.set(person, "Jane Doe");
            System.out.println("Updated private field 'name' value: " + nameField.get(person));

            // Вызов приватного метода "printInfo"
            Method printInfoMethod = person.getClass().getDeclaredMethod("printInfo");
            printInfoMethod.setAccessible(true);
            printInfoMethod.invoke(person);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
