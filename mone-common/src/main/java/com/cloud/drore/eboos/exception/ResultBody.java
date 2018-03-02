package com.cloud.drore.eboos.exception;


import com.alibaba.fastjson.JSONObject;

public class ResultBody {

    public static JSONObject json(Object data) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", ExceptionType.SUCCESS.getCode());
        jsonObject.put("message", ExceptionType.SUCCESS.getMessage());
        jsonObject.put("data", data);
        return jsonObject;
    }
}
