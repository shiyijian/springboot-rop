package com.commons.reponse;

import com.commons.constant.ResponseCode;

public class BaseResponse<T> implements Response<T> {

    private T module;
    private int code;
    private String message;
    private long totalCount = 0;

    public BaseResponse(ResponseCode responseCode, String message){
        this.code = responseCode.getCode();
        this.message = message;
    }

    public BaseResponse(ResponseCode responseCode){
        this.code = responseCode.getCode();
        this.message = responseCode.getComment();
    }

    public BaseResponse(int code, String message){
        this.code =code;
        this.message = message;
    }

    public BaseResponse(T module){
        this.module = module;
        this.code = ResponseCode.RESPONSE_SUCCESS.getCode();
        this.message = ResponseCode.RESPONSE_SUCCESS.getComment();
    }

    public T getModule() {
        return module;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public void setCode(int code){
        this.code = code;
    }
    public long getTotalCount() {
        return totalCount;
    }
    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public boolean isSuccess() {
        return ResponseCode.RESPONSE_SUCCESS.getCode() == this.getCode();
    }

    public int getCode() {
        return this.code;
    }
}
