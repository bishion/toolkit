package io.github.bishion.toolkit.snail.consts;

import io.github.bishion.common.consts.BaseError;

/**
 * @author: guofangbi
 * @date: 2022/6/4-19:53
 * @version: 1.0.0
 */
public enum SnailError implements BaseError {
    /**
     * 解析器名字错了
     */
    ACTION_PARSER_NAME_WRONG("TRK001", "未找到操作描述解析器.{0}"),
    PARAM_PARSER_NAME_WRONG("TRK002", "未找到参数解析器.{0}"),
    SPEL_PARSE_FAIL("TRK102", "SPEL解析失败.{0}"),
    ;

    private String code;
    private String pattern;

    SnailError(String code, String pattern) {
        this.code = code;
        this.pattern = pattern;
    }

    public String getCode() {
        return code;
    }

    public String getPattern() {
        return pattern;
    }

}
