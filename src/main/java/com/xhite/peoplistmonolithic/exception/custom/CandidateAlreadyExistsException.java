package com.xhite.peoplistmonolithic.exception.custom;

public class CandidateAlreadyExistsException extends RuntimeException{
    public CandidateAlreadyExistsException(String message) {
        super(message);
    }
}
