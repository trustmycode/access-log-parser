package ru.courses.extracurricular.arraylist;

import java.util.Arrays;

public class MyArrayList<T> {

  private T[] array;
  private int size = 0;
  private int capacity = 10;

  public MyArrayList() {
    array = (T[]) new Object[capacity];
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

  public void add(T key) {
    if (key != null) {
      if (size == array.length) {
        capacity *= 2;
        array = Arrays.copyOf(array, capacity);
      }
      array[size++] = key;
    } else {
      throw new IllegalArgumentException("Key cannot be null");
    }
  }

  public boolean contains(T key) {
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

  public T remove(int index) {
    if (index < size && index >= 0) {
      T tmp = this.array[index];
      removeObj(index);
      return tmp;
    }
    throw new ArrayIndexOutOfBoundsException(
        "Index " + index + " out of bounds for length " + size);
  }

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
