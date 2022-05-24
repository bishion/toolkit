package cn.bishion.toolkit.common.consts;

import java.util.Date;

/**
 * 基本常量
 *
 * @author: guofangbi
 * @date: 2022-05-24 21:17:71
 * @version: 1.0.0
 */
public class BaseConst {
    private BaseConst() {
    }

    /**
     * 是
     */
    public static final String YES = "Y";
    /**
     * 否
     */
    public static final String NO = "N";
    /**
     * 数字 0
     */
    public static final Integer INT_0 = 0;
    /**
     * 数字 1
     */
    public static final Integer INT_1 = 1;
    /**
     * int 2
     */
    public static final Integer INT_2 = 2;
    /**
     * int 3
     */
    public static final Integer INT_3 = 3;
    /**
     * int 4
     */
    public static final Integer INT_4 = 4;
    /**
     * int 5
     */
    public static final Integer INT_5 = 5;
    /**
     * int 6
     */
    public static final Integer INT_6 = 6;
    /**
     * int 7
     */
    public static final Integer INT_7 = 7;
    /**
     * int 8
     */
    public static final Integer INT_8 = 8;
    /**
     * int 9
     */
    public static final Integer INT_9 = 9;
    /**
     * int 10
     */
    public static final Integer INT_10 = 10;
    /**
     * int 30
     */
    public static final Integer INT_30 = 30;
    /**
     * int 50
     */
    public static final Integer INT_50 = 50;
    /**
     * int 60
     */
    public static final Integer INT_60 = 60;
    /**
     * int 100
     */
    public static final Integer INT_100 = 100;
    /**
     * int 500
     */
    public static final Integer INT_500 = 500;
    /**
     * int 1000
     */
    public static final Integer INT_1000 = 1000;
    /**
     * int 3600
     */
    public static final Integer INT_3600 = 3600;
    public static final String DOT = ".";
    /**
     * 逗号
     */
    public static final String COMMA = ",";
    /**
     * 分号
     */
    public static final String SEMICOLON = ";";
    /**
     * 冒号
     */
    public static final String COLON = ":";
    /**
     * 空格
     */
    public static final String SPACE = " ";
    /**
     * 空字符串
     */
    public static final String EMPTY = "";
    /**
     * 连字符
     */
    public static final String HYPHEN = "-";
    /**
     * 下划线
     */
    public static final String UNDERSCORE = "_";
    /**
     * 分隔符
     */
    public static final String SEPARATOR = System.lineSeparator();

    /**
     * 系统
     */
    public static final String SYSTEM = "SYSTEM";
    /**
     * 未知
     */
    public static final String UNKNOWN = "UNKNOWN";
    /**
     * 成功
     */
    public static final String SUCCESS = "SUCCESS";
    /**
     * 失败
     */
    public static final String FAILURE = "FAILURE";
    /**
     * 错误
     */
    public static final String ERROR = "ERROR";

    /**
     * HTTP头-应用名
     */
    public static final String HEAD_APP = "hd_app_name";
    /**
     * HTTP头-来源应用
     */
    public static final String HEAD_SOURCE_APP = "hd_source_app";
    /**
     * HTTP头-密钥
     */
    public static final String HEAD_KEY = "hd_app_key";
    /**
     * HTTP头-操作人
     */
    public static final String HEAD_OPT = "hd_operator";

    /**
     * HTTP头-标记
     */
    public static final String HEAD_TOKEN = "hd-token";
    /**
     * HTTP头-渠道
     */
    public static final String HEAD_CHANNEL = "hd-channel";

    /**
     * 9999-12-31 23:59:59
     */
    public static final Date FOREVER_TIME = new Date(253402271999000L);
    /**
     * 9999-12-31 23:59:59
     */
    public static final String FOREVER_TIME_STR = "9999-12-31 23:59:59";
    /**
     * 9999-12-31
     */
    public static final Date FOREVER_DATE = new Date(253402185600000L);
    /**
     * 9999-12-31
     */
    public static final String FOREVER_DATE_STR = "9999-12-31";
}
