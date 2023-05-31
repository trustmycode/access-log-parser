package practice.oop.module2.encapsulation.square;

import practice.oop.module1.Dot;

public class Main {

  public static void main(String[] args) {
    Dot dot = new Dot(3, 5);

    Square square1 = new Square(2, 5, 5);
    Square square2 = new Square(dot, 5);

    System.out.println(square1);
    System.out.println(square2);

    dot.xCoord = 2;

    square2.setSquareLength(10);

    System.out.println(square2);
    System.out.println(square2.getSquareLength());
    System.out.println(square2.getTopLeftCorner());
  }
}
