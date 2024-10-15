package ru.courses.extracurricular.linkedlist;

public class MainLinkedList {

  public static void main(String[] args) {
    MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
    System.out.println(myLinkedList);
    myLinkedList.removeLast();
    myLinkedList.add(0, 1);
    System.out.println(myLinkedList);
    myLinkedList.addFirst(3);
    myLinkedList.addFirst(2);
    myLinkedList.addLast(9);
    myLinkedList.add(4);
    myLinkedList.addFirst(10);
    System.out.println(myLinkedList);
    myLinkedList.add(3, 11);
    System.out.println(myLinkedList);
    myLinkedList.add(4, 16);
    System.out.println(myLinkedList);
    myLinkedList.add(8, 11);
    System.out.println(myLinkedList);
    System.out.println(myLinkedList.size());
    System.out.println(myLinkedList.removeLast());
    System.out.println(myLinkedList.removeFirst());
    System.out.println(myLinkedList.size());
    System.out.println(myLinkedList.get(4));
  }
}