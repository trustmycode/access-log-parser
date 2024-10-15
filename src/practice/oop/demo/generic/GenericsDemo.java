package practice.oop.demo.generic;

import java.util.ArrayList;
import java.util.List;

// Обобщенный класс с дженериками
class Box<T> {
    private T item;

    public Box(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public static <E> void listAdd(List<? super Number> list, E num) {
        list.add((Number) num);
    }
    public static <E extends Number> void listPrint(List<E> list) {
        for(E elem: list) {
            System.out.println(elem);
        }
    }
}

class MultiTypeGenericExample {

    // Метод, принимающий два типа T и U, которые оба должны реализовать Comparable
    public static <T extends Comparable<T>, U extends Comparable<U>> int compare(T first, U second) {
        return first.compareTo((T) second);  // Приводим второй объект к типу T и сравниваем
    }

    public static void main(String[] args) {
        String str = "Hello";
        String str2 = "World";

        int result = compare(str, str2);
        System.out.println("Результат сравнения: " + result);  // Сравнение двух строк

        Character char1 = 'A';
        Character char2 = 'Z';

        result = compare(char1, char2);
        System.out.println("Результат сравнения символов: " + result);  // Сравнение двух символов
    }
}


public class GenericsDemo {

    public static void main(String[] args) {

        Integer one = 1;
        Double two = 2.0;
        Long three = 3L;
        List<Number> listOne = new ArrayList<>();
        Box.listAdd(listOne, one);
        Box.listAdd(listOne, two);
        Box.listAdd(listOne, three);
//        System.out.println(listOne);
        Box.listPrint(listOne);

        // Box для хранения Integer
        Box<Integer> intBox = new Box<>(10);
        System.out.println("Integer in Box: " + intBox.getItem());

        // Box для хранения String
        Box<String> stringBox = new Box<>("Hello");
        System.out.println("String in Box: " + stringBox.getItem());
    }
}
