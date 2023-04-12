package io.github.bishion.common.util;

import cn.hutool.core.text.CharSequenceUtil;
import io.github.bishion.common.consts.BaseError;
import io.github.bishion.common.consts.CommError;
import io.github.bishion.common.dto.BizException;

import java.util.Objects;

/**
 * 基础断言
 *
 * @author: guofangbi
 * @version: 1.0.0
 * @since 2022-05-24 18:06:98
 */
public class BaseAssert {
    private BaseAssert() {
    }

    public static void isTrue(boolean expression, BaseError error, Object... params) {
        if (!expression) {
            throw BizException.throwExp(error, params);
        }
    }

    public static void checkParam(boolean expression, String message) {
        if (!expression) {
            throw BizException.throwExp(CommError.PARAM_HAS_BLANK, message);
        }
    }

    public static void nonNull(Object obj, BaseError error, Object... params) {
        if (Objects.isNull(obj)) {
            throw BizException.throwExp(error, params);
        }
    }

    public static void paramNotNull(Object obj, String message) {
        if (Objects.isNull(obj)) {
            throw BizException.throwExp(CommError.PARAM_HAS_BLANK, message);
        }
    }

    public static void nonBlank(String message, String... obj) {
        if (CharSequenceUtil.hasBlank(obj)) {
            throw BizException.throwExp(CommError.PARAM_HAS_BLANK, message);
        }
    }

    public static void notBlank(String value, BaseError error, Object... params) {
        if (CharSequenceUtil.isBlank(value)) {
            throw BizException.throwExp(error, params);
        }
    }


    public static <T> T getNonNull(T value, BaseError error, Object... params) {
        nonNull(value, error, params);
        return value;
    }
}
