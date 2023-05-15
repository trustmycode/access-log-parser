import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(max3(2,2,2));
//        int a = 3;
//        switch (a) {
//            case 3:
//                System.out.println("c");
//            case 4:
//                System.out.println("d");
//            default:
//                System.out.println("err");
//        }
//        char c = 6;
//        System.out.println("hello".charAt(c));
//        float f3 = 1000;
//        int[] arr = {1, -2, -7, 4, 2, 2, 5};
//        int[] arr1 = {1, -2, -7, 4, -7, -2, 1};
//        int[] arr2 = {3, 3, 2, 2, 2, 2, 3};
//        int num = 2;
//        String s1 = "Hello world";
//        String s2 = "Hello world";
//        String s3 = "Hello" + " world";
//        String str1 = new String(s3);
//        String str2 = new String(s3).intern();
//        System.out.println(s1==s3);
//        System.out.println(findFirst(arr, num));
//        System.out.println(findLast(arr, num));
//        System.out.println(maxAbs(arr));
//        System.out.println(maxAbs(arr1));
//        System.out.println(maxAbs(arr2));
//        System.out.println(countPositive(arr));
//        System.out.println(palindrom(arr));
//        System.out.println(palindrom(arr1));
//        System.out.println(palindrom(arr2));
//        reverse(arr);
//        System.out.println();
//        System.out.println(Arrays.toString(arr));
//        System.out.println();
//        int[] res = reverseBack(arr);
//        System.out.println(Arrays.toString(res));
//        System.out.println(Arrays.toString(concat(arr, arr2)));
//        System.out.println(Arrays.toString(findAll(arr, 2)));
//        System.out.println(Arrays.toString(deleteNegative(arr)));
//        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.toString(add(arr, arr2, 5)));
//        System.out.println(0 / 0);
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
        for (int i = 0; i < arr1.length; i++) {
            res[i] = arr1[i];
        }
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

    static class asd {

    }
}