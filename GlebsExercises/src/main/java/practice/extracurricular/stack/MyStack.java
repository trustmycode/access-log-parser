package practice.extracurricular.stack;

import java.util.NoSuchElementException;
import practice.extracurricular.linkedlist.MyLinkedList;

public class MyStack {

  private final MyLinkedList elementsList;
  private Class clazz;

  public MyStack(Class clazz) {
    this.clazz = clazz;
    elementsList = new MyLinkedList(clazz);
  }

  @Override
  public String toString() {
    return elementsList.toString();
  }

  public boolean push(Object element) {
    return elementsList.add(element);
  }

  public Object pop() {
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

  public Object peek() {
    if (isEmpty()) {
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

