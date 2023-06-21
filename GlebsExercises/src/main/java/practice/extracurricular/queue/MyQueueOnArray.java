package practice.extracurricular.queue;

import java.util.Arrays;
import java.util.NoSuchElementException;
import practice.extracurricular.exception.FormatException;

public class MyQueueOnArray {

  Class clazz;
  private Object[] elementsArray;
  private int capacity = 5;
  private int size = 0;

  public MyQueueOnArray(Class clazz) {
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

  public boolean offer(Object element) {
    if (element != null) {
      if (element.getClass() == clazz) {
        if (size == elementsArray.length) {
          capacity *= 2;
          elementsArray = Arrays.copyOf(elementsArray, capacity);
        }
        elementsArray[size++] = element;
        return true;
      } else {
        throw new FormatException(
            "The format of the " + clazz + " and the passed " + element.getClass()
                + " argument do not match");
      }
    } else {
      throw new IllegalArgumentException("Element cannot be null");
    }
  }

  public Object poll() {
    if (size == 0) {
      throw new NoSuchElementException("Queue is empty");
    }
    Object tmp = elementsArray[0];
    for (int i = 1; i < size; i++) {
      elementsArray[i-1] = elementsArray[i];
    }
    size--;
    return tmp;
  }

  public Object peek() {
    if (size == 0) {
      throw new NoSuchElementException("Queue is empty");
    }
    return elementsArray[0];
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  static class Main {

    public static void main(String[] args) {
      MyQueue queue = new MyQueue(String.class);
      System.out.println(queue.size());
      System.out.println(queue.offer("asd"));
      System.out.println(queue.offer("fasd"));
      System.out.println(queue);
      System.out.println(queue.size());
      System.out.println(queue.peek());
      System.out.println(queue.poll());
      System.out.println(queue);
      System.out.println(queue.size());
    }
  }
}
