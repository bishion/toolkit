package cn.bishion.toolkit.common.dto;

import cn.bishion.toolkit.common.consts.BaseError;

/**
 * 业务异常
 *
 * @author: guofangbi
 * @date: 2022-05-24 23:01:52
 * @version: 1.0.0
 */
public class BizExp extends RuntimeException {
    private static final long serialVersionUID = 4090231776804948548L;
    private final String code;
    private final String msg;

    private BizExp(BaseError baseError, Object... param) {
        this.code = baseError.getCode();
        this.msg = baseError.getErrorMsg(param);
    }

    private BizExp(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static BizExp throwExp(BaseError baseError, Object... param) {
        return new BizExp(baseError, param);
    }

    static BizExp throwExp(String code, String msg) {
        return new BizExp(code, msg);
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
