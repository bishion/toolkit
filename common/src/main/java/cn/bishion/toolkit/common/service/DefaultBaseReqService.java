package cn.bishion.toolkit.common.service;

import cn.bishion.toolkit.common.dto.BaseReqInfo;
import cn.bishion.toolkit.common.dto.ReqInfoHolder;

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
