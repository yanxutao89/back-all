package com.backall.auth.enums;

public enum AuthUserStatusEnum {

    DELETED(0),
    NORMAL(1);

    private Integer code;

    AuthUserStatusEnum(Integer code) {
        this.code = code;
    }

    public Integer code() {
        return code;
    }

}
