package cn.bishion.toolkit.common.util;

import cn.bishion.toolkit.common.consts.BaseConst;
import cn.hutool.core.net.NetUtil;
import org.apache.commons.lang3.StringUtils;

/**
 * @author: guofangbi
 * @date: 2022/6/5-15:46
 * @version: 1.0.0
 */
public class EnvUtil {
    private EnvUtil() {
    }

    private static final String FIELD_HOSTNAME = "HOSTNAME";
    private static final String FIELD_HOST_IP = "HOST_IP";
    private static final String DEPLOY_ENV = "DEPLOY_ENV";
    private static final String PRD_ENV = "prd";
    public static final String ENV = System.getenv(DEPLOY_ENV);
    public static final boolean ENV_IS_PRD = StringUtils.equals(ENV, PRD_ENV);

    public static final String HOST_NAME = StringUtils.defaultString(System.getenv(FIELD_HOSTNAME), BaseConst.UNKNOWN);
    public static final String HOST_IP = StringUtils.defaultString(System.getenv(FIELD_HOST_IP), BaseConst.UNKNOWN);
    public static final String LOCAL_HOSTNAME = NetUtil.getLocalHostName();
    public static final String LOCAL_HOST_IP = NetUtil.getLocalhost().getHostAddress();
}
