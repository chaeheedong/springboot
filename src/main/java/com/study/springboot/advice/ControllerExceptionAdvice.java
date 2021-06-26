package com.study.springboot.advice;

import com.study.springboot.exception.InvalidParameterException;
import com.study.springboot.exception.MemberNotFoundException;
import com.study.springboot.model.exception.ErrorInfo;
import com.study.springboot.model.exception.ErrorResponse;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;

@RestControllerAdvice
public class ControllerExceptionAdvice {

    //    @ControllerAdvice // 전역에서 동작
    @ExceptionHandler // 자기가 있는 class에서 동작
    public ErrorResponse handleInvalidParameteException(InvalidParameterException e) {

        // make return vo // model.exception.ErrorResponse
        // Timestamp
        // error info
        // error redirect link

        List<ObjectError> allErros = e.getAllErros();

        return ErrorResponse.of()
                .timestamp(LocalDateTime.now())
                .errorInfo(ErrorInfo.INVALID_PARAMETER.getInfo())
                .errorDetails(allErros)
                .build();
    }

    @ExceptionHandler // 자기가 있는 class에서 동작
    public ErrorResponse handleMemberNotFoundException(MemberNotFoundException e) {
        return ErrorResponse.of()
                .timestamp(LocalDateTime.now())
                .errorInfo(ErrorInfo.DATA_NOT_FOUND.getInfo())
                .build();
    }

    // 전체 예외처리
    @ExceptionHandler // 자기가 있는 class에서 동작
    public ErrorResponse handleAllException(Exception e) {
        return ErrorResponse.of()
                .timestamp(LocalDateTime.now())
                .errorInfo(ErrorInfo.NO_IDENTIFIED_ERROR.getInfo())
                .build();
    }
}
