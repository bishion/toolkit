package io.github.bishion.pangolin.consts;


/**
 * @author: guofangbi
 * @version: 1.0.0
 * @since 2022/5/28-11:56
 */
public enum ReqHeaderKeyEnum {

    OPERATOR_NO("hd_operator_no"),
    OPERATOR_NAME("hd_operator_name"),
    OPERATOR_ROLE("hd_operator_role"),
    UPSTREAM_APP("hd_upstream_app"),
    CHANNEL_SOURCE("hd_channel_source"),
    CHANNEL_CODE("hd_channel_code"),
    CHANNEL_VERSION("hd_channel_version"),
    CHANNEL_TYPE("hd_channel_type"),
    LOGIN_TOKEN("hd_login_token"),
    CHANNEL_USER_ID("hd_channel_user_id"),
    NO_LOGIN_FLAG("hd_no_login_flag"),
    CLIENT_IP("hd_client_ip"),
    SESSION_ID("hd_session_id");

    private String key;


    ReqHeaderKeyEnum(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
