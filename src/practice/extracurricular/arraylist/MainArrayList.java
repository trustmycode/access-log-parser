package practice.extracurricular.arraylist;

import java.util.ArrayList;

public class MainArrayList {

  public static void main(String[] args) {
    MyArrayList myArrayList = new MyArrayList();
    System.out.println(myArrayList.isEmpty());
    myArrayList.add(2);
    System.out.println(myArrayList.size());
    System.out.println(myArrayList.isEmpty());
    myArrayList.add(2);
    System.out.println(myArrayList);
    myArrayList.add(2);
    myArrayList.add(2);
    System.out.println(myArrayList.size());
    myArrayList.add("asd");
    myArrayList.add('a');
    System.out.println(myArrayList.size());
    System.out.println(myArrayList);
    System.out.println(myArrayList.remove(10));
    System.out.println(myArrayList);
    System.out.println(myArrayList.size());
  }

}
