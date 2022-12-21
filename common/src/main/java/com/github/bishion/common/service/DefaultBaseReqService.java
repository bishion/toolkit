package com.github.bishion.common.service;

import com.github.bishion.common.dto.BaseReqInfo;
import com.github.bishion.common.dto.ReqInfoHolder;

/**
 * @author: guofangbi
 * @date: 2022/6/5-11:58
 * @version: 1.0.0
 */
public class DefaultBaseReqService implements BaseReqService {
    @Override
    public BaseReqInfo getBaseReqInfo() {
        return ReqInfoHolder.getReqInfo();
    }
}
