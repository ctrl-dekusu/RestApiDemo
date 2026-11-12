package com.spring.spring_rest.exception;

/**
 * Unchecked exception thrown when a requested student cannot be located.
 */
public class StudentNotFoundException extends RuntimeException {
  private static final long serialVersionUID = -2690100046087976236L;

  /**
   * Constructs a new {@code StudentNotFoundException} with the specified 
   * detail message and cause.
   *
   * @param message the detail message
   * @param cause the cause of the exception
   */
  public StudentNotFoundException(String message, Throwable cause) {
    super(message, cause);
    // TODO Auto-generated constructor stub
  }

  /**
   * Constructs a new {@code StudentNotFoundException} with the specified 
   * detail message.
   *
   * @param message the detail message
   */
  public StudentNotFoundException(String message) {
    super(message);
    // TODO Auto-generated constructor stub
  }

  /**
   * Constructs a new {@code StudentNotFoundException} with the specified 
   * cause.
   *
   * @param cause the cause of the exception
   */
  public  StudentNotFoundException(Throwable cause) {
    super(cause);
    // TODO Auto-generated constructor stub
  }

}
