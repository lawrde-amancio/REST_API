package com.spring.spring_rest.mapper;
import com.spring.spring_rest.dto.StudentDto;
import com.spring.spring_rest.entity.Student;

/**
 * Utility class providing static mapping methods to convert between
 * {@link Student} JPA entities and {@link StudentDto} data transfer objects.
 */
public class StudentMapper {

    /**
     * Converts a {@link Student} entity into a {@link StudentDto}.
     *
     * @param theStudent the {@link Student} entity to convert
     * @return a {@link StudentDto} populated with the entity's data
     */
    public static StudentDto mapToStudentDto(Student theStudent) {
        return new StudentDto (theStudent.getId(),
                                theStudent.getFirstName(),
                                theStudent.getLastName(),
                                theStudent.getEmail()
                                );
    }

    /**
     * Converts a {@link StudentDto} into a {@link Student} entity.
     *
     * @param theStudentDto the {@link StudentDto} to convert
     * @return a {@link Student} entity populated with the DTO's data
     */
    public static Student mapToStudent(StudentDto theStudentDto) {
        return new Student(theStudentDto.getId(),
                            theStudentDto.getFirstName(),
                            theStudentDto.getLastName(),
                            theStudentDto.getEmail());
    }



}
