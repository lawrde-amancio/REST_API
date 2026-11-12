package com.spring.spring_rest.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;

/**
 * JPA entity representing a student record mapped to the database table.
 */
@Entity 
@Table (name = "student")
public class Student {

    /**
     * Unique auto-generated primary key identifier for the student.
     */
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The student's given name. Cannot be null.
     */
    @Column (name = "first_name", nullable = false)
    private String firstName;

    /**
     * The student's family name. Cannot be null.
     */
    @Column (name = "last_name", nullable = false)
    private String lastName;

    /**
     * The student's unique email address. Cannot be null.
     */
    @Column (name = "email", nullable = false, unique = true)
    private String email;

    public Student(){}

    /**
     * Constructs a new {@code Student} with all fields initialized.
     *
     * @param id        the unique identifier of the student
     * @param firstName the student's first name
     * @param lastName  the student's last name
     * @param email     the student's unique email address
     */
    public Student(Long id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
