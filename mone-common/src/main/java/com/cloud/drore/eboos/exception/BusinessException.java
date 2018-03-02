package com.cloud.drore.eboos.exception;

import com.cloud.drore.eboos.exception.ExceptionType;

/**
 * User: wcy
 * Date: 2017/9/15
 * Time: 10:22
 */
public class BusinessException extends Exception{

    private static int BUSINESS_CODE = 8203;

    private int code;

    private String message;

    private int level;

    public BusinessException(ExceptionType exceptionType) {
        this.code = exceptionType.getCode();
        this.message = exceptionType.getMessage();
        this.level = exceptionType.getLevel();
    }

    public BusinessException(int code, String message, int level) {
        this.code = code;
        this.message = message;
        this.level = level;
    }

    public BusinessException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public BusinessException(String message){
        this.code = BUSINESS_CODE;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public int getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return "BusinessException{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", level=" + level +
                '}';
    }
}