package edu.du.project1008.service;

public class IdGenerationFailedException extends RuntimeException {
    public IdGenerationFailedException(String message) {
        super(message);
    }
}
