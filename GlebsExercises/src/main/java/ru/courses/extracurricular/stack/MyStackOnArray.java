package ru.courses.extracurricular.stack;

import java.util.Arrays;

public class MyStackOnArray<T> {

  private T[] elementsArray;
  private int capacity = 5;
  private int size = 0;

  public MyStackOnArray() {
    elementsArray = (T[]) new Object[capacity];
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder("[");
    for (int i = 0; i < size; i++) {
      if (i == size - 1) {
        stringBuilder.append(elementsArray[i]);
        break;
      }
      stringBuilder.append(elementsArray[i]);
      stringBuilder.append(", ");
    }
    stringBuilder.append("]");
    return stringBuilder.toString();
  }

  public void push(T element) {
    if (element != null) {
      if (size == elementsArray.length) {
        capacity *= 2;
        elementsArray = Arrays.copyOf(elementsArray, capacity);
      }
      elementsArray[size++] = element;
    } else {
      throw new IllegalArgumentException("Element cannot be null");
    }
  }

  public T pop() {
    T tmp = elementsArray[size - 1];
    elementsArray[--size] = null;
    return tmp;
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public T peek() {
    return elementsArray[size - 1];
  }

  static class Main {

    public static void main(String[] args) {
      MyStackOnArray<Integer> myStack = new MyStackOnArray<>();
      myStack.push(1);
      myStack.push(2);
      myStack.push(3);
      myStack.push(4);
      System.out.println(myStack.size());
      System.out.println(myStack);
      System.out.println(myStack.pop());
      System.out.println(myStack.pop());
      System.out.println(myStack.pop());
      System.out.println(myStack.pop());
      System.out.println(myStack.size());
      System.out.println(myStack);
    }
  }
}

