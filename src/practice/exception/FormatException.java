package practice.exception;


public class FormatException extends RuntimeException {

  public FormatException() {
    super();
  }

  public FormatException(String s) {
    super(s);
  }
}