package com.commons.constant;

public enum ResponseCode {

    RESPONSE_SUCCESS(10000, "success"),

    //参数错误
    //TODO action不存在的异常归类待定
    PARAM_E_ACTION_NOT_EXIST(20001, "the action does not exist"),

    //业务错误
    BIZ_E_REQUEST_FORBIDDEN(30001, "the request is forbidden"),
    BIZ_E_REQUEST_PARAMS_MISSING(30002,"缺少参数"),
    BIZ_E_NOT_EXIT_RECORD(30003,"记录不存在"),
    BIZ_E_NOT_EXIT_USER(30004,"用户不存在"),
    BIZ_E_ERROR_USER_PASSWORD(30005,"用户密码不正确"),
    BIZ_E_NOT_EXIT_USER_ID(30006,"管理员id不存在"),
    BIZ_E_NOT_VALID_ADMIN(30007,"管理员账号无效"),

    //系统内部错误
    SYS_E_DEFAULT_ERROR(40001, "%s 系统开小差中，请稍后再试"),
    SYS_E_SERVICE_EXCEPTION(40002, "服务端异常"),
    SYS_E_DATABASE_ERROR(40003, "数据库操作异常"),
    SYS_E_REMOTE_CALL_ERROR(40004, "remote call error"),


    //sql出错
    SYS_E_SQL_PARAM_INVALID(60000,"sql参数出错"),
    SYS_E_SQL_QUERYONE(60001,"QTO单个查询出错"),
    SYS_E_SQL_QUERYLIST(60002,"QTO多个查询出错"),
    SYS_E_SQL_GETBYID(60003,"通过ID查询出错"),
    ;
    private int code;
    private String comment;

    private ResponseCode(int code, String comment) {
        this.code = code;
        this.comment = comment;
    }

    public int getCode() {
        return this.code;
    }

    public String getComment() {
        return this.comment;
    }
}
