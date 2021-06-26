package com.study.springboot.model.exception;

import lombok.*;
import org.springframework.validation.ObjectError;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@Builder(builderMethodName = "of")
@AllArgsConstructor
public class ErrorResponse {

    // Timestamp
    private LocalDateTime timestamp;

    // error type
    private Map<String, Object> errorInfo;

    // error info detail
    private List<ObjectError> errorDetails;

    // error redirect link
    private String redirectLink;

}
