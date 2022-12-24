package io.github.bishion.toolkit.snail.service;

/**
 * @author: guofangbi
 * @version: 1.0.0
 * @since 2022/6/4-20:14
 */
public interface SnailSpelParser {
    String PARAM_REQ = "req";
    String PARAM_RESP = "resp";

    /**
     * 解析操作内容
     *
     * @param params 参数个数
     * @param spel   行动
     * @return {@link String}
     */
    String parse(String spel, Object[] params, Object resp);
}
