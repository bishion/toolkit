package io.github.bishion.common.dto;

import io.github.bishion.common.util.ToString;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author: guofangbi
 * @date: 2022/5/28-11:52
 * @version: 1.0.0
 */
@Builder
@Getter
@Setter
public class BaseReqInfo implements Serializable {
    private static final long serialVersionUID = 552409411497966569L;
    private String operator;
    private String operatorName;
    private String fromApp;
    private String sourceApp;

    private String channel;
    private String token;
    private String openId;
    private boolean noLogin;
    private String noLoginFlag;
    private String clientIp;

    @Override
    public String toString() {
        return ToString.toString(this);
    }
}
