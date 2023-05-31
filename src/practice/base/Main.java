package practice.base;

import java.util.Arrays;

public class Main {

  public static void main(String[] args) {
//    leftTriangle(2);
//    System.out.println();
//    leftTriangle(4);
//    System.out.println();
//    rightTriangle(5);
//    System.out.println();
//    rightTriangle(7);
  }

  public static int findFirst(int[] arr, int x) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == x) {
        return i;
      }
    }
    return -1;
  }

  public static int findLast(int[] arr, int x) {
    for (int i = arr.length - 1; i >= 0; i--) {
      if (arr[i] == x) {
        return i;
      }
    }
    return -1;
  }

  public static int maxAbs(int[] arr) {
    int max = Integer.MIN_VALUE;
    for (int j : arr) {
      if (Math.abs(j) > Math.abs(max)) {
        max = j;
      }
    }
    return max;
  }

  public static int countPositive(int[] arr) {
    int count = 0;
    for (int i : arr) {
      if (i > 0) {
        count++;
      }
    }
    return count;
  }

  public static boolean palindrom(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] != arr[arr.length - 1 - i]) {
        return false;
      }
    }
    return true;
  }

  public static void reverse(int[] arr) {
    int temp = 0;
    for (int i = 0; i < arr.length / 2; i++) {
      temp = arr[i];
      arr[i] = arr[arr.length - 1 - i];
      arr[arr.length - 1 - i] = temp;
    }
    System.out.println(Arrays.toString(arr));
  }

  public static int[] reverseBack(int[] arr) {
    int[] res = new int[arr.length];
    for (int i = 0; i < arr.length; i++) {
      res[i] = arr[arr.length - 1 - i];
    }
    return res;
  }

  public static int[] concat(int[] arr1, int[] arr2) {
    int[] res = new int[arr2.length + arr1.length];
    int j = arr1.length;
    System.arraycopy(arr1, 0, res, 0, arr1.length);
    for (int k : arr2) {
      res[j] = k;
      j++;
    }
    return res;
  }

  public static int[] findAll(int[] arr, int x) {
    int n = 0;
    for (int i : arr) {
      if (i == x) {
        n++;
      }
    }
    int[] res = new int[n];
    int j = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == x) {
        res[j] = i;
        j++;
      }
    }
    return res;
  }

  public static int[] deleteNegative(int[] arr) {
    int n = 0;
    for (int i : arr) {
      if (i > 0) {
        n++;
      }
    }
    int[] res = new int[n];
    int j = 0;
    for (int i : arr) {
      if (i >= 0) {
        res[j] = i;
        j++;
      }
    }
    return res;
  }

  public static int[] add(int[] arr, int x, int pos) {
    int[] res = new int[arr.length + 1];
    int j = 0;
    for (int i = 0; i < res.length; i++) {
      if (i != pos) {
        res[i] = arr[j];
        j++;
      } else {
        res[i] = x;
      }
    }
    return res;
  }

  public static int[] add(int[] arr, int[] ins, int pos) {
    int[] res = new int[arr.length + ins.length];
    int j = 0;
    for (int i = 0; i < res.length; i++) {
      if (i != pos) {
        res[i] = arr[j];
        j++;
      } else {
        for (int in : ins) {
          res[i] = in;
          i++;
        }
        i--;
      }
    }
    return res;
  }

  public static int max3(int x, int y, int z) {
    if (x >= y && x >= z) {
      return x;
    } else if (y >= x && y >= z) {
      return y;
    } else {
      return z;
    }
  }

  public static boolean is2Digits(int x) {
    return (x > 9 && x < 100) || (x > -100 && x < -9);
  }

  public static boolean isDivisor(int a, int b) {
    if (a == 0 || b == 0) {
      return true;
    }
    return a % b == 0 || b % a == 0;
  }

  public static int pow(int x, int y) {
    if (y == 0) {
      return 1;
    } else if (y == 1) {
      return x;
    } else {
      return x * (pow(x, y - 1));
    }
  }

  public static void square(int x) {
    for (int i = 0; i < x; i++) {
      for (int j = 0; j < x; j++) {
        if (j != x - 1) {
          System.out.print("*\t");
        } else {
          System.out.print("*");
        }
      }
      System.out.println();
    }
  }

  public static void leftTriangle(int x) {
    for (int i = 0; i < x; i++) {
      for (int j = 0; j <= i; j++) {
        if (j != i) {
          System.out.print("*\t");
        } else {
          System.out.print("*");
        }
      }
      System.out.println();
    }
  }

  public static void rightTriangle(int x) {
    for (int i = 0; i < x; i++) {
      for (int j = 0; j <= x - 1; j++) {
        if (j >= x - 1 - i) {
          System.out.print("*");
        }
        if (j != x - 1) {
          System.out.print("\t");
        } else {
          System.out.print("");
        }
      }
      System.out.println();
    }
  }
}