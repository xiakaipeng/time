package com.cloud.drore.eboos.common.base;

import com.github.pagehelper.PageInfo;
import lombok.Data;

/**
 * User: wcy
 * Date: 2017/10/18
 * Time: 10:44
 */
@Data
public class ResultMessage<T>{
    private static final Long SUCCESS_CODE = 8200L;
    private static final String SUCCESS_MESSAGE = "success";
    /**
     * 是否成功
     */
    private Boolean isSuccess = true;
    // 状态码：1成功，其他为失败
    private long code = SUCCESS_CODE;

    // 成功为success，其他为失败原因
    private Object message = SUCCESS_MESSAGE;

    // 数据结果集
    private T data;

    //返回id
    private String id;

    private long total;

    private int current;

    private int size;

    public ResultMessage() {
    }

    public ResultMessage(T data) {
        this.data = data;
    }

    public ResultMessage(int code, Object message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static ResultMessage success(String meessage) {
        return Builder.builder().withMessage(meessage).build();
    }

    public static ResultMessage success(Object data) {
        return Builder.builder().withData(data).build();
    }

    public static ResultMessage success(PageInfo page) {
        return Builder.builder()
                .withCurrent(page.getPageNum())
                .withTotal(page.getTotal())
                .withSize(page.getSize())
                .withData(page.getList()).build();
    }

    public static ResultMessage success(String meessage, Object data) {
        return Builder.builder().withMessage(meessage).withData(data).build();
    }

    public static ResultMessage error(Long code, String meessage) {
        return Builder.builder().withIsSuccess(false).withCode(code).withMessage(meessage).build();
    }

    public static ResultMessage defaultError(String meessage) {
        return Builder.builder().withIsSuccess(false).withCode(500L).withMessage(meessage).build();
    }

    public static final class Builder<T> {
        // 状态码：1成功，其他为失败
        public long code = SUCCESS_CODE;
        // 成功为success，其他为失败原因
        public Object message = SUCCESS_MESSAGE;
        // 数据结果集
        public T data;
        //返回id
        public String id;

        private long total;

        private int current;

        private int size;
        private Boolean isSuccess = true;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder withIsSuccess(Boolean isSuccess) {
            this.isSuccess = isSuccess;
            return this;
        }

        public Builder withCode(long code) {
            this.code = code;
            return this;
        }

        public Builder withMessage(Object message) {
            this.message = message;
            return this;
        }


        public Builder withData(T data) {
            this.data = data;
            return this;
        }

        public Builder withCurrent(int current) {
            this.current = current;
            return this;
        }

        public Builder withSize(int size) {
            this.size = size;
            return this;
        }

        public Builder withTotal(long total) {
            this.total = total;
            return this;
        }

        public Builder withId(String id) {
            this.id = id;
            return this;
        }

        public ResultMessage build() {
            ResultMessage resultMessage = new ResultMessage();
            resultMessage.setIsSuccess(isSuccess);
            resultMessage.setCode(code);
            resultMessage.setMessage(message);
            resultMessage.setData(data);
            resultMessage.setId(id);
            resultMessage.setCurrent(current);
            resultMessage.setSize(size);
            resultMessage.setTotal(total);
            return resultMessage;
        }
    }
}
