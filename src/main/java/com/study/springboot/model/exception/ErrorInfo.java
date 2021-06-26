package com.study.springboot.model.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
@AllArgsConstructor
public enum ErrorInfo {

    DATA_NOT_FOUND("E400", "해당 데이터 조회에 실패하였습니다."),
    INVALID_PARAMETER("E401", "잘못된 요청 정보 입니다."),
    ;

    private String errorCode;
    private String errorMessage;

    public Map<String, Object> getInfo() {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("errorCode", this.errorCode);
        resultMap.put("errorMessage", this.errorMessage);
        return resultMap;
    }
}
