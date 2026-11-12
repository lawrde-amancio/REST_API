package com.spring.spring_rest.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import com.spring.spring_rest.dto.StudentDto;
import com.spring.spring_rest.service.StudentService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

/**
 * REST controller exposing CRUD endpoints for managing resources
 * under the {@code /api/students} base path.
 */
@RestController 
@RequestMapping ("/api/students")
public class StudentRestController {

    private StudentService studentService;

    public StudentRestController(StudentService studentService) {
        this.studentService = studentService;
    }

    /**
     * Creates a new student record from the provided request payload.
     *
     * @param theStudentDto the validated student data to persist
     * @return a {@link ResponseEntity} containing the created 
     *         with HTTP status {@code 201 Created}
     */
    @PostMapping 
    public ResponseEntity<StudentDto> createStudent(
        @Valid @RequestBody StudentDto theStudentDto) {
        StudentDto saved = studentService.createStudent(theStudentDto);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    /**
     * Retrieves a single student by their unique identifier.
     *
     * @param id the unique ID of the student to retrieve
     * @return a {@link ResponseEntity} containing the matching 
     *         with HTTP status {@code 200 OK}
     */
    @GetMapping("{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id) {
        StudentDto studentDto = studentService.getStudentById(id);
        return ResponseEntity.ok(studentDto);
    }

    /**
     * Retrieves all existing student records.
     *
     * @return a {@link ResponseEntity} containing a of all objects
     *         with HTTP status {@code 200 OK}
     */
    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudents(){
        List<StudentDto> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    /**
     * Performs a full update of an existing student record.
     *
     * @param id            the unique ID of the student to update
     * @param theStudentDto the validated student data containing 
     * the updated fields
     * @return a {@link ResponseEntity} containing the updated
     *         with HTTP status {@code 200 OK}
     */
    @PutMapping("{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable Long id,
            @Valid @RequestBody StudentDto theStudentDto) {
        StudentDto studentDto = studentService.updateStudent(
            id, theStudentDto);
        return ResponseEntity.ok(studentDto);
    }

    /**
     * Performs a partial update of an existing student record, 
     * modifying only provided fields.
     *
     * @param id            the unique ID of the student to patch
     * @param theStudentDto the validated student data 
     * containing the fields to modify
     * @return a {@link ResponseEntity} containing the updated 
     *         with HTTP status {@code 200 OK}
     */
    @PatchMapping("{id}")
    public ResponseEntity<StudentDto> patchStudent(@PathVariable Long id,
            @Valid @RequestBody StudentDto theStudentDto) {
        StudentDto studentDto = studentService.patchStudent(id, theStudentDto);
        return ResponseEntity.ok(studentDto);
    }

    /**
     * Deletes a student record by their unique identifier.
     *
     * @param id the unique ID of the student to delete
     * @return a {@link ResponseEntity} containing a confirmation message
     *         with HTTP status {@code 200 OK}
     */
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable Long id) {
        studentService.deleteStudentById(id);
        return ResponseEntity.ok("Student deleted successfully!");
    }
}