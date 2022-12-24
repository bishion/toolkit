package io.github.bishion.common.consts;

public enum CommError implements BaseError {
    /**
     * 成功
     */
    SUCCESS("0", "成功"),
    PARAM_LOST("PAM01", "{0}必填"),
    PARAM_HAS_LOST("PAM02", "{0}均不能为空"),
    DB_NO_DATA_BY_KEY("DB01", "未找到{0}:{1}"),
    DB_NO_DATA("DB02", "未找到{0}"),
    DB_SAVE_FAIL("DB03", "{0}保存失败"),
    DB_SAVE_FAIL_BY_KEY("DB04", "{0}保存失败:{1}"),

    ;

    CommError(String code, String pattern) {
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
