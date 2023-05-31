package practice.oop.module2.encapsulation.fraction;


public class Main {

  public static void main(String[] args) {
    Fraction fraction1 = new Fraction(1, 3);
    Fraction fraction2 = new Fraction(2, 5);
    Fraction fraction3 = new Fraction(7, 8);
    System.out.println(fraction1.sum(fraction2).sum(fraction3).minus(5));
  }
}
