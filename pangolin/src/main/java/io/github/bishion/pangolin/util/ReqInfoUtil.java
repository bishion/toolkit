package io.github.bishion.pangolin.util;

import io.github.bishion.common.dto.BaseReqInfo;
import io.github.bishion.pangolin.consts.ReqHeaderKeyEnum;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 基本操作信息
 *
 * @author: guofangbi
 * @since: 2022-06-13 22:23:14
 * @version: 1.0.0
 */
public class ReqInfoUtil {


    public static final Map<String, Collection<String>> convert2MapList(BaseReqInfo reqInfo) {
        Map<String, Collection<String>> map = new HashMap<>();
        map.put(ReqHeaderKeyEnum.OPERATOR_NO.getKey(), Arrays.asList(reqInfo.getOperatorNo()));
        map.put(ReqHeaderKeyEnum.OPERATOR_NAME.getKey(), Arrays.asList(reqInfo.getOperatorName()));
        map.put(ReqHeaderKeyEnum.OPERATOR_ROLE.getKey(), Arrays.asList(reqInfo.getOperatorRole()));
        map.put(ReqHeaderKeyEnum.UPSTREAM_APP.getKey(), Arrays.asList(reqInfo.getUpstreamApp()));
        map.put(ReqHeaderKeyEnum.CHANNEL_SOURCE.getKey(), Arrays.asList(reqInfo.getChannelSource()));
        map.put(ReqHeaderKeyEnum.CHANNEL_CODE.getKey(), Arrays.asList(reqInfo.getChannelCode()));
        map.put(ReqHeaderKeyEnum.CHANNEL_VERSION.getKey(), Arrays.asList(reqInfo.getChannelVersion()));
        map.put(ReqHeaderKeyEnum.CHANNEL_TYPE.getKey(), Arrays.asList(reqInfo.getChannelType()));
        map.put(ReqHeaderKeyEnum.LOGIN_TOKEN.getKey(), Arrays.asList(reqInfo.getLoginToken()));
        map.put(ReqHeaderKeyEnum.CHANNEL_USER_ID.getKey(), Arrays.asList(reqInfo.getChannelUserId()));
        map.put(ReqHeaderKeyEnum.NO_LOGIN_FLAG.getKey(), Arrays.asList(reqInfo.getNoLoginFlag()));
        map.put(ReqHeaderKeyEnum.CLIENT_IP.getKey(), Arrays.asList(reqInfo.getClientIp()));
        map.put(ReqHeaderKeyEnum.SESSION_ID.getKey(), Arrays.asList(reqInfo.getSessionId()));

        return map;
    }

    public static final BaseReqInfo getReqInfoByRequest(HttpServletRequest request) {
        BaseReqInfo reqInfo = new BaseReqInfo();
        reqInfo.setOperatorNo(request.getHeader(ReqHeaderKeyEnum.OPERATOR_NO.getKey()));
        reqInfo.setOperatorName(request.getHeader(ReqHeaderKeyEnum.OPERATOR_NAME.getKey()));
        reqInfo.setOperatorRole(request.getHeader(ReqHeaderKeyEnum.OPERATOR_ROLE.getKey()));
        reqInfo.setUpstreamApp(request.getHeader(ReqHeaderKeyEnum.UPSTREAM_APP.getKey()));
        reqInfo.setChannelSource(request.getHeader(ReqHeaderKeyEnum.CHANNEL_SOURCE.getKey()));
        reqInfo.setChannelCode(request.getHeader(ReqHeaderKeyEnum.CHANNEL_CODE.getKey()));
        reqInfo.setChannelVersion(request.getHeader(ReqHeaderKeyEnum.CHANNEL_VERSION.getKey()));
        reqInfo.setChannelType(request.getHeader(ReqHeaderKeyEnum.CHANNEL_TYPE.getKey()));
        reqInfo.setLoginToken(request.getHeader(ReqHeaderKeyEnum.LOGIN_TOKEN.getKey()));
        reqInfo.setChannelUserId(request.getHeader(ReqHeaderKeyEnum.CHANNEL_USER_ID.getKey()));
        reqInfo.setNoLoginFlag(request.getHeader(ReqHeaderKeyEnum.NO_LOGIN_FLAG.getKey()));

        reqInfo.setClientIp(request.getHeader(ReqHeaderKeyEnum.CLIENT_IP.getKey()));
        reqInfo.setSessionId(request.getHeader(ReqHeaderKeyEnum.SESSION_ID.getKey()));

        return reqInfo;
    }
}
