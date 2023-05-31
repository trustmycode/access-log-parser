package practice.oop.module2.encapsulation.student;

import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    Student student = new Student("Vlad");
    System.out.println(student);
    student.setScores(2);
    System.out.println(student);
    List<Integer> list = new ArrayList<>();
    list.add(2);
    list.add(3);
    list.add(4);
    Student student1 = new Student("Oleg", list);
    System.out.println(student1);
    System.out.println(student1.getScores());
    list.remove(2);
    System.out.println(student1.getScores());
    student1.setScores(5);
    System.out.println(student1);
    list.add(6);
    student1.setScores(list);
    System.out.println(student1);
  }
}
