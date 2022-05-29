package cn.bishion.toolkit.common.util;

import cn.bishion.toolkit.common.consts.BaseError;
import cn.bishion.toolkit.common.consts.CommError;
import cn.bishion.toolkit.common.dto.BizException;
import org.slf4j.Logger;

import java.util.Objects;

/**
 * 基础断言
 *
 * @author: guofangbi
 * @date: 2022-05-24 18:06:98
 * @version: 1.0.0
 */
public class BaseAssert {
    private BaseAssert() {
    }

    public static void isTrue(boolean expression, Logger log,
                              BaseError error, Object... params) {
        if (!expression) {
            log.warn(error.getErrorMsg(params));
            throw BizException.throwExp(CommError.DATA_ILLEGAL, params);
        }
    }

    public static void nonNull(Object obj, Logger log, BaseError error, Object... params) {
        if (Objects.isNull(obj)) {
            log.warn(error.getErrorMsg(params));
            throw BizException.throwExp(error, params);
        }
    }

    public static <T> T getNonNull(T value, Logger log, BaseError error, Object... params) {
        nonNull(value, log, error, params);
        return value;
    }
}
