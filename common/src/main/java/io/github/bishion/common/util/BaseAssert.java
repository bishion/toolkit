package io.github.bishion.common.util;

import cn.hutool.core.text.CharSequenceUtil;
import io.github.bishion.common.consts.BaseError;
import io.github.bishion.common.dto.BizException;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

/**
 * 基础断言
 *
 * @author: guofangbi
 * @version: 1.0.0
 * @since 2022-05-24 18:06:98
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
