package com.spring.spring_rest.service;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import com.spring.spring_rest.repository.StudentRepository;
import com.spring.spring_rest.entity.Student;
import com.spring.spring_rest.mapper.StudentMapper;
import com.spring.spring_rest.dto.StudentDto;
import com.spring.spring_rest.exception.StudentNotFoundException;

/**
 * Default implementation of {@link StudentService} 
 * that manages {@link Student} entities
 * using {@link StudentRepository} and maps between 
 * entities and {@link StudentDto} objects.
 */
@Service 
public class StudentServiceImplementation implements StudentService{

    private StudentRepository studentRepo;
    
    /**
     * Constructs a new {@code StudentServiceImplementation} 
     * with the required repository.
     *
     * @param studentRepo the repository used for student 
     * persistence operations
     */
    public StudentServiceImplementation(StudentRepository studentRepo) {
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
     * @throws StudentNotFoundException if no student exists 
     * with the given {@code theId}
     */
    @Override 
    public StudentDto getStudentById(Long theId) {
        Student student = studentRepo.findById(theId)
        .orElseThrow(()->
                        new StudentNotFoundException("Student id " + theId +
                                                        " not found!")
                    );
        return StudentMapper.mapToStudentDto(student);
    }

    /**
     * {@inheritDoc}
     */
    @Override 
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepo.findAll();
        return students.stream().map(
            (student) -> StudentMapper.mapToStudentDto(student))
            .collect(Collectors.toList());
    }

    /**
     * {@inheritDoc}
     *
     * @throws StudentNotFoundException if no student exists 
     * with the given {@code theId}
     */
    @Override 
    public StudentDto updateStudent(Long theId, StudentDto theStudentDto) {
        Student student = studentRepo.findById(theId)
        .orElseThrow(() -> new StudentNotFoundException(
            "Student id " + theId + " not found!" ));
        student.setFirstName(theStudentDto.getFirstName());
        student.setLastName(theStudentDto.getLastName());
        student.setEmail(theStudentDto.getEmail());

        Student saved = studentRepo.save(student);
        return StudentMapper.mapToStudentDto(saved);
    }

    /**
     * {@inheritDoc}
     *
     * @throws StudentNotFoundException if no student exists 
     * with the given {@code theId}
     */
    @Override 
    public StudentDto patchStudent(Long theId, StudentDto theStudentDto) {
        Student student = studentRepo.findById(theId)
        .orElseThrow(() -> new StudentNotFoundException(
            "Student id " + theId + " not found!"));
        if(theStudentDto.getFirstName() != null ) {
            student.setFirstName(theStudentDto.getFirstName());
        }
        if (theStudentDto.getLastName() != null) {
            student.setLastName(theStudentDto.getLastName());
        }
        if(theStudentDto.getEmail() != null ) {
            student.setEmail(theStudentDto.getEmail());
        }

        Student saved = studentRepo.save(student);
        return StudentMapper.mapToStudentDto(saved);
    }

    /**
     * {@inheritDoc}
     *
     * @throws StudentNotFoundException if no student exists 
     * with the given {@code theId}
     */
    @Override 
    public void deleteStudentById(Long theId) {
        studentRepo.findById(theId)
            .orElseThrow(() -> new StudentNotFoundException(
                "Student id " + theId + " not found!"));
        studentRepo.deleteById(theId);
    }

}
