package ru.courses.extracurricular.stack;

import java.util.NoSuchElementException;
import ru.courses.extracurricular.linkedlist.MyLinkedList;

public class MyStack<E> {

  private final MyLinkedList<E> elementsList;

  public MyStack() {
    elementsList = new MyLinkedList<>();
  }

  @Override
  public String toString() {
    return elementsList.toString();
  }

  public boolean push(E element) {
    return elementsList.add(element);
  }

  public E pop() {
    if (isEmpty()) {
      throw new NoSuchElementException("Stack is empty");
    }
    return elementsList.removeLast();
  }

  public int size() {
    return elementsList.size();
  }

  public boolean isEmpty() {
    return elementsList.isEmpty();
  }

  public E peek() {
    if (isEmpty()) {
      throw new NoSuchElementException("Stack is empty");
    }
    return elementsList.get(size() - 1);
  }

  static class Main {

    public static void main(String[] args) {
      MyStack<Integer> myStack = new MyStack<>();
      myStack.pop();
      myStack.push(1);
      myStack.push(2);
      myStack.push(3);
      myStack.push(4);
      System.out.println(myStack.size());
      System.out.println(myStack);
      System.out.println(myStack.peek());
      System.out.println(myStack.pop());
      System.out.println(myStack.size());
      System.out.println(myStack);
      System.out.println(myStack.peek());
    }
  }
}

