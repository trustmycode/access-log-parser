package ru.courses.extracurricular.queue;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyQueueOnArray<E> {

  private E[] elementsArray;
  private int capacity = 5;
  private int size = 0;
  private int firstIndex = 0;
  private int lastIndex = -1;

  public MyQueueOnArray() {
    elementsArray = (E[]) new Object[capacity];
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder("[");
    for (int i = firstIndex; i != lastIndex; i = (i + 1) % elementsArray.length) {
      stringBuilder.append(elementsArray[i]).append(", ");
    }
    stringBuilder.append(elementsArray[lastIndex]).append("]");
    return stringBuilder.toString();
  }

  public boolean offer(E element) {
    if (element != null) {
      if (size == capacity) {
        capacity *= 2;
        if (lastIndex < firstIndex) {
          queueSort();
        } else {
          elementsArray = Arrays.copyOf(elementsArray, capacity);
        }
      }
      lastIndex = (lastIndex + 1) % elementsArray.length;
      elementsArray[lastIndex] = element;
      size++;
      return true;
    } else {
      throw new IllegalArgumentException("Key cannot be null");
    }
  }

  public E poll() {
    if (isEmpty()) {
      throw new NoSuchElementException("Queue is empty");
    }
    E tmp = elementsArray[firstIndex];
    if (firstIndex == lastIndex) {
      firstIndex = 0;
    }
    elementsArray[firstIndex++] = null;
    size--;
    return tmp;
  }

  public E peek() {
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
    E[] tmp = (E[]) new Object[capacity];
    int j = 0;
    for (int i = firstIndex; i != lastIndex; i = (i + 1) % elementsArray.length, j++) {
      tmp[j] = elementsArray[i];
    }
    tmp[j] = elementsArray[lastIndex];
    elementsArray = tmp;
    lastIndex = size - 1;
    firstIndex = 0;
  }

  static class Main {

    public static void main(String[] args) {
      MyQueueOnArray<String> queue = new MyQueueOnArray<>();
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
