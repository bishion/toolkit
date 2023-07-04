package io.github.bishion.common.consts;

public enum JsonError implements BaseError {

    TO_STR_ERROR("JSN001", "对象转json失败:{0}"),

    TO_BEAN_ERROR("JSN002", "json转对象失败:{0}");

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
