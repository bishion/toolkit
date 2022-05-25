package cn.bishion.toolkit.common.util;

import cn.bishion.toolkit.common.consts.CommError;
import cn.bishion.toolkit.common.dto.BizException;
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

    public static void isTrue(boolean expression, Object... params) {
        if (!expression) {
            log.warn(CommError.DATA_ILLEGAL.getErrorMsg(params));
            throw BizException.throwExp(CommError.DATA_ILLEGAL, params);
        }
    }

    public static void nonNull(Object obj, Object... params) {
        if (Objects.isNull(obj)) {
            log.warn(CommError.DATA_IS_NULL.getErrorMsg(params));
            throw BizException.throwExp(CommError.DATA_IS_NULL, params);
        }
    }

    public static <T> T getNonNull(T value, Object... params) {
        nonNull(value, params);
        return value;
    }
}
