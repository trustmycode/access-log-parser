package practice.oop.module1.line;

import practice.oop.module1.Dot;

public class Main {

  public static void main(String[] args) {
    Dot beginFirstLine = new Dot(1, 3);
    Dot endFirstLine = new Dot(5, 8);
    Line firstLine = new Line(beginFirstLine, endFirstLine);

    Dot beginSecondLine = new Dot(10, 11);
    Dot endSecondLine = new Dot(15, 19);
    Line secondLine = new Line(beginSecondLine, endSecondLine);

    Dot beginThirdLine = endFirstLine;
    Dot endThirdLine = beginSecondLine;
    Line thirdLine = new Line(beginThirdLine, endThirdLine);

    System.out.println(thirdLine);

    beginSecondLine.xCoord = 9;
    beginSecondLine.yCoord = 15;
    endFirstLine.xCoord = 7;
    endFirstLine.yCoord = 2;

    System.out.println(thirdLine);

    System.out.println(firstLine.lineLength());
    System.out.println(secondLine.lineLength());
    System.out.println(thirdLine.lineLength());
  }
}
