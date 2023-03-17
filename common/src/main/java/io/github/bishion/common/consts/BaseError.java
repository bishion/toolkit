package io.github.bishion.common.consts;

import cn.hutool.core.util.StrUtil;

import java.util.Objects;

/**
 * 基本错误
 *
 * @author: guofangbi
 * @version: 1.0.0
 * @since 2022-05-24 16:29:02
 */
public interface BaseError {
    Object[] EMPTY_ARR = new String[]{BaseConst.EMPTY, BaseConst.EMPTY, BaseConst.EMPTY, BaseConst.EMPTY, BaseConst.EMPTY};

    /**
     * 错误代码
     *
     * @return 错误代码
     */
    String getCode();

    /**
     * 错误信息模板
     *
     * @return {@link String}
     */
    String getPattern();

    /**
     * 获取错误信息
     *
     * @param params 参数个数
     * @return {@link String}
     */
    default String getMsg(Object... params) {
        if (Objects.isNull(params)) {
            params = EMPTY_ARR;
        }

        return StrUtil.format(getPattern(), params);
    }
}
