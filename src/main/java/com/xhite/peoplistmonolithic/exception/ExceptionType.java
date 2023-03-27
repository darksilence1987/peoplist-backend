package com.xhite.peoplistmonolithic.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ExceptionType {
    UNEXPECTED_ERROR(1000, "exception.general.unexpected", INTERNAL_SERVER_ERROR),
    CANDIDATE_NOT_FOUND(1001, "exception.candidate.notFound", HttpStatus.NOT_FOUND),
    CANDIDATE_ALREADY_EXISTS(1002, "exception.candidate.alreadyExists", HttpStatus.CONFLICT),
    CANDIDATE_STATUS_NOT_FOUND(1003, "exception.candidate.statusNotFound", HttpStatus.NOT_FOUND),
    CANDIDATE_INTERACTION_NOT_FOUND(1004, "exception.candidate.interactionNotFound", HttpStatus.NOT_FOUND),
    CANDIDATE_INTERACTION_ALREADY_EXISTS(1005, "exception.candidate.interactionAlreadyExists", HttpStatus.CONFLICT),
    CANDIDATE_INTERACTION_STATUS_NOT_FOUND(1006, "exception.candidate.interactionStatusNotFound", HttpStatus.NOT_FOUND),
    CANDIDATE_INTERACTION_TYPE_NOT_FOUND(1007, "exception.candidate.interactionTypeNotFound", HttpStatus.NOT_FOUND),
    CANDIDATE_INTERACTION_TYPE_ALREADY_EXISTS(1008, "exception.candidate.interactionTypeAlreadyExists", HttpStatus.CONFLICT),
    CANDIDATE_INTERACTION_TYPE_NOT_FOUND_BY_NAME(1009, "exception.candidate.interactionTypeNotFoundByName", HttpStatus.NOT_FOUND),
    CANDIDATE_INTERACTION_TYPE_NOT_FOUND_BY_ID(1010, "exception.candidate.interactionTypeNotFoundById", HttpStatus.NOT_FOUND),
    UNAUTHORIZED_OPERATION(1011, "exception.general.unauthorized", HttpStatus.UNAUTHORIZED),
    INVALID_INTERACTION_TYPE(1012, "exception.candidate.interactionTypeNotValid", HttpStatus.BAD_REQUEST),
    INVALID_STATUS_TYPE(1013, "exception.candidate.statusTypeNotValid", HttpStatus.BAD_REQUEST),
    INVALID_CANDIDATE_NAME(1014, "exception.candidate.candidateNameNotValid", HttpStatus.BAD_REQUEST),
    INVALID_CANDIDATE_EMAIL(1015, "exception.candidate.candidateEmailNotValid", HttpStatus.BAD_REQUEST),
    INVALID_CANDIDATE_PHONE(1016, "exception.candidate.candidatePhoneNotValid", HttpStatus.BAD_REQUEST),
    INVALID_CANDIDATE_STATUS(1017, "exception.candidate.candidateStatusNotValid", HttpStatus.BAD_REQUEST);



    private int code;
    private String localeMessageCode;
    private HttpStatus httpStatus;

}
