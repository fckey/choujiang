package com.choujiang.exception;

/**
 * @author fongshaolei
 * @version 1.0.0
 * @ClassName BusinessExceptionCode
 * @Description
 * @createTime 2022/06/14 9:42
 **/
public enum BusinessExceptionCode {
    USER_LOGIN_NAME_EXIST("登录名已存在"),
    LOGIN_USER_ERROR("用户名不存在或密码错误"),
    ORGANIZATION_NAME_EXIST("组织名已经存在"),
    DRAW_RECORD_STATUS_ILLEGAL("选择签的状态不合法,请不要违规操作");

    private String desc;

    BusinessExceptionCode(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
