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
    for (int i = 0; i < array.length; i++) {
      if (array[i] == null) {
        break;
      } else if (i == array.length - 1 || array[i + 1] == null) {
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
    array[size] = key;
    size++;
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
    Object[] bufArray = Arrays.copyOfRange(array, i + 1, size);
    if (i == 0) {
      this.array = bufArray;
    } else {
      int j = 0;
      for (; j < bufArray.length; i++, j++) {
        this.array[i] = bufArray[j];
      }
      size--;
      this.array = Arrays.copyOf(this.array, size);
    }
  }
}