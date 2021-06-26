package com.study.springboot.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@Builder(builderMethodName = "of")
@AllArgsConstructor
public class ResponseVO {

    private HttpStatus status;
    private String message;

}
