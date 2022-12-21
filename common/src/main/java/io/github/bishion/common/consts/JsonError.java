package io.github.bishion.common.consts;

public enum JsonError implements BaseError {

    TO_STR_ERROR("JSN001", "json转换失败.");

    JsonError(String code, String pattern) {
        this.code = code;
        this.pattern = pattern;
    }

    private String code;
    private String pattern;

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getPattern() {
        return pattern;
    }

}
