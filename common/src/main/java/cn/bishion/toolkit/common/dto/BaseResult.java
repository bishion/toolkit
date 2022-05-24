package cn.bishion.toolkit.common.dto;

import cn.bishion.toolkit.common.consts.BaseError;
import cn.bishion.toolkit.common.consts.CommError;
import cn.bishion.toolkit.common.exp.BizExp;
import cn.hutool.core.text.CharSequenceUtil;

import java.io.Serializable;

/**
 * @author: guofangbi
 * @date: 2022/5/24-16:25
 * @version: 1.0.0
 */
public class BaseResult<T extends Serializable> implements Serializable {
    private static final long serialVersionUID = -7096466014807603807L;
    private String code;
    private String errMsg;
    private T value;
    private String traceId;

    public T validAndGet(BaseError baseError) {
        if (CharSequenceUtil.equals(code, CommError.SUCCESS.getCode())) {
            return value;
        }
        throw BizExp.throwExp(baseError, errMsg);
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
