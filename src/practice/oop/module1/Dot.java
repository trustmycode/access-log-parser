package practice.oop.module1;

public class Dot {

  public final int xCoord;
  public final int yCoord;

  public Dot(int xCoord, int yCoord) {
    this.xCoord = xCoord;
    this.yCoord = yCoord;
  }

  @Override
  public String toString() {
    return "(" + xCoord + ";" + yCoord + ")";
  }
}
