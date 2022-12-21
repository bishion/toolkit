package com.github.bishion.common.consts;

public enum YesNoEnum {
    YES(BaseConst.INT_1, "是"),
    NO(BaseConst.INT_0, "否");
    private final Integer code;
    private final String desc;

    YesNoEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
