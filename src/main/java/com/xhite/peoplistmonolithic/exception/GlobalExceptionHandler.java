package com.xhite.peoplistmonolithic.exception;

import com.xhite.peoplistmonolithic.dto.ApiResponse;
import com.xhite.peoplistmonolithic.exception.custom.CandidateAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


import static com.xhite.peoplistmonolithic.exception.ExceptionType.*;



@RequiredArgsConstructor
@Slf4j
public class GlobalExceptionHandler {
    private final ApiResponse apiResponse;

    // Örnek custom exception türleri

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ApiResponse> handleAllExceptions(Exception exception) {
        return createExceptionResponse(UNEXPECTED_ERROR, exception.getMessage());
    }
    @ResponseBody
    @ExceptionHandler(RuntimeException.class)
    public final ResponseEntity<ApiResponse> handleUnexpectedError(Exception exception) {
        log.error(exception.getMessage(), exception);
        return createExceptionResponse(UNEXPECTED_ERROR, exception.getMessage());
    }
    @ResponseBody
    @ExceptionHandler(ChangeSetPersister.NotFoundException.class)
    public final ResponseEntity<ApiResponse> handleCandidateNotFoundException(Exception exception) {
        return createExceptionResponse(CANDIDATE_NOT_FOUND, exception.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(CandidateAlreadyExistsException.class)
    public final ResponseEntity<ApiResponse> handleCandidateAlreadyExistsException(Exception exception) {
        return createExceptionResponse(CANDIDATE_ALREADY_EXISTS, exception.getMessage());
    }
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public final ResponseEntity<ApiResponse> handleInteractionTypeNotValidException(Exception exception) {
        return createExceptionResponse(INVALID_INTERACTION_TYPE, exception.getMessage());
    }


    private ResponseEntity<ApiResponse> createExceptionResponse(ExceptionType exceptionType, String exceptionMessage) {
        return apiResponse
                .createErrorResponse(
                        exceptionType,
                        ExceptionData.builder()
                                .exceptionCode(exceptionType.getCode())
                                .errorMessage(exceptionMessage)
                                .build()
                );
    }
}
