package com.spring.spring_rest.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * JPA entity mapped to the {@code student} database table.
 */
@Entity 
@Table(name="student")
public class Student {
  @Id 
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;
  
  @Column(name = "first_name", nullable = false)
  private String firstName;

  @Column(name = "last_name", nullable = false)
  private String lastName;

  @Column(name = "email", nullable = false, unique = true)
  private String email;

  /**
   * Default no-argument constructor required by JPA.
   */
  public Student() {}

  /**
   * Constructs a new {@code Student} entity with the specified attributes.
   *
   * @param id the unique identifier of the student
   * @param firstName the student's first name
   * @param lastName the student's last name
   * @param email the student's unique email address
   */
  public Student(Long id, String firstName, String lastName, String email) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
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
   * @param firstName the first name to set
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
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
   * @param lastName the last name to set
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
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

  /**
   * Returns a string representation of the {@code Student} entity.
   *
   * @return a formatted string containing the student's ID, 
   * first name, last name, and email
   */
  @Override
  public String toString() {
    return "Student [id = " + getId() 
        + ", firstName = " + getFirstName() 
        + ", lastName = " + getLastName() 
        + ", email = " + getEmail() + "]";
  }
  
}
