package ru.courses.extracurricular.queue;

import java.util.NoSuchElementException;
import ru.courses.extracurricular.linkedlist.MyLinkedList;

public class MyQueue<E> {

  MyLinkedList<E> list;

  public MyQueue() {
    this.list = new MyLinkedList<>();
  }

  @Override
  public String toString() {
    return list.toString();
  }

  public boolean offer(E element) {
    return list.add(element);
  }

  public E poll() {
    if (isEmpty()) {
      throw new NoSuchElementException("Queue is empty");
    }
    return list.removeFirst();
  }

  public E peek() {
    if (isEmpty()) {
      throw new NoSuchElementException("Queue is empty");
    }
    return list.get(0);
  }

  public int size() {
    return list.size();
  }

  public boolean isEmpty() {
    return list.isEmpty();
  }

  static class Main {

    public static void main(String[] args) {
      MyQueue<String> queue = new MyQueue<>();
      System.out.println(queue.size());
      System.out.println(queue.offer("asd"));
      System.out.println(queue.offer("a"));
      System.out.println(queue);
      System.out.println(queue.size());
      System.out.println(queue.peek());
      System.out.println(queue.poll());
      System.out.println(queue);
    }
  }
}