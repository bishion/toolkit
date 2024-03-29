package io.github.bishion.common.consts;

/**
 * 通用错误
 *
 * @author: guofangbi
 * @date: 2022-05-24 23:00:08
 * @version: 1.0.0
 */
public enum Success implements BaseError {

    /**
     * 成功
     */
    SUCCESS("0", "成功"),
    ;

    private String code;
    private String pattern;

    Success(String code, String pattern) {
        this.code = code;
        this.pattern = pattern;
    }

    @Override
    public String getPattern() {
        return pattern;
    }

    @Override
    public String getCode() {
        return code;
    }


}
