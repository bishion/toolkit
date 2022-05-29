package cn.bishion.toolkit.pangolin.entrance.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author: guofangbi
 * @date: 2022/5/28-11:52
 * @version: 1.0.0
 */
@Builder
@Getter
@Setter
@ToString
public class BaseReqInfo implements Serializable {
    private static final long serialVersionUID = 552409411497966569L;
    private String operator;
    private String fromApp;
    private String source;

    private String channel;
    private String token;
    private String openId;
    private boolean noLogin;

}
