package com.spring.spring_rest.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.spring.spring_rest.dto.StudentDto;
import com.spring.spring_rest.entity.Student;
import com.spring.spring_rest.exception.StudentNotFoundException;
import com.spring.spring_rest.mapper.StudentMapper;
import com.spring.spring_rest.repository.StudentRepository;

/**
 * Implementation of {@link StudentService} handling student persistence 
 * and business logic.
 */
@Service 
public class StudentServiceImplement implements StudentService {
  private StudentRepository studentRepo;

  /**
   * Constructs a {@code StudentServiceImplement} with the required 
   * {@link StudentRepository}.
   *
   * @param studentRepo the repository used for student data access
   */
  public StudentServiceImplement(StudentRepository studentRepo) {
    this.studentRepo = studentRepo;
  }
  
  /**
   * {@inheritDoc}
   */
  @Override 
  public StudentDto createStudent(StudentDto theStudentDto) {
    Student theStudent = StudentMapper.mapToStudent(theStudentDto);
    Student saved = studentRepo.save(theStudent);

    return StudentMapper.mapToStudentDto(saved);
  }

  /**
   * {@inheritDoc}
   *
   * @throws StudentNotFoundException if no student exists with the given ID
   */
  @Override 
  public StudentDto getStudentById(Long theId) {
    Student student = studentRepo.findById(theId)
              .orElseThrow(() -> new StudentNotFoundException(
                "Student ID " + theId + " not found!"
              ));

    return StudentMapper.mapToStudentDto(student);
  }

  /**
   * {@inheritDoc}
   */
  @Override 
  public List<StudentDto> getAllStudents() {
    List<Student> students = studentRepo.findAll();
    return students.stream()
      .map((student) -> StudentMapper.mapToStudentDto(student))
      .collect(Collectors.toList()); 
  }

  /**
   * {@inheritDoc}
   *
   * @throws StudentNotFoundException if no student exists with the given ID
   */
  @Override 
  public StudentDto updateStudent(Long theId, StudentDto theStudentDto) {
    Student student = studentRepo.findById(theId)
              .orElseThrow(() -> new StudentNotFoundException(
                "Student ID " + theId + " not found!"
              ));
    
    student.setFirstName(theStudentDto.getFirstName());
    student.setLastName(theStudentDto.getLastName());
    student.setEmail(theStudentDto.getEmail());

    Student saved = studentRepo.save(student);
    return StudentMapper.mapToStudentDto(saved);
  }

  /**
   * {@inheritDoc}
   *
   * @throws StudentNotFoundException if no student exists with the given ID
   */
  @Override 
  public StudentDto patchStudent(Long theId, StudentDto theStudentDto) {
    Student student = studentRepo.findById(theId)
              .orElseThrow(() -> new StudentNotFoundException(
                "Student ID " + theId + " not found!"
              ));
    if (theStudentDto.getFirstName() != null) {
      student.setFirstName(theStudentDto.getFirstName());
    }
    if (theStudentDto.getLastName() != null) {
      student.setLastName(theStudentDto.getLastName());
    }
    if (theStudentDto.getEmail() != null) {
      student.setEmail(theStudentDto.getEmail());
    }

    Student saved = studentRepo.save(student);
    return StudentMapper.mapToStudentDto(saved);
  }

  /**
   * {@inheritDoc}
   *
   * @throws StudentNotFoundException if no student exists with the given ID
   */
  @Override 
  public void deleteStudentById(Long theId) {
    studentRepo.findById(theId)
              .orElseThrow(() -> new StudentNotFoundException(
                "Student ID " + theId + " not found!"
              ));

    studentRepo.deleteById(theId);
  }
}
