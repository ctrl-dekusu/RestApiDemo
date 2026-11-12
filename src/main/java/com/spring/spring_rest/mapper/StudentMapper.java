package com.spring.spring_rest.mapper;

import com.spring.spring_rest.dto.StudentDto;
import com.spring.spring_rest.entity.Student;

/**
 * Utility class for converting between {@link Student} entities and 
 * {@link StudentDto} objects.
 */
public class StudentMapper {
  /**
   * Maps a {@link Student} entity to a {@link StudentDto}.
   *
   * @param theStudent the {@link Student} entity to convert
   * @return the corresponding {@link StudentDto}
   */
  // method will map Student to StudentDto
  public static StudentDto mapToStudentDto(Student theStudent) {
    return new StudentDto(theStudent.getId(), 
      theStudent.getFirstName(), 
      theStudent.getLastName(), 
      theStudent.getEmail()
    );
  }

  /**
   * Maps a {@link StudentDto} to a {@link Student} entity.
   *
   * @param theStudentDto the {@link StudentDto} to convert
   * @return the corresponding {@link Student} entity
   */
  // method will map StudentDto to Student
  public static Student mapToStudent(StudentDto theStudentDto) {
    return new Student(
      theStudentDto.getId(),
      theStudentDto.getFirstName(),
      theStudentDto.getLastName(),
      theStudentDto.getEmail()
    );
  }
}
