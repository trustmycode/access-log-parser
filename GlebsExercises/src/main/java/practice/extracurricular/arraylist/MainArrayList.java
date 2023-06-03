package practice.extracurricular.arraylist;

public class MainArrayList {

  public static void main(String[] args) {
    MyArrayList myArrayList = new MyArrayList(Integer.class);
    myArrayList.add(2);
    myArrayList.add(2);
    myArrayList.add(2);
    myArrayList.remove(-1);
  }

}
