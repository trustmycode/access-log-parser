package practice.oop.module2.encapsulation.fraction;

public class Fraction {

  private final int numerator;
  private final int denominator;

  public Fraction(int numerator, int denominator) {
    if (denominator <= 0) {
      throw new IllegalArgumentException("Denominator must be greater than zero");
    }
    this.denominator = denominator;
    this.numerator = numerator;
  }

  @Override
  public String toString() {
    return numerator + "/" + denominator;
  }

  public int getNumerator() {
    return numerator;
  }

  public int getDenominator() {
    return denominator;
  }

  public Fraction sum(Fraction summation) {
    int commonDenom = denominator * summation.denominator;
    int thisNumerator = this.numerator * summation.denominator;
    int summationNumerator = summation.numerator * denominator;
    int sumNumerator = thisNumerator + summationNumerator;
    int gcd = gcd(sumNumerator, commonDenom);
    sumNumerator /= gcd;
    commonDenom /= gcd;
    return new Fraction(sumNumerator, commonDenom);
  }

  public Fraction sum(int summation) {
    return sum(new Fraction(summation, 1));
  }

  public Fraction minus(Fraction subtrahend) {
    return sum(new Fraction(-subtrahend.numerator, subtrahend.denominator));
  }

  public Fraction minus(int subtrahend) {
    return minus(new Fraction(subtrahend, 1));
  }


  private int gcd(int numerator, int denominator) {
    while (denominator != 0) {
      int tmp = numerator % denominator;
      numerator = denominator;
      denominator = tmp;
    }
    return Math.abs(numerator);
  }
}
