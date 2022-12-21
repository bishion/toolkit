package com.github.bishion.web.consts;

import com.github.bishion.common.consts.BaseError;

public enum WebError implements BaseError {
    PARAM_ILLEGAL("WEB001", "参数错误.{0}"),
    FILE_TOO_LARGE("WEB002", "文件过大.{0}"),
    REQ_NOT_SUPPORT("WEB003", "请求类型错误.{0}"),
    SYS_ERROR("WEB004", "系统错误:{0}");
    private String code;
    private String pattern;

    WebError(String code, String pattern) {
        this.code = code;
        this.pattern = pattern;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getPattern() {
        return pattern;
    }
}
