package com.study.springboot.model.exception;

import lombok.*;

import java.time.LocalDateTime;
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

    // error redirect link
    private String redirectLink;

}
