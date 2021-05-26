package spring.errorhandling.global;

public class HelloException extends RuntimeException {
  public HelloException(String message) {
    super(message);
  }
}
