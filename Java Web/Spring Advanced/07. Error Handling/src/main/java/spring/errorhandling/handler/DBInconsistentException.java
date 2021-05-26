package spring.errorhandling.handler;

public class DBInconsistentException extends RuntimeException {
  public DBInconsistentException(String message) {
    super(message);
  }
}
