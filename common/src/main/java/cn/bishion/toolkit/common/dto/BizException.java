package cn.bishion.toolkit.common.dto;

import cn.bishion.toolkit.common.consts.BaseError;

/**
 * 业务异常
 *
 * @author: guofangbi
 * @date: 2022-05-24 23:01:52
 * @version: 1.0.0
 */
public class BizException extends RuntimeException {
    private static final long serialVersionUID = 4090231776804948548L;
    private final String code;
    private final String msg;

    private BizException(BaseError baseError, Object... param) {
        this.code = baseError.getCode();
        this.msg = baseError.getErrorMsg(param);
    }

    private BizException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static BizException throwExp(BaseError baseError, Object... param) {
        return new BizException(baseError, param);
    }

    /**
     * 抛出异常
     * 该方法只给baseResult
     *
     * @param code 代码
     * @param msg  信息
     * @return {@link BizException}
     */
    static BizException throwExp(String code, String msg) {
        return new BizException(code, msg);
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
