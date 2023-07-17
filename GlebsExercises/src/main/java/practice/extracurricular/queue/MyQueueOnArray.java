package practice.extracurricular.queue;

import java.util.Arrays;
import java.util.NoSuchElementException;
import practice.extracurricular.exception.FormatException;

public class MyQueueOnArray {

  Class clazz;
  private Object[] elementsArray;
  private int capacity = 5;
  private int size = 0;
  private int firstIndex = 0;
  private int lastIndex = 0;

  public MyQueueOnArray(Class clazz) {
    this.clazz = clazz;
    elementsArray = new Object[capacity];
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder("[");
    for (int i = firstIndex; i < lastIndex - 1; i++) {
      stringBuilder.append(elementsArray[i]).append(", ");
    }
    stringBuilder.append(elementsArray[lastIndex - 1]).append("]");
    return stringBuilder.toString();
  }

  public boolean offer(Object element) {
    if (element != null) {
      if (element.getClass() == clazz) {
        if (size == capacity) {
          capacity *= 2;
          elementsArray = Arrays.copyOf(elementsArray, capacity);
        }
        if (lastIndex == capacity && size < capacity) {
          int j = firstIndex;
          for (int i = 0; j < lastIndex; i++, j++) {
            if (i < lastIndex - firstIndex) {
              elementsArray[i] = elementsArray[j];
            } else {
              elementsArray[i] = null;
            }
          }
          lastIndex = lastIndex - firstIndex;
          firstIndex = 0;
        }
        elementsArray[lastIndex++] = element;
        size++;
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
    if (isEmpty()) {
      throw new NoSuchElementException("Queue is empty");
    }
    Object tmp = elementsArray[firstIndex];
    if (firstIndex == lastIndex) {
      firstIndex = 0;
    }
    elementsArray[firstIndex++] = null;
    size--;
    return tmp;
  }

  public Object peek() {
    if (isEmpty()) {
      throw new NoSuchElementException("Queue is empty");
    }
    return elementsArray[firstIndex];
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  static class Main {

    public static void main(String[] args) {
      MyQueueOnArray queue = new MyQueueOnArray(String.class);
      System.out.println(queue.size());
      System.out.println(queue.offer("asd"));
      System.out.println(queue.offer("fasd"));
      System.out.println(queue.offer("wads"));
      System.out.println(queue.offer("hytjn"));
      System.out.println(queue.offer("xczvb"));
      System.out.println(queue);
      System.out.println(queue.size());
      System.out.println(queue.peek());
      System.out.println(queue.poll());
      System.out.println(queue);
      System.out.println(queue.size());
      System.out.println(queue.peek());
      System.out.println(queue.poll());
      System.out.println(queue);
      System.out.println(queue.size());
      System.out.println(queue.offer("asd"));
      System.out.println(queue);
      System.out.println(queue.offer("asd"));
      System.out.println(queue);
      System.out.println(queue.offer("jklfg"));
      System.out.println(queue.offer("jkasdfg"));
      System.out.println(queue.offer("jkqweg"));
      System.out.println(queue);
      System.out.println(queue.poll());
      System.out.println(queue.poll());
      System.out.println(queue.poll());
      System.out.println(queue.poll());
      System.out.println(queue.poll());
      System.out.println(queue);
      System.out.println(queue.offer("fasd"));
      System.out.println(queue.offer("wads"));
      System.out.println(queue.offer("hytjn"));
      System.out.println(queue.offer("xczvb"));
      System.out.println(queue);
    }
  }
}
