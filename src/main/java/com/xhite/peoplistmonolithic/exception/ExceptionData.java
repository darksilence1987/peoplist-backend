package com.xhite.peoplistmonolithic.exception;

import lombok.*;
import org.springframework.stereotype.Component;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Component
public class ExceptionData {
    private int exceptionCode;
    private String errorMessage;
}