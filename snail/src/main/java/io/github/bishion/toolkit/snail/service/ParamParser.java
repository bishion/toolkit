package io.github.bishion.toolkit.snail.service;

/**
 * @author: guofangbi
 * @since 2022/6/4-20:09
 * @version: 1.0.0
 */
public interface ParamParser {
    /**
     * 解决参数
     *
     * @param params 参数个数
     * @return {@link String}
     */
    String parse(Object[] params);
}
