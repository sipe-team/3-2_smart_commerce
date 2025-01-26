package com.smart.commerce.order.global.support.exception;

public enum ErrorCode {
    // 공통 오류
    INVALID_INPUT_VALUE(400, "C001", "Invalid Input Value"),
    ENTITY_NOT_FOUND(404, "C002", "Entity Not Found"),

    // Order
    ORDER_NOT_FOUND(411, "U001", "Email is Duplicated"),
    USER_NOT_ACTIVATED(403, "U002", "User is Not Activated");

    private final int status;      // HTTP 상태 코드
    private final String code;     // 비즈니스 에러 코드
    private final String message;  // 에러 메시지

    ErrorCode(int status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    // Getter
    public int getStatus() {
        return status;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}