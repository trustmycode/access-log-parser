package practice.extracurricular.arraylist;

import java.util.Arrays;

public class MyArrayList {

  private Object[] array;
  private int size = 0;
  private int capacity = 10;

  public MyArrayList() {
    array = new Object[capacity];
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder("[");
    for (int i = 0; i < size; i++) {
      if (array[i] == null) {
        break;
      } else if (i == size - 1 || array[i + 1] == null) {
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
    if (!this.isEmpty()) {
      if (key.getClass() == array[0].getClass()) {
        array[size++] = key;
      } else {
        throw new FormatException(
            "The format of the " + array[0].getClass() + " and the passed " + key.getClass()
                + " argument do not match");
      }
    } else {
      array[size++] = key;
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
      removeObj(this.array, index);
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

  private void removeObj(Object[] array, int i) {
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

class FormatException extends RuntimeException {

  public FormatException() {
    super();
  }

  public FormatException(String s) {
    super(s);
  }
}