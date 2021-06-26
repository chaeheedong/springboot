package com.study.springboot.exception;

import org.springframework.validation.ObjectError;

import java.util.List;

/**
 * 커스텀 비예외검사 exception (unchecked exception) 을 만든다.
 * 비예외검사 / 예외검사의 차이는 무엇인지 직접 조사해볼것..
 */
public class InvalidParameterException extends RuntimeException {

    private List<ObjectError> allErros;

    public InvalidParameterException() { }

    public InvalidParameterException(String message) {
        super(message);
    }

    public InvalidParameterException(List<ObjectError> allErrors) {
        this.allErros = allErrors;
    }

    public List<ObjectError> getAllErros() {
        return allErros;
    }
}