package com.spring.spring_rest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.spring_rest.dto.StudentDto;
import com.spring.spring_rest.entity.Student;
import com.spring.spring_rest.exception.StudentNotFoundException;
import com.spring.spring_rest.service.StudentService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


/**
 * REST controller exposing CRUD endpoints for managing 
 * {@link Student} resources.
 */
@RestController 
@RequestMapping("/api/students")
public class StudentRestController {
  private List<Student> theStudents;
  private StudentService studentService;

  /**
   * Constructs a {@code StudentRestController} with the specified 
   * {@link StudentService}.
   *
   * @param studentService the service layer handling student business logic
   */
  public StudentRestController(StudentService studentService) {
    this.studentService = studentService;
  }

  // @PostConstruct
  // public void initialize() {
  //   theStudents = new ArrayList<>();

  //   theStudents.add(new Student("Light", "Yagami"));
  //   theStudents.add(new Student("Leslie", "Andrews"));
  //   theStudents.add(new Student("Emma", "Baumgarten"));
  // }

  /**
   * Retrieves the in-memory list of students.
   *
   * @return a list of {@link Student} entities
   */
  @GetMapping("/students")
  public List<Student> getStudents() {
    return theStudents;
  }
  
  /**
   * Retrieves a student from the in-memory list by index.
   *
   * @param studentId the index of the student in the list
   * @return the matching {@link Student} entity
   * @throws StudentNotFoundException if the index is negative or 
   * out of bounds
   */
  @GetMapping("/students/{studentId}")
  public Student getStudent(@PathVariable int studentId) {
    if (studentId >= theStudents.size() || (studentId < 0)) {
      throw new StudentNotFoundException(
        "Student ID " + studentId + " not found!");
    }
    return theStudents.get(studentId);
  }
  
  /**
   * Creates a new student record.
   *
   * @param theStudentDto the validated {@link StudentDto} payload
   * @return a {@link ResponseEntity} containing the saved 
   * {@link StudentDto} and HTTP 201 Created status
   */
  @PostMapping
  public ResponseEntity<StudentDto> createStudents(
    @Valid @RequestBody StudentDto theStudentDto
  ) {
    StudentDto saved = studentService.createStudent(theStudentDto);
    return new ResponseEntity<>(saved, HttpStatus.CREATED);
  }

  /**
   * Retrieves a student by their unique database ID.
   *
   * @param id the unique identifier of the student
   * @return a {@link ResponseEntity} containing the 
   * {@link StudentDto} and HTTP 200 OK status
   */
  @GetMapping("{id}")
  public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id) {
      StudentDto studentDto = studentService.getStudentById(id);
      return  ResponseEntity.ok(studentDto);
  }

  /**
   * Retrieves all persisted student records.
   *
   * @return a {@link ResponseEntity} containing a list of all 
   * {@link StudentDto} objects and HTTP 200 OK status
   */
  @GetMapping
  public ResponseEntity<List<StudentDto>> getAllStudents() {
    List<StudentDto> students = studentService.getAllStudents();
    return ResponseEntity.ok(students);
  }

  /**
   * Fully updates an existing student record by ID.
   *
   * @param id the unique identifier of the student to update
   * @param theStudentDto the validated {@link StudentDto} containing 
   * updated fields
   * @return a {@link ResponseEntity} containing the updated 
   * {@link StudentDto} and HTTP 200 OK status
   */
  @PutMapping("{id}")
  public ResponseEntity<StudentDto> updateStudent(
    @PathVariable Long id,
    @Valid @RequestBody StudentDto theStudentDto
  ) {
    StudentDto studentDto = studentService
      .updateStudent(id, theStudentDto);

    return ResponseEntity.ok(studentDto);
  }

  /**
   * Partially updates an existing student record by ID.
   *
   * @param id the unique identifier of the student to patch
   * @param theStudentDto the validated {@link StudentDto} 
   * containing fields to modify
   * @return a {@link ResponseEntity} containing the patched 
   * {@link StudentDto} and HTTP 200 OK status
   */
  @PatchMapping("{id}")
  public ResponseEntity<StudentDto> patchStudent(
    @PathVariable Long id,
    @Valid @RequestBody StudentDto theStudentDto
  ) {
    StudentDto studentDto = studentService.patchStudent(id, theStudentDto);
    return ResponseEntity.ok(studentDto);
  }

  /**
   * Deletes a student record by ID.
   *
   * @param id the unique identifier of the student to delete
   * @return a {@link ResponseEntity} containing a confirmation 
   * message and HTTP 200 OK status
   */
  @DeleteMapping("{id}")
  public ResponseEntity<String> deleteStudentById (@PathVariable Long id) {
    studentService.deleteStudentById(id);
    return ResponseEntity.ok("Student deleted successfully!");
  }
}
