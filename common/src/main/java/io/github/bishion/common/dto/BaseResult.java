package io.github.bishion.common.dto;

import cn.hutool.core.text.CharSequenceUtil;
import io.github.bishion.common.consts.BaseError;
import io.github.bishion.common.consts.CommError;

import java.io.Serializable;

/**
 * 基本结果
 *
 * @author: guofangbi
 * @version: 1.0.0
 * @since 2022-05-24 23:00:00
 */
public class BaseResult<T> implements Serializable {
    private static final long serialVersionUID = -7096466014807603807L;
    private String code;
    private String errMsg;
    private T value;

    public BaseResult(String code, String errMsg) {
        this.code = code;
        this.errMsg = errMsg;
    }

    private BaseResult() {
    }

    public boolean valid() {
        return CharSequenceUtil.equals(code, CommError.SUCCESS.getCode());
    }

    public T getValid() {
        if (valid()) {
            return value;
        }
        throw BizException.throwExp(code, errMsg);
    }

    public static <T> BaseResult<T> fail(BaseError error, Object... param) {
        return new BaseResult<>(error.getCode(), error.getMsg(param));

    }

    public static BaseResult<Void> success() {
        BaseResult<Void> result = new BaseResult<>();
        result.setCode(CommError.SUCCESS.getCode());
        return result;
    }

    public static <T> BaseResult<T> success(T value) {
        BaseResult<T> result = new BaseResult<>();
        result.setValue(value);
        result.setCode(CommError.SUCCESS.getCode());
        return result;
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
}
