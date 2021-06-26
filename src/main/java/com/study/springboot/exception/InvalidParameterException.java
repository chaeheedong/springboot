package com.study.springboot.exception;
/**
 * 커스텀 비예외검사 exception (unchecked exception) 을 만든다.
 * 비예외검사 / 예외검사의 차이는 무엇인지 직접 조사해볼것..
 */
public class InvalidParameterException extends RuntimeException {

    public InvalidParameterException() { }

    public InvalidParameterException(String message) {
        super(message);
    }
}