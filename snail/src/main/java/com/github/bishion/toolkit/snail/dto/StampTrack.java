package com.github.bishion.toolkit.snail.dto;

import com.github.bishion.common.util.ToString;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author: guofangbi
 * @date: 2022/6/4-20:27
 * @version: 1.0.0
 */
@Getter
@Setter
@Builder
public class StampTrack {
    //////////////////// 基础静态信息 ///////////////////////
    /**
     * 应用程序名称
     */
    private String appName;
    /**
     * 主机ip
     */
    private String hostIp;
    /**
     * 主机名
     */
    private String hostName;

    //////////////////// 请求信息 ///////////////////////
    /**
     * 客户端ip
     */
    private String clientIp;
    /**
     * 操作人
     */
    private String operator;
    /**
     * 操作人姓名
     */
    private String operatorName;
    //////////////////// 注解信息 ///////////////////////
    /**
     * 模块
     */
    private String module;
    /**
     * 操作类型
     */
    private String actionType;
    /**
     * 操作
     */
    private String action;

    /**
     * 参数
     */
    private String param;
    /**
     * 参数
     */
    private String bizNo;
    //////////////////// 执行信息 ///////////////////////

    /**
     * 响应
     */
    private String response;
    /**
     * 成功还是失败
     * SUCCESS；FAILURE
     */
    private String success;

    /**
     * 开始时间
     */
    private Long startTime;
    /**
     * 结束时间
     */
    private Long endTime;
    /**
     * 执行时间ms
     */
    private Long costTime;

    @Override
    public String toString() {
        return ToString.toString(this);
    }
}
