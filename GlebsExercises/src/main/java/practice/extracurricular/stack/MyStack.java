package practice.extracurricular.stack;

import java.util.NoSuchElementException;
import practice.extracurricular.exception.FormatException;
import practice.extracurricular.linkedlist.MyLinkedList;

public class MyStack {

  private Class clazz;
  private final MyLinkedList elementsList;

  public MyStack(Class clazz) {
    this.clazz = clazz;
    elementsList = new MyLinkedList(clazz);
  }

  @Override
  public String toString() {
    return elementsList.toString();
  }

  public void push(Object element) {
    if (element != null) {
      if (element.getClass() == clazz) {
        elementsList.add(element);
      } else {
        throw new FormatException(
            "The format of the " + clazz + " and the passed " + element.getClass()
                + " argument do not match");
      }
    } else {
      throw new IllegalArgumentException("Element cannot be null");
    }
  }

  public Object pop() {
    if (elementsList == null) {
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

  public Object peek() {
    if (elementsList == null) {
      throw new NoSuchElementException("Stack is empty");
    }
    return elementsList.get(size() - 1);
  }

  static class Main {

    public static void main(String[] args) {
      MyStack myStack = new MyStack(Integer.class);
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

