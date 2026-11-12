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



@RestController 
@RequestMapping("/api/students")
public class StudentRestController {
  private List<Student> theStudents;
  private StudentService studentService;

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

  @GetMapping("/students")
  public List<Student> getStudents() {
    return theStudents;
  }
  
  @GetMapping("/students/{studentId}")
  public Student getStudent(@PathVariable int studentId) {
    if (studentId >= theStudents.size() || (studentId < 0)) {
      throw new StudentNotFoundException(
        "Student ID " + studentId + " not found!");
    }
    return theStudents.get(studentId);
  }
  
  // add students REST API
  @PostMapping
  public ResponseEntity<StudentDto> createStudents(
    @Valid @RequestBody StudentDto theStudentDto
  ) {
    StudentDto saved = studentService.createStudent(theStudentDto);
    return new ResponseEntity<>(saved, HttpStatus.CREATED);
  }

  // get student REST API
  @GetMapping("{id}")
  public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id) {
      StudentDto studentDto = studentService.getStudentById(id);
      return  ResponseEntity.ok(studentDto);
  }

  // get all student REST API
  @GetMapping
  public ResponseEntity<List<StudentDto>> getAllStudents() {
    List<StudentDto> students = studentService.getAllStudents();
    return ResponseEntity.ok(students);
  }

  // update student REST API
  @PutMapping("{id}")
  public ResponseEntity<StudentDto> updateStudent(
    @PathVariable Long id,
    @Valid @RequestBody StudentDto theStudentDto
  ) {
    StudentDto studentDto = studentService
      .updateStudent(id, theStudentDto);

    return ResponseEntity.ok(studentDto);
  }

  // patch student REST API
  @PatchMapping("{id}")
  public ResponseEntity<StudentDto> patchStudent(
    @PathVariable Long id,
    @Valid @RequestBody StudentDto theStudentDto
  ) {
    StudentDto studentDto = studentService.patchStudent(id, theStudentDto);
    return ResponseEntity.ok(studentDto);
  }

  // delete student REST API
  @DeleteMapping("{id}")
  public ResponseEntity<String> deleteStudentById (@PathVariable Long id) {
    studentService.deleteStudentById(id);
    return ResponseEntity.ok("Student deleted successfully!");
  }
}
