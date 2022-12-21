package com.github.bishion.common.util;

import cn.hutool.core.text.CharSequenceUtil;
import com.github.bishion.common.consts.BaseError;
import com.github.bishion.common.dto.BizException;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

/**
 * 基础断言
 *
 * @author: guofangbi
 * @date: 2022-05-24 18:06:98
 * @version: 1.0.0
 */
@Slf4j
public class BaseAssert {
    private BaseAssert() {
    }

    public static void isTrue(boolean expression, BaseError error, Object... params) {
        if (!expression) {
            log.warn(error.getMsg(params));
            throw BizException.throwExp(error, params);
        }
    }

    public static void nonNull(Object obj, BaseError error, Object... params) {
        if (Objects.isNull(obj)) {
            log.warn(error.getMsg(params));
            throw BizException.throwExp(error, params);
        }
    }

    public static void notBlank(String value, BaseError error, Object... params) {
        if (CharSequenceUtil.isBlank(value)) {
            log.warn(error.getMsg(params));
            throw BizException.throwExp(error, params);
        }
    }


    public static <T> T getNonNull(T value, BaseError error, Object... params) {
        nonNull(value, error, params);
        return value;
    }
}
