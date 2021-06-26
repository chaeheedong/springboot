package com.study.springboot.advice;

import com.study.springboot.exception.MemberNotFoundException;
import com.study.springboot.model.exception.ErrorInfo;
import com.study.springboot.model.exception.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ControllerExceptionAdvice {

    //    @ControllerAdvice // 전역에서 동작
    @ExceptionHandler // 자기가 있는 class에서 동작
    public ErrorResponse handleNumberFormatException(NumberFormatException e) {

        // make return vo // model.exception.ErrorResponse
        // Timestamp
        // error info
        // error redirect link

        return ErrorResponse.of()
                .timestamp(LocalDateTime.now())
                .errorInfo(ErrorInfo.INVALID_PARAMETER.getInfo())
                .build();
    }

    @ExceptionHandler // 자기가 있는 class에서 동작
    public ErrorResponse handleMemberNotFoundException(MemberNotFoundException e) {
        return ErrorResponse.of()
                .timestamp(LocalDateTime.now())
                .errorInfo(ErrorInfo.DATA_NOT_FOUND.getInfo())
                .build();
    }

//    @ExceptionHandler // 자기가 있는 class에서 동작
//    public ErrorResponse handleAllException(Exception e) {
//        return ErrorResponse.of()
//                .timestamp(LocalDateTime.now())
//                .errorInfo(ErrorInfo.NO_IDENTIFIED_ERROR.getInfo())
//                .build();
//    }
}
