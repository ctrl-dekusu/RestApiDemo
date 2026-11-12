package com.spring.spring_rest.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

/**
 * Data Transfer Object representing student information for API requests 
 * and responses.
 */
public class StudentDto {
  private Long id;

  @Size(min = 2, max = 50, message = "Must be 2 to 50 characters")
  private String firstName;

  @Size(min = 2, max = 50, message = "Must be 2 to 50 characters")
  private String lastName;

  @Email(message = "Email is required and should be valid")
  private String email;
  
  /**
   * Constructs a new {@code StudentDto} with all fields initialized.
   *
   * @param id the student's unique identifier
   * @param firstname the student's first name
   * @param lastname the student's last name
   * @param email the student's email address
   */
  public StudentDto(
    Long id, 
    String firstname, 
    String lastname, 
    String email
  ) {
    this.id = id;
    this.firstName = firstname;
    this.lastName = lastname;
    this.email = email;
  }

  /**
   * Returns the student's unique identifier.
   *
   * @return the student ID
   */
  public Long getId() {
    return id;
  }

  /**
   * Sets the student's unique identifier.
   *
   * @param id the student ID to set
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * Returns the student's first name.
   *
   * @return the first name
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Sets the student's first name.
   *
   * @param firstname the first name to set
   */
  public void setFirstName(String firstname) {
    this.firstName = firstname;
  }

  /**
   * Returns the student's last name.
   *
   * @return the last name
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Sets the student's last name.
   *
   * @param lastname the last name to set
   */
  public void setLastName(String lastname) {
    this.lastName = lastname;
  }

  /**
   * Returns the student's email address.
   *
   * @return the email address
   */
  public String getEmail() {
    return email;
  }

  /**
   * Sets the student's email address.
   *
   * @param email the email address to set
   */
  public void setEmail(String email) {
    this.email = email;
  }
  
}
