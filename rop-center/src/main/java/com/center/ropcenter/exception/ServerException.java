package com.center.ropcenter.exception;

import com.commons.constant.ResponseCode;

public class ServerException extends Exception{

    private ResponseCode responseCode;

    public ServerException(){
        super();
        this.responseCode = ResponseCode.SYS_E_DEFAULT_ERROR;
    }
    public ServerException(String message){
        super(message);
        this.responseCode = ResponseCode.SYS_E_DEFAULT_ERROR;
    }
    public ServerException(Throwable cause){
        super(cause);
        this.responseCode = ResponseCode.SYS_E_DEFAULT_ERROR;
    }
    public ServerException(String message, Throwable cause){
        super(message, cause);
        this.responseCode =  ResponseCode.SYS_E_DEFAULT_ERROR;
    }
    public ServerException(ResponseCode responseCode){
        super(responseCode.getComment());
        this.responseCode = responseCode;
    }
    public ServerException(ResponseCode responseCode, String message){
        super(message);
        this.responseCode = responseCode;
    }
    public ServerException(ResponseCode responseCode, Throwable cause){
        super(responseCode.getComment(),cause);
        this.responseCode = responseCode;
    }
    public ServerException(ResponseCode responseCode, String message, Throwable cause){
        super(message, cause);
        this.responseCode = responseCode;
    }
    public ResponseCode getResponseCode() {
        return responseCode;
    }
}
