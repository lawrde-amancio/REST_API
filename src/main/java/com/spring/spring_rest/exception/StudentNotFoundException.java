package com.spring.spring_rest.exception;

/**
 * Unchecked exception thrown when a requested student 
 * record cannot be found in the system.
 */
public class StudentNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -2690100046087976236L;

    /**
     * Constructs a new {@code StudentNotFoundException} with 
     * the specified detail message and cause.
     *
     * @param message the detail message explaining the reason for the exception
     * @param cause   the underlying cause of this exception
     */
    public StudentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new {@code StudentNotFoundException}
     *  with the specified detail message.
     *
     * @param message the detail message explaining the reason 
     * for the exception
     */
    public StudentNotFoundException(String message) {
        super(message);
    }

    /**
     * Constructs a new {@code StudentNotFoundException} with the specified cause.
     *
     * @param cause the underlying cause of this exception
     */
    public StudentNotFoundException(Throwable cause) {
        super(cause);
    }
}
