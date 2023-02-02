package io.github.bishion.common.biz;

public interface EnvService {
    Boolean isPrd();

    Boolean isTest();

    String hostName();

    String hostIp();

    String podIp();

    String podName();
}
