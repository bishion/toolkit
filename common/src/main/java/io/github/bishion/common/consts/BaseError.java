package io.github.bishion.common.consts;

import cn.hutool.core.util.StrUtil;

import java.text.MessageFormat;
import java.util.Objects;

/**
 * 基本错误
 *
 * @author: guofangbi
 * @version: 1.0.0
 * @since 2022-05-24 16:29:02
 */
public interface BaseError {
    Object[] EMPTY_ARR = new String[]{BaseConst.EMPTY};

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

        MessageFormat msgFmt = new MessageFormat(getPattern());
        return msgFmt.format(params);
    }

    public static void main(String[] args) {
        System.out.println(StrUtil.format("{},{}", 123, "123", "123"));
        MessageFormat msgFmt = new MessageFormat("hehe{0},{1},{2}");
        System.out.println(msgFmt.format(null));
    }
}
