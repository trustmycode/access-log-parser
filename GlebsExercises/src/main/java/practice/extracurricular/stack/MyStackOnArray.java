package practice.extracurricular.stack;

import java.util.Arrays;
import java.util.Stack;
import practice.extracurricular.exception.FormatException;

public class MyStackOnArray {

  private Class clazz;
  private Object[] elementsArray;
  private int capacity = 5;
  private int size = 0;

  public MyStackOnArray(Class clazz) {
    this.clazz = clazz;
    elementsArray = new Object[capacity];
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

  public void push(Object element) {
    if (element != null) {
      if (element.getClass() == clazz) {
        if (size == elementsArray.length) {
          capacity *= 2;
          elementsArray = Arrays.copyOf(elementsArray, capacity);
        }
        elementsArray[size++] = element;
      } else {
        throw new FormatException(
            "The format of the " + clazz + " and the passed " + element.getClass()
                + " argument do not match");
      }
    } else {
      throw new IllegalArgumentException("Element cannot be null");
    }
  }

  public void pop() {
    if (size != 0) {
      elementsArray[size--] = null;
    }
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public Object peek() {
    return elementsArray[size - 1];
  }

  static class Main {

    public static void main(String[] args) {
      Stack<Integer> stack = new Stack<>();
      stack.push(1);
      stack.push(2);
      stack.push(3);
      stack.push(4);
      System.out.println(stack.size());
      System.out.println(stack);
      System.out.println(stack.peek());
      stack.pop();
      System.out.println(stack.size());
      System.out.println(stack);
      System.out.println(stack.peek());
      MyStackOnArray myStack = new MyStackOnArray(Integer.class);
      myStack.push(1);
      myStack.push(2);
      myStack.push(3);
      myStack.push(4);
      System.out.println(myStack.size());
      System.out.println(myStack);
      System.out.println(myStack.peek());
      myStack.pop();
      System.out.println(myStack.size());
      System.out.println(myStack);
      System.out.println(myStack.peek());
    }
  }
}

