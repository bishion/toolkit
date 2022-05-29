package cn.bishion.toolkit.pangolin.consts;

import cn.bishion.toolkit.common.consts.BaseError;

/**
 * @author: guofangbi
 * @date: 2022/5/28-13:09
 * @version: 1.0.0
 */
public enum PangolinError implements BaseError {
    /**
     * 请求参数丢失
     */
    REQ_PARAM_VALID("RQT001", "通用请求信息中有空值."),
    REQ_KEY_VALID("RQT002", "通用请求信息安全校验失败."),
    ;

    PangolinError(String code, String pattern) {
        this.code = code;
        this.pattern = pattern;
    }

    private String code;
    private String pattern;

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getPattern() {
        return pattern;
    }
}
