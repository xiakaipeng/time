package com.cloud.drore.eboos.exception;

/**
 * Enum 响应类型
 */
public enum ExceptionType {

    SUCCESS(0, "success", 0),

    DATA_ERROR(10001, "数据错误", 2);

    private int code;
    private String message;
    private int level;

    ExceptionType(int code, String message, int level) {
        this.code = code;
        this.message = message;
        this.level = level;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}


