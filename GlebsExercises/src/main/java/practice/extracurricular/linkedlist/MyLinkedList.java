package practice.extracurricular.linkedlist;

import practice.extracurricular.exception.FormatException;

public class MyLinkedList {

  private final Class listType;
  private MyLinkedListNode head;
  private MyLinkedListNode tail;
  private int size;

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

  public void add(Object element) {
    if (element.getClass() == listType) {
      addLast(element);
    } else {
      throw new FormatException(formatExceptionMsg(element));
    }
  }

  public void add(int index, Object element) {
    if (element.getClass() == listType) {
      if (index == 0) {
        addFirst(element);
      } else if (index == size) {
        addLast(element);
      } else {
        addLink(index, element);
        size++;
      }
    } else {
      throw new FormatException(formatExceptionMsg(element));
    }
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
      throw new FormatException(formatExceptionMsg(element));
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
      throw new FormatException(formatExceptionMsg(element));
    }
  }

  public void remove(int index) {
    if (index == 0) {
      removeFirst();
      size--;
    } else if (index == size - 1) {
      removeLast();
      size--;
    } else {
      deleteLink(index);
      size--;
    }
  }

  public void removeLast() {
    tail.previousElement.nextElement = null;
    tail = tail.previousElement;
  }

  public void removeFirst() {
    head.nextElement.previousElement = null;
    head = head.nextElement;
  }

  public boolean isEmpty() {
    return size() == 0;
  }

  public int size() {
    return size;
  }

  public Object get(int index) {
    return returnNode(index).element;
  }

  private void addLink(int index, Object element) {
    MyLinkedListNode current = returnNode(index);
    MyLinkedListNode newNode = new MyLinkedListNode(element, current.previousElement, current);
    current.previousElement.nextElement = newNode;
    current.previousElement = newNode;
  }

  private void deleteLink(int index) {
    MyLinkedListNode current = returnNode(index);
    current.nextElement.previousElement = current.previousElement;
    current.previousElement.nextElement = current.nextElement;
  }

  private MyLinkedListNode returnNode(int index) {
    if (index >= 0 && index <= size - 1) {
      if (index <= size / 2) {
        return searchUp(index);
      } else if (index > size / 2) {
        return searchDown(index);
      }
    }
    throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
  }

  private MyLinkedListNode searchDown(int index) {
    MyLinkedListNode current;
    current = tail;
    while (index < size - 2) {
      current = current.previousElement;
      index += 1;
    }
    return current;
  }

  private MyLinkedListNode searchUp(int index) {
    MyLinkedListNode current;
    current = head;
    while (index > 0) {
      current = current.nextElement;
      index -= 1;
    }
    return current;
  }

  private String formatExceptionMsg(Object element) {
    return "The format of the " + listType + " and the passed " + element.getClass()
        + " argument do not match";
  }

  private static class MyLinkedListNode {

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
