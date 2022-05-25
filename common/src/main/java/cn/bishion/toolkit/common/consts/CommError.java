package cn.bishion.toolkit.common.consts;

/**
 * 通用错误
 *
 * @author: guofangbi
 * @date: 2022-05-24 23:00:08
 * @version: 1.0.0
 */
public enum CommError implements BaseError {

    /**
     * 成功
     */
    SUCCESS("0", "成功"),

    DATA_ILLEGAL("1001", "数据校验失败.{0}"),
    DATA_IS_NULL("1002", "数据为空.{0}"),
    ;

    private String code;
    private String pattern;

    CommError(String code, String pattern) {
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

    @Override
    public String getErrorMsg(Object... param) {
        return null;
    }

}
