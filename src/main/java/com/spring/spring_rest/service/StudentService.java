package com.spring.spring_rest.service;
import com.spring.spring_rest.dto.StudentDto;
import java.util.List;

/**
 * Service interface defining business operations for managing resources.
 */
public interface StudentService {

    /**
     * Creates and persists a new student record.
     *
     * @param theStudentDto the data transfer object 
     * containing the student details to save
     * @return the created {@link StudentDto}, 
     * including any generated identifiers
     */
    StudentDto createStudent(StudentDto theStudentDto);

    /**
     * Retrieves a single student by their unique identifier.
     *
     * @param theId the unique ID of the student to retrieve
     * @return the matching {@link StudentDto}
     */
    StudentDto getStudentById(Long theId);

    /**
     * Retrieves all existing student records.
     *
     * @return a {@link List} of all {@link StudentDto} objects, 
     * or an empty list if none exist
     */
    List<StudentDto> getAllStudents();

    /**
     * Performs a full update of an existing student record.
     *
     * @param theId         the unique ID of the student to update
     * @param theStudentDto the data transfer object containing 
     * the updated student fields
     * @return the updated {@link StudentDto}
     */
    StudentDto updateStudent(Long theId, StudentDto theStudentDto);

    /**
     * Performs a partial update of an existing student record, 
     * modifying only non-null fields.
     *
     * @param theId         the unique ID of the student to patch
     * @param theStudentDto the data transfer object 
     * containing the fields to modify
     * @return the updated {@link StudentDto}
     */
    StudentDto patchStudent(Long theId, StudentDto theStudentDto);

    /**
     * Deletes a student record by their unique identifier.
     *
     * @param theId the unique ID of the student to delete
     */
    void deleteStudentById(Long theId);
}
