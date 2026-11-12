package com.spring.spring_rest.service;

import java.util.List;

import com.spring.spring_rest.dto.StudentDto;

/**
 * Service interface defining business operations for managing students.
 */
public interface StudentService {

  /**
   * Creates and persists a new student.
   *
   * @param theStudentDto the student data to save
   * @return the persisted {@link StudentDto}
   */
  StudentDto createStudent(StudentDto theStudentDto);

  /**
   * Retrieves a student by their unique identifier.
   *
   * @param theId the ID of the student to retrieve
   * @return the matching {@link StudentDto}
   */
  StudentDto getStudentById(Long theId);

  /**
   * Retrieves all students.
   *
   * @return a list of all {@link StudentDto} records
   */
  List<StudentDto> getAllStudents();

  /**
   * Replaces all fields of an existing student with the provided data.
   *
   * @param theId the ID of the student to update
   * @param theStudentDto the updated student data
   * @return the updated {@link StudentDto}
   */
  StudentDto updateStudent(Long theId, StudentDto theStudentDto);

  /**
   * Partially updates non-null fields of an existing student.
   *
   * @param theId the ID of the student to patch
   * @param thStudentDto the partial student data to apply
   * @return the patched {@link StudentDto}
   */
  StudentDto patchStudent(Long theId, StudentDto thStudentDto);

  /**
   * Deletes a student by their unique identifier.
   *
   * @param theId the ID of the student to delete
   */
  void deleteStudentById(Long theId);
}
