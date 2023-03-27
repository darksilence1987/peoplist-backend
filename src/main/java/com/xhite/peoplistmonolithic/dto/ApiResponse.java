package com.xhite.peoplistmonolithic.dto;

import com.xhite.peoplistmonolithic.exception.ExceptionData;
import com.xhite.peoplistmonolithic.exception.ExceptionType;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Date;

// This class represents a general response for the API.

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Component
public class ApiResponse {
    private Object data;
    private ExceptionData error;
    private int status;
    private boolean isSuccessful;
    private Date timestamp;

    public ResponseEntity<ApiResponse> createOkResponse(Object responseData) {
        System.out.println(responseData);
        return new ResponseEntity<>(
                ApiResponse.builder()
                        .data(responseData)
                        .status(HttpStatus.OK.value())
                        .isSuccessful(true)
                        .timestamp(new Date())
                        .build()
                , HttpStatus.OK
        );
    }

    public ResponseEntity<ApiResponse> createErrorResponse(ExceptionType exceptionType, ExceptionData exceptionData) {
        return new ResponseEntity<>(
                ApiResponse.builder()
                        .error(exceptionData)
                        .status(exceptionType.getHttpStatus().value())
                        .isSuccessful(false)
                        .timestamp(new Date())
                        .build()
                , exceptionType.getHttpStatus()
        );
    }
}