package io.github.bishion.common.util;


import com.alibaba.ttl.TransmittableThreadLocal;
import io.github.bishion.common.dto.BaseReqInfo;

public class ReqInfoHolder {
    private static final TransmittableThreadLocal<BaseReqInfo> reqInfoHolder = new TransmittableThreadLocal<>();

    public static BaseReqInfo getReqInfo() {
        return reqInfoHolder.get();
    }

    public static void setReqInfo(BaseReqInfo reqInfo) {
        reqInfoHolder.set(reqInfo);
    }


    public static void remove() {
        reqInfoHolder.remove();
    }
}
