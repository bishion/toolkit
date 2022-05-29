package cn.bishion.toolkit.common.dto;

import cn.bishion.toolkit.common.consts.BaseError;
import cn.bishion.toolkit.common.consts.CommError;
import cn.hutool.core.text.CharSequenceUtil;

import java.io.Serializable;

/**
 * 基本结果
 *
 * @author: guofangbi
 * @date: 2022-05-24 23:00:00
 * @version: 1.0.0
 */
public class BaseResult<T extends Serializable> implements Serializable {
    private static final long serialVersionUID = -7096466014807603807L;
    private String code;
    private String errMsg;
    private T value;
    private String traceId;

    private BaseResult(String code, String errMsg) {
        this.code = code;
        this.errMsg = errMsg;
    }

    public T getValid() {
        if (CharSequenceUtil.equals(code, CommError.SUCCESS.getCode())) {
            return value;
        }
        throw BizException.throwExp(code, errMsg);
    }

    public static <T extends Serializable> BaseResult<T> fail(BaseError error, Object... param) {
        return new BaseResult<>(error.getCode(), error.getErrorMsg(param));

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }
}
