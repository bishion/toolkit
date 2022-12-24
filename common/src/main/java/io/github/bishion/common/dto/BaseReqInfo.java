package io.github.bishion.common.dto;

import io.github.bishion.common.consts.BaseConst;

import java.io.Serializable;

/**
 * 基本操作信息
 *
 * @author: guofangbi
 * @since: 2022-06-13 22:23:14
 * @version: 1.0.0
 */
public class BaseReqInfo implements Serializable {

    /**
     * 当前登陆人
     */
    private String operatorNo;
    /**
     * 当前登陆人姓名
     */
    private String operatorName;
    /**
     * 当前登陆人角色
     */
    private String operatorRole;
    /**
     * 上游appName
     */
    private String upstreamApp;
    /**
     * 来源渠道，有可能是app，有可能是短信分享链接
     */
    private String channelSource;
    /**
     * 登录渠道
     */
    private String channelCode;
    /**
     * 登录渠道版本
     */
    private String channelVersion;
    /**
     * 登录渠道类型，比如同一套代码，部署在多个小程序
     */
    private String channelType;
    /**
     * token
     */
    private String loginToken;
    /**
     * 渠道用户ID
     */
    private String channelUserId;
    /**
     * 是否未登录
     */
    private String noLoginFlag;

    /**
     * 客户端IP
     */
    private String clientIp;
    /**
     * 会话ID
     */
    private String sessionId;
    private boolean noLogin;

    @Override
    public String toString() {
        return "ReqInfo{" +
                "operatorNo='" + operatorNo + '\'' +
                ", operatorName='" + operatorName + '\'' +
                ", operatorRole='" + operatorRole + '\'' +
                ", upstreamApp='" + upstreamApp + '\'' +
                ", channelSource='" + channelSource + '\'' +
                ", channelCode='" + channelCode + '\'' +
                ", channelVersion='" + channelVersion + '\'' +
                ", channelType='" + channelType + '\'' +
                ", loginToken='" + loginToken + '\'' +
                ", channelUserId='" + channelUserId + '\'' +
                ", noLoginFlag='" + noLoginFlag + '\'' +
                ", clientIp='" + clientIp + '\'' +
                ", sessionId='" + sessionId + '\'' +
                ", noLogin=" + noLogin +
                '}';
    }

    public String getOperatorNo() {
        return operatorNo;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public String getOperatorRole() {
        return operatorRole;
    }

    public String getUpstreamApp() {
        return upstreamApp;
    }

    public String getChannelSource() {
        return channelSource;
    }

    public String getChannelCode() {
        return channelCode;
    }

    public String getChannelVersion() {
        return channelVersion;
    }

    public String getChannelType() {
        return channelType;
    }

    public String getLoginToken() {
        return loginToken;
    }

    public String getChannelUserId() {
        return channelUserId;
    }

    public String getNoLoginFlag() {
        return noLoginFlag;
    }

    public String getClientIp() {
        return clientIp;
    }

    public String getSessionId() {
        return sessionId;
    }

    public boolean isNoLogin() {
        return noLogin;
    }

    public void setOperatorNo(String operatorNo) {
        this.operatorNo = operatorNo;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public void setOperatorRole(String operatorRole) {
        this.operatorRole = operatorRole;
    }

    public void setUpstreamApp(String upstreamApp) {
        this.upstreamApp = upstreamApp;
    }

    public void setChannelSource(String channelSource) {
        this.channelSource = channelSource;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

    public void setChannelVersion(String channelVersion) {
        this.channelVersion = channelVersion;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }

    public void setLoginToken(String loginToken) {
        this.loginToken = loginToken;
    }

    public void setChannelUserId(String channelUserId) {
        this.channelUserId = channelUserId;
    }

    public void setNoLoginFlag(String noLoginFlag) {
        this.noLoginFlag = noLoginFlag;
        this.noLogin = BaseConst.YES.equals(noLoginFlag);
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
