package practice.extracurricular.linkedlist;

import practice.exception.FormatException;

public class MyLinkedList {

  private MyLinkedListNode head;
  private MyLinkedListNode tail;
  private int size;
  private Class listType;

  public MyLinkedList(Class listType) {
    this.listType = listType;
  }

  @Override
  public String toString() {
    MyLinkedListNode current = head;
    StringBuilder stringBuilder = new StringBuilder("[");
    while (true) {
      if (current.nextElement == null) {
        stringBuilder.append(current.element);
        break;
      }
      stringBuilder.append(current.element).append(", ");
      current = current.nextElement;
    }

    return stringBuilder.append("]").toString();
  }

  public void addFirst(Object element) {
    if (element.getClass() == listType) {
      MyLinkedListNode newNode = head;
      head = new MyLinkedListNode(element, null, head);
      if (newNode == null) {
        tail = head;
      } else {
        newNode.previousElement = head;
      }
      size++;
    } else {
      throw new FormatException(
          "The format of the " + listType + " and the passed " + element.getClass()
              + " argument do not match");
    }
  }

  public void addLast(Object element) {
    if (element.getClass() == listType) {
      MyLinkedListNode current = tail;
      tail = new MyLinkedListNode(element, tail, null);
      if (current == null) {
        head = tail;
      } else {
        current.nextElement = tail;
      }
      size++;
    } else {
      throw new FormatException(
          "The format of the " + listType + " and the passed " + element.getClass()
              + " argument do not match");
    }
  }

  public void add(Object element) {
    addLast(element);
  }
//
//  public boolean remove(int index) {
//
//  }

  public boolean isEmpty() {
    return head == null;
  }

  public int size() {
    return size;
  }

  private  class MyLinkedListNode {

    Object element;
    MyLinkedListNode nextElement;
    MyLinkedListNode previousElement;

    public MyLinkedListNode(Object element, MyLinkedListNode previousElement,
        MyLinkedListNode nextElement) {
      this.element = element;
      this.nextElement = nextElement;
      this.previousElement = previousElement;
    }
  }
}
