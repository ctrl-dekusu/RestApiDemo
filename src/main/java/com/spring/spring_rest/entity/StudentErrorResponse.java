package com.spring.spring_rest.entity;

/**
 * Payload model representing structured error details returned by 
 * REST exception handlers.
 */
public class StudentErrorResponse {
  private int status;
  private String message;
  private long timeStamp;

  /**
   * Default no-argument constructor.
   */
  public StudentErrorResponse() {}

  /**
   * Constructs a new {@code StudentErrorResponse} with the given error 
   * details.
   *
   * @param status the HTTP status code
   * @param message a descriptive error message
   * @param timeStamp the epoch timestamp in milliseconds when the error 
   * occurred
   */
  public StudentErrorResponse(int status, String message, long timeStamp) {
    this.status = status;
    this.message = message;
    this.timeStamp = timeStamp;
  }

  /**
   * Returns the HTTP status code.
   *
   * @return the status code
   */
  public int getStatus() {
    return status;
  }

  /**
   * Sets the HTTP status code.
   *
   * @param status the status code to set
   */
  public void setStatus(int status) {
    this.status = status;
  }

  /**
   * Returns the error message.
   *
   * @return the error message
   */
  public String getMessage() {
    return message;
  }

  /**
   * Sets the error message.
   *
   * @param message the error message to set
   */
  public void setMessage(String message) {
    this.message = message;
  }

  /**
   * Returns the timestamp of the error occurrence.
   *
   * @return the epoch timestamp in milliseconds
   */
  public long getTimeStamp() {
    return timeStamp;
  }

  /**
   * Sets the timestamp of the error occurrence.
   *
   * @param timeStamp the epoch timestamp in milliseconds to set
   */
  public void setTimeStamp(long timeStamp) {
    this.timeStamp = timeStamp;
  }

  /**
   * Returns a string representation of the {@code StudentErrorResponse}.
   *
   * @return a formatted string containing status, message, and timestamp
   */
  @Override
  public String toString() {
    return "StudentErrorResponse [status = " + getStatus() 
        + ", message = " + getMessage() 
        + ", timeStamp = " + getTimeStamp() + "]";
  }
  
}
