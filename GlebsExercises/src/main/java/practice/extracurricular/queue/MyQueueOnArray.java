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
  private int lastIndex = -1;

  public MyQueueOnArray(Class clazz) {
    this.clazz = clazz;
    elementsArray = new Object[capacity];
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder("[");
    if (lastIndex != firstIndex) {
      if (lastIndex < firstIndex) {
        for (int i = firstIndex; i < elementsArray.length; i++) {
          stringBuilder.append(elementsArray[i]).append(", ");
        }
        for (int i = 0; i < lastIndex; i++) {
          stringBuilder.append(elementsArray[i]).append(", ");
        }
      } else {
        for (int i = 0; i < elementsArray.length - 1; i++) {
          if (elementsArray[i] != null) {
            stringBuilder.append(elementsArray[i]).append(", ");
          }
        }
      }
    }
    stringBuilder.append(elementsArray[lastIndex]).append("]");
    return stringBuilder.toString();
  }

  public boolean offer(Object element) {
    if (element != null) {
      if (element.getClass() == clazz) {
        if (size == capacity) {
          if (lastIndex < firstIndex) {
            queueSort();
          }
          capacity *= 2;
          elementsArray = Arrays.copyOf(elementsArray, capacity);
        }
      }
      if (lastIndex == capacity - 1 && size < capacity) {
        lastIndex = -1;
      }
      elementsArray[++lastIndex] = element;
      size++;
      return true;
    } else {
      throw new FormatException(
          "The format of the " + clazz + " and the passed " + element.getClass()
              + " argument do not match");
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

  private void queueSort() {
    Object[] tmp = Arrays.copyOfRange(elementsArray, 0, firstIndex);
    int j = firstIndex;
    for (int i = 0; j < elementsArray.length; i++, j++) {
      elementsArray[i] = elementsArray[j];
    }
    j = 0;
    for (int i = firstIndex + 1; i < elementsArray.length; i++, j++) {
      elementsArray[i] = tmp[j];
    }
    firstIndex = 0;
    lastIndex = size - 1;
  }

  static class Main {

    public static void main(String[] args) {
      MyQueueOnArray queue = new MyQueueOnArray(String.class);
      System.out.println(queue.size());
      System.out.println(queue.offer("asd"));
      System.out.println(queue);
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
