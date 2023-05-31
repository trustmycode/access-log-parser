package practice.extracurricular.arraylist;

import java.util.Arrays;

public class MyArrayList {

  private Object[] array;
  private int k = 0;

  public MyArrayList() {
    array = new Object[0];
  }

  @Override
  public String toString() {
    return Arrays.toString(array);
  }

  public void add(Object key) {
    if (k == array.length) {
      k++;
      array = Arrays.copyOf(array, k);
    }
    array[k - 1] = key;
  }

  public Object remove(int index) {
    if (index < k) {
      Object tmp = this.array[index];
      removeObj(this.array, index);
      return tmp;
    } else {
      throw new ArrayIndexOutOfBoundsException("Index " + index + " out of bounds for length " + k);
    }
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
    return k == 0;
  }

  public int size() {
      return k;
  }

  private void removeObj(Object[] array, int i) {
    Object[] bufArray = Arrays.copyOfRange(array, i + 1, k);
    if (i == 0) {
      this.array = bufArray;
    } else {
      int j = 0;
      for (; j < bufArray.length; i++, j++) {
        this.array[i] = bufArray[j];
      }
      k--;
      this.array = Arrays.copyOf(this.array, k);
    }
  }
}