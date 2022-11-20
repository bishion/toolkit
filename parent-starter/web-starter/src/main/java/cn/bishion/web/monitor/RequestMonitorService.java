package cn.bishion.web.monitor;

public interface RequestMonitorService {
    void logRequest(String module, String method, Long costs, String result, String errorMsg);
}
