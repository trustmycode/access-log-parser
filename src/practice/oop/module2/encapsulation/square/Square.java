package practice.oop.module2.encapsulation.square;

import practice.oop.module1.Dot;

public class Square {

  private Dot topLeftCorner;
  private int squareLength;

  public Square(int topLeftCornerX, int topLeftCornerY, int squareLength) {
    topLeftCorner = new Dot(topLeftCornerX, topLeftCornerY);
    if (isPositive(squareLength)) {
      this.squareLength = squareLength;
    }
  }

  public Square(Dot topLeftCorner, int squareLength) {
    this.topLeftCorner = topLeftCorner;
    if (isPositive(squareLength)) {
      this.squareLength = squareLength;
    }
  }

  public Dot getTopLeftCorner() {
    return topLeftCorner;
  }

  public void setTopLeftCorner(Dot topLeftCorner) {
    this.topLeftCorner = topLeftCorner;
  }

  public void setTopLeftCorner(int topLeftCornerX, int topLeftCornerY) {
    topLeftCorner.xCoord = topLeftCornerX;
    topLeftCorner.yCoord = topLeftCornerY;
  }

  public int getSquareLength() {
    return squareLength;
  }

  public void setSquareLength(int squareLength) {
    if (isPositive(squareLength)) {
      this.squareLength = squareLength;
    }
  }

  private boolean isPositive(int num) {
    if (num > 0) {
      return true;
    } else {
      throw new IllegalArgumentException(
          "The length of the side of the square must always be positive");
    }
  }

  @Override
  public String toString() {
    return "Квадрат в точке " + topLeftCorner + " со стороной "
        + squareLength;
  }
}
