package com.commons.constant;

public enum ActionEnum {

    /**
     * 通过手机号获取管理员信息
     */
    GET_ADMINBYMOBILE("getAdminByMobile"),
    /**
     * 通过管理员id获取管理员信息
     */
    GET_ADMINBYID("getAdminById"),
    ;

    private String actionName;

    private ActionEnum(String actionName) {
        this.actionName = actionName;
    }

    public static ActionEnum getActionEnum(String actionName) {
        for (ActionEnum ae : ActionEnum.values()) {
            if (ae.actionName.equals(actionName)) {
                return ae;
            }
        }
        return null;
    }

    public String getActionName() {
        return actionName;
    }
}
