package cn.bishion.toolkit.common.exp;

import cn.bishion.toolkit.common.consts.BaseError;

/**
 * 业务异常
 *
 * @author: guofangbi
 * @date: 2022-05-24 17:20:42
 * @version: 1.0.0
 */
public class BizExp extends RuntimeException {
    private static final long serialVersionUID = 4090231776804948548L;
    private final String code;
    private final String msg;

    public BaseError getBaseError() {
        return baseError;
    }

    private final BaseError baseError;

    BizExp(BaseError baseError, Object... param) {
        this.baseError = baseError;
        this.code = baseError.getCode();
        this.msg = baseError.getErrorMsg(param);
    }

    public static BizExp throwExp(BaseError baseError, Object... param) {
        return new BizExp(baseError, param);
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
