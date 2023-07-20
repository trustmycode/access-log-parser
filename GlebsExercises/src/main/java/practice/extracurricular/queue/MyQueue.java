package practice.extracurricular.queue;

import java.util.NoSuchElementException;
import practice.extracurricular.linkedlist.MyLinkedList;

public class MyQueue {

  MyLinkedList list;
  Class clazz;

  public MyQueue(Class clazz) {
    this.clazz = clazz;
    this.list = new MyLinkedList(clazz);
  }

  @Override
  public String toString() {
    return list.toString();
  }

  public boolean offer(Object element) {
    return list.add(element);
  }

  public Object poll() {
    if (isEmpty()) {
      throw new NoSuchElementException("Queue is empty");
    }
    return list.removeFirst();
  }

  public Object peek() {
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
      MyQueue queue = new MyQueue(String.class);
      System.out.println(queue.size());
      System.out.println(queue.offer("asd"));
      System.out.println(queue.offer("fasd"));
      System.out.println(queue);
      System.out.println(queue.size());
      System.out.println(queue.peek());
      System.out.println(queue.poll());
      System.out.println(queue);
    }
  }
}