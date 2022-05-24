package cn.bishion.toolkit.common.consts;

import java.text.MessageFormat;
import java.util.Objects;

/**
 * 基本错误
 *
 * @author: guofangbi
 * @date: 2022-05-24 16:29:02
 * @version: 1.0.0
 */
public interface BaseError {
    String[] EMPTY_ARR = new String[0];

    /**
     * 错误代码
     *
     * @return 错误代码
     */
    String getCode();

    /**
     * 错误信息
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
    default String getErrorMsg(Object... params) {
        if (Objects.isNull(params)) {
            params = EMPTY_ARR;
        }

        MessageFormat msgFmt = new MessageFormat(getPattern());
        return msgFmt.format(params);
    }
}
