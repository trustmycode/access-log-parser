package ru.courses.extracurricular.linkedlist;

import java.util.NoSuchElementException;

public class MyLinkedList<E> {

  private MyLinkedListNode head;
  private MyLinkedListNode tail;
  private int size;
  static final String LIST_IS_EMPTY = "List is empty";
  static final String KEY_CANNOT_BE_NULL = "Key cannot be null";


  @Override
  public String toString() {
    MyLinkedListNode current = head;
    StringBuilder stringBuilder = new StringBuilder("[");
    while (current != null) {
      if (current.nextElement == null) {
        stringBuilder.append(current.element);
        break;
      }
      stringBuilder.append(current.element).append(", ");
      current = current.nextElement;
    }

    return stringBuilder.append("]").toString();
  }

  public boolean add(E element) {
    if (element != null) {
      addLast(element);
      return true;
    } else {
      throw new IllegalArgumentException(KEY_CANNOT_BE_NULL);
    }
  }

  public boolean add(int index, E element) {
    if (element != null) {
      if (index <= size && index >= 0) {
        if (index == 0) {
          addFirst(element);
          return true;
        } else if (index == size) {
          addLast(element);
          return true;
        } else {
          addLink(index, element);
          size++;
          return true;
        }
      }
    } else {
      throw new IllegalArgumentException(KEY_CANNOT_BE_NULL);
    }
    throw new ArrayIndexOutOfBoundsException(
        arrayIndexOutOfBoundsExceptionMsg(index));
  }

  public boolean addFirst(E element) {
    if (element != null) {
      MyLinkedListNode newNode = head;
      head = new MyLinkedListNode(element, null, head);
      if (newNode == null) {
        tail = head;
      } else {
        newNode.previousElement = head;
      }
      size++;
      return true;
    } else {
      throw new IllegalArgumentException(KEY_CANNOT_BE_NULL);
    }
  }

  public boolean addLast(E element) {
    if (element != null) {
      MyLinkedListNode current = tail;
      tail = new MyLinkedListNode(element, tail, null);
      if (current == null) {
        head = tail;
      } else {
        current.nextElement = tail;
      }
      size++;
      return true;
    } else {
      throw new IllegalArgumentException(KEY_CANNOT_BE_NULL);
    }
  }

  public E remove(int index) {
    if (index < size && index >= 0) {
      if (index == 0) {
        return removeFirst();
      } else if (index == size - 1) {
        return removeLast();
      } else {
        size--;
        return deleteLink(index);
      }
    }
    throw new ArrayIndexOutOfBoundsException(
        arrayIndexOutOfBoundsExceptionMsg(index));
  }

  public E removeLast() {
    if (!isEmpty()) {
      MyLinkedListNode current = tail;
      tail.previousElement.nextElement = null;
      tail = tail.previousElement;
      size--;
      return current.element;
    }
    throw new NoSuchElementException(LIST_IS_EMPTY);
  }

  public E removeFirst() {
    if (!isEmpty()) {
      MyLinkedListNode current = head;
      head.nextElement.previousElement = null;
      head = head.nextElement;
      size--;
      return current.element;
    }
    throw new NoSuchElementException(LIST_IS_EMPTY);
  }

  public boolean isEmpty() {
    return size() == 0;
  }

  public int size() {
    return size;
  }

  public E get(int index) {
    if (head == null) {
      throw new NoSuchElementException(LIST_IS_EMPTY);
    }
    if (index < size && index >= 0) {
      return returnNode(index).element;
    }
    throw new ArrayIndexOutOfBoundsException(
        arrayIndexOutOfBoundsExceptionMsg(index));
  }

  private String arrayIndexOutOfBoundsExceptionMsg(int index) {
    return "Index " + index + " out of bounds for length " + size;
  }

  private void addLink(int index, E element) {
    MyLinkedListNode current = returnNode(index);
    MyLinkedListNode newNode = new MyLinkedListNode(element, current.previousElement, current);
    current.previousElement.nextElement = newNode;
    current.previousElement = newNode;
  }

  private E deleteLink(int index) {
    MyLinkedListNode current = returnNode(index);
    MyLinkedListNode returnValue = returnNode(index);
    current.nextElement.previousElement = current.previousElement;
    current.previousElement.nextElement = current.nextElement;
    return returnValue.element;
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


  private class MyLinkedListNode {

    E element;
    MyLinkedListNode nextElement;
    MyLinkedListNode previousElement;

    public MyLinkedListNode(E element, MyLinkedListNode previousElement,
        MyLinkedListNode nextElement) {
      this.element = element;
      this.nextElement = nextElement;
      this.previousElement = previousElement;
    }
  }
}
