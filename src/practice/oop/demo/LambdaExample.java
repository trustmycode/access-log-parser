package practice.oop.demo;

import java.util.*;
import java.util.stream.*;

public class LambdaExample {

    public static void main(String[] args) {
        // Пример данных
        List<Student> students = Arrays.asList(new Student(7, "Alice", new Teacher("Mr. Smith")), new Student(6, "Bob", new Teacher("Mrs. Jones")), new Student(7, "Charlie", new Teacher("Mr. Brown")), new Student(8, "David", new Teacher("Mr. White")));

        // Фильтрация студентов по классу = 7
        List<Student> filteredStudents = students.stream().filter(student -> student.getNumOfClass() == 7)  // Лямбда для фильтрации
                .peek(student -> student.setNameOfStudent(student.getNameOfStudent().toUpperCase()))
                .toList();

        // Вывод отфильтрованных студентов
        filteredStudents.forEach(System.out::println);
    }
}

