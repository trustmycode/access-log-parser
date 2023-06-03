package practice.extracurricular.arraylist;

import java.util.Arrays;
import practice.extracurricular.exception.FormatException;

public class MyArrayList {

  private final Class clazz;
  private Object[] array;
  private int size = 0;
  private int capacity = 10;

  public MyArrayList(Class clazz) {
    this.clazz = clazz;
    array = new Object[capacity];
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder("[");
    for (int i = 0; i < size; i++) {
      if (i == size - 1) {
        stringBuilder.append(array[i]);
        break;
      }
      stringBuilder.append(array[i]);
      stringBuilder.append(", ");
    }
    stringBuilder.append("]");
    return stringBuilder.toString();
  }

  public void add(Object key) {
    if (size == array.length) {
      capacity *= 2;
      array = Arrays.copyOf(array, capacity);
    }
    if (key != null) {
      if (key.getClass() == clazz) {
        array[size++] = key;
      } else {
        throw new FormatException(
            "The format of the " + clazz + " and the passed " + key.getClass()
                + " argument do not match");
      }
    } else {
      throw new IllegalArgumentException("Key cannot be null");
    }
  }

  public boolean contains(Object key) {
    if (isEmpty()) {
      return false;
    }
    for (Object o : array) {
      if (o.equals(key)) {
        return true;
      }
    }
    return false;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public int size() {
    return size;
  }

  public Object remove(int index) {
    if (index < size && index >= 0) {
      Object tmp = this.array[index];
      removeObj(index);
      return tmp;
    }
    throw new ArrayIndexOutOfBoundsException(
        "Index " + index + " out of bounds for length " + size);
  }

//  public boolean remove(Object key) {
//    if (contains(key)) {
//      for (int i = 0; i < array.length; i++) {
//        if (array[i].equals(key)) {
//          removeObj(array, i);
//          return true;
//        }
//      }
//    }
//    return false;
//  }

  private void removeObj(int i) {
    int j;
    if (i == size - 1) {
      this.array[i] = null;
      size--;
    } else {
      j = i + 1;
      for (; i < size - 1; i++, j++) {
        this.array[i] = this.array[j];
        if (i == size - 2) {
          this.array[j] = null;
          size--;
        }
      }
    }
  }
}
