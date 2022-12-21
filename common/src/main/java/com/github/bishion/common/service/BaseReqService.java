package com.github.bishion.common.service;

import com.github.bishion.common.dto.BaseReqInfo;

/**
 * @author: guofangbi
 * @date: 2022/6/4-19:42
 * @version: 1.0.0
 */
public interface BaseReqService {
    /**
     * 获取基础请求信息
     *
     * @return {@link BaseReqInfo}
     */
    BaseReqInfo getBaseReqInfo();
}
