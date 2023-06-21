package practice.extracurricular.linkedlist;

import java.util.NoSuchElementException;
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

  public boolean add(Object element) {
    if (element != null) {
      if (element.getClass() == listType) {
        addLast(element);
        return true;
      } else {
        throw new FormatException(formatExceptionMsg(element));
      }
    } else {
      throw new IllegalArgumentException(getKeyCannotBeNull());
    }
  }

  public boolean add(int index, Object element) {
    if (element != null) {
      if (index <= size && index >= 0) {
        if (element.getClass() == listType) {
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
        } else {
          throw new FormatException(formatExceptionMsg(element));
        }
      }
    } else {
      throw new IllegalArgumentException(getKeyCannotBeNull());
    }
    throw new ArrayIndexOutOfBoundsException(
        "Index " + index + " out of bounds for length " + size);
  }

  public boolean addFirst(Object element) {
    if (element != null) {
      if (element.getClass() == listType) {
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
        throw new FormatException(formatExceptionMsg(element));
      }
    } else {
      throw new IllegalArgumentException(getKeyCannotBeNull());
    }
  }

  public boolean addLast(Object element) {
    if (element != null) {
      if (element.getClass() == listType) {
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
        throw new FormatException(formatExceptionMsg(element));
      }
    } else {
      throw new IllegalArgumentException(getKeyCannotBeNull());
    }
  }

  public Object remove(int index) {
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
        "Index " + index + " out of bounds for length " + size);
  }

  public Object removeLast() {
    if (!isEmpty()) {
      MyLinkedListNode current = tail;
      tail.previousElement.nextElement = null;
      tail = tail.previousElement;
      size--;
      return current.element;
    }
    throw new NoSuchElementException("List is empty");
  }

  public Object removeFirst() {
    if (!isEmpty()) {
      MyLinkedListNode current = head;
      head.nextElement.previousElement = null;
      head = head.nextElement;
      size--;
      return current.element;
    }
    throw new NoSuchElementException("List is empty");
  }

  public boolean isEmpty() {
    return size() == 0;
  }

  public int size() {
    return size;
  }

  public Object get(int index) {
    if (head == null) {
      throw new NoSuchElementException("List is empty");
    }
    if (index < size && index >= 0) {
      return returnNode(index).element;
    }
    throw new ArrayIndexOutOfBoundsException(
        "Index " + index + " out of bounds for length " + size);
  }

  private void addLink(int index, Object element) {
    MyLinkedListNode current = returnNode(index);
    MyLinkedListNode newNode = new MyLinkedListNode(element, current.previousElement, current);
    current.previousElement.nextElement = newNode;
    current.previousElement = newNode;
  }

  private Object deleteLink(int index) {
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

  private String formatExceptionMsg(Object element) {
    return "The format of the " + listType + " and the passed " + element.getClass()
        + " argument do not match";
  }

  private String getKeyCannotBeNull() {
    return "Key cannot be null";
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
