package practice.oop.demo.stream;

import java.util.*;

public class LambdaExample {

    public static void main(String[] args) {
        // Пример данных
        List<Student> students = Arrays.asList(new Student(7, "Alice", new Teacher("Mr. Smith")), new Student(6, "Bob", new Teacher("Mrs. Jones")), new Student(7, "Charlie", new Teacher("Mr. Brown")), new Student(8, "David", new Teacher("Mr. White")));

        // Фильтрация студентов по классу = 7
        List<Teacher> teachersOfFilteredStudents = students.stream()
                .filter(student -> student.getNumOfClass() == 7)  // Лямбда для фильтрации
                .map(Student::getFirstTeacher)
                .toList();

        List<Student> filteredStudents = students.stream()
                .filter(student -> student.getNumOfClass() == 7)  // Лямбда для фильтрации
                .peek(student -> student.setNameOfStudent(student.getNameOfStudent().toUpperCase()))
                .toList();


        teachersOfFilteredStudents.forEach(System.out::println);
        // Вывод отфильтрованных студентов
        filteredStudents.forEach(System.out::println);
    }
}

