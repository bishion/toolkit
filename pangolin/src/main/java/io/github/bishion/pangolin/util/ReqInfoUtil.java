package io.github.bishion.pangolin.util;

import io.github.bishion.common.dto.BaseReqInfo;
import io.github.bishion.pangolin.consts.ReqHeaderKeyEnum;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 基本操作信息
 *
 * @author: guofangbi
 * @version: 1.0.0
 * @since : 2022-06-13 22:23:14
 */
public class ReqInfoUtil {


    public static Map<String, Collection<String>> convert2MapList(BaseReqInfo reqInfo, String appName) {
        Map<String, Collection<String>> map = new HashMap<>();
        map.put(ReqHeaderKeyEnum.OPERATOR_NO.getKey(), Collections.singletonList(reqInfo.getOperatorNo()));
        map.put(ReqHeaderKeyEnum.OPERATOR_NAME.getKey(), Collections.singletonList(reqInfo.getOperatorName()));
        map.put(ReqHeaderKeyEnum.OPERATOR_ROLE.getKey(), Collections.singletonList(reqInfo.getOperatorRole()));
        map.put(ReqHeaderKeyEnum.UPSTREAM_APP.getKey(), Collections.singletonList(appName));
        map.put(ReqHeaderKeyEnum.CHANNEL_SOURCE.getKey(), Collections.singletonList(reqInfo.getChannelSource()));
        map.put(ReqHeaderKeyEnum.CHANNEL_CODE.getKey(), Collections.singletonList(reqInfo.getChannelCode()));
        map.put(ReqHeaderKeyEnum.CHANNEL_VERSION.getKey(), Collections.singletonList(reqInfo.getChannelVersion()));
        map.put(ReqHeaderKeyEnum.CHANNEL_GROUP.getKey(), Collections.singletonList(reqInfo.getChannelType()));
        map.put(ReqHeaderKeyEnum.LOGIN_TOKEN.getKey(), Collections.singletonList(reqInfo.getLoginToken()));
        map.put(ReqHeaderKeyEnum.CHANNEL_USER_ID.getKey(), Collections.singletonList(reqInfo.getChannelUserId()));
        map.put(ReqHeaderKeyEnum.NO_LOGIN_FLAG.getKey(), Collections.singletonList(reqInfo.getNoLoginFlag()));
        map.put(ReqHeaderKeyEnum.CLIENT_IP.getKey(), Collections.singletonList(reqInfo.getClientIp()));
        map.put(ReqHeaderKeyEnum.SESSION_ID.getKey(), Collections.singletonList(reqInfo.getSessionId()));

        return map;
    }

    public static BaseReqInfo getReqInfoByRequest(HttpServletRequest request) {
        BaseReqInfo reqInfo = new BaseReqInfo();
        reqInfo.setOperatorNo(request.getHeader(ReqHeaderKeyEnum.OPERATOR_NO.getKey()));
        reqInfo.setOperatorName(request.getHeader(ReqHeaderKeyEnum.OPERATOR_NAME.getKey()));
        reqInfo.setOperatorRole(request.getHeader(ReqHeaderKeyEnum.OPERATOR_ROLE.getKey()));
        reqInfo.setUpstreamApp(request.getHeader(ReqHeaderKeyEnum.UPSTREAM_APP.getKey()));
        reqInfo.setChannelSource(request.getHeader(ReqHeaderKeyEnum.CHANNEL_SOURCE.getKey()));
        reqInfo.setChannelCode(request.getHeader(ReqHeaderKeyEnum.CHANNEL_CODE.getKey()));
        reqInfo.setChannelVersion(request.getHeader(ReqHeaderKeyEnum.CHANNEL_VERSION.getKey()));
        reqInfo.setChannelType(request.getHeader(ReqHeaderKeyEnum.CHANNEL_GROUP.getKey()));
        reqInfo.setLoginToken(request.getHeader(ReqHeaderKeyEnum.LOGIN_TOKEN.getKey()));
        reqInfo.setChannelUserId(request.getHeader(ReqHeaderKeyEnum.CHANNEL_USER_ID.getKey()));
        reqInfo.setNoLoginFlag(request.getHeader(ReqHeaderKeyEnum.NO_LOGIN_FLAG.getKey()));

        reqInfo.setClientIp(request.getHeader(ReqHeaderKeyEnum.CLIENT_IP.getKey()));
        reqInfo.setSessionId(request.getHeader(ReqHeaderKeyEnum.SESSION_ID.getKey()));

        return reqInfo;
    }
}
