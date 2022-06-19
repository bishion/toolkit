package cn.bishion.toolkit.pangolin.consts;

/**
 * @author: guofangbi
 * @date: 2022/5/28-11:56
 * @version: 1.0.0
 */
public class PangolinConst {
    private PangolinConst() {
    }

    /**
     * HTTP头-应用名
     */
    public static final String HEAD_FROM_APP = "hd_from_app";
    /**
     * HTTP头-源头端
     */
    public static final String HEAD_SOURCE = "hd_source";
    /**
     * HTTP头-用户端IP
     */
    public static final String HEAD_CLIENT_IP = "hd_client_ip";
    /**
     * HTTP头-密钥
     */
    public static final String HEAD_FROM_KEY = "hd_from_key";
    /**
     * HTTP头-操作人
     */
    public static final String HEAD_OPT = "hd_operator";
    /**
     * HTTP头-操作人
     */
    public static final String HEAD_OPT_NAME = "hd_operator_name";
    /**
     * HTTP头-游客标记
     * 为Y表示未登录，N表示已登录
     */
    public static final String HEAD_NO_LOGIN = "hd_no_login";

    /**
     * HTTP头-标记
     */
    public static final String HEAD_TOKEN = "hd-token";
    /**
     * HTTP头-渠道
     */
    public static final String HEAD_CHANNEL = "hd-channel";
    /**
     * HTTP头-渠道用户号
     */
    public static final String HEAD_OPEN_ID = "hd-open-id";

}
