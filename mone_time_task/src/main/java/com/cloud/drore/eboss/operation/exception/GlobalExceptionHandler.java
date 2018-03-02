package com.cloud.drore.eboss.dealer.exception;

import com.alibaba.fastjson.JSONObject;
import com.cloud.drore.eboos.common.base.ResultMessage;
import com.cloud.drore.eboos.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 统一错误码异常处理
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    private static String ERROR_REQUESTPARAM = "参数格式有误！！";

    /**
     * Business exception handler json object.
     *
     * @param exception the exception
     * @return the json object
     * @throws IOException the io exception
     */
    @ExceptionHandler(value = BusinessException.class)
    public ResultMessage BusinessExceptionHandler(BusinessException exception) throws IOException {
        logger.info(exception.toString());
        return ResultMessage.Builder.builder().withIsSuccess(false).withCode(8500L).withMessage(exception.getMessage()).build();
    }


    /**
     * Business exception handler result message.
     * 校验异常捕获,统一返回
     *
     * @param exception the exception
     * @return the result message
     * @throws IOException the io exception
     */
    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResultMessage BusinessExceptionHandler(ConstraintViolationException exception) throws IOException {
        Set<ConstraintViolation<?>> constraintViolations = exception.getConstraintViolations();
        String messages = constraintViolations.stream().map(constraintViolation -> constraintViolation.getMessage()).reduce((s, s2) -> s + "," + s2).get();
        logger.info(exception.toString());
        return ResultMessage.Builder.builder().withIsSuccess(false).withCode(500).withMessage(messages).build();
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResultMessage MethodArgumentNotValidException(MethodArgumentNotValidException e) throws IOException {
        logger.error(e.toString());
        List<ObjectError> errors = e.getBindingResult().getAllErrors();
        List<String> messages = errors.stream().map(error -> error.getDefaultMessage()).collect(Collectors.toList());
        return ResultMessage.Builder.builder().withIsSuccess(false).withCode(8500L).withMessage(messages).build();
    }

    @ExceptionHandler(value = Exception.class)
    public ResultMessage OtherExceptionHandler(Exception e) throws IOException {
        logger.error(e.toString());
        return ResultMessage.Builder.builder().withIsSuccess(false).withCode(8500L).withMessage(ERROR_REQUESTPARAM).build();
    }
}
