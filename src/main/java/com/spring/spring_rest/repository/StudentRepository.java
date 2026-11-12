package com.spring.spring_rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.spring.spring_rest.entity.Student;

/**
 * Spring Data JPA repository interface for managing {@link Student} entities.
 * Provides standard CRUD operations, pagination, and sorting capabilities
 * inherited from {@link JpaRepository} for {@link Student} entities identified
 * by a {@link Long} primary key.
 */
public interface StudentRepository extends JpaRepository<Student, Long>{

}
