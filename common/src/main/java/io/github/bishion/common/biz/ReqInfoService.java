package io.github.bishion.common.biz;

import io.github.bishion.common.dto.BaseReqInfo;

public interface ReqInfoService {
    String operatorNo();

    BaseReqInfo currentReqInfo();

}
