package cn.bishion.toolkit.pangolin.entrance.dto;

/**
 * @author: guofangbi
 * @date: 2022/5/28-9:42
 * @version: 1.0.0
 */
public class ReqInfoHolder {
    private ReqInfoHolder() {

    }

    private static final ThreadLocal<BaseReqInfo> reqInfo = new ThreadLocal<>();

    public static void setReqInfo(BaseReqInfo baseReqInfo) {
        reqInfo.set(baseReqInfo);
    }

    public static BaseReqInfo getReqInfo() {
        return reqInfo.get();
    }

    public static void removeOptInfo() {
        reqInfo.remove();
    }
}
