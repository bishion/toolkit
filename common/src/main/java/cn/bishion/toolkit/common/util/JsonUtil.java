package cn.bishion.toolkit.common.util;

import cn.bishion.toolkit.common.consts.JsonError;
import cn.bishion.toolkit.common.dto.BizException;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JsonUtil {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    static {
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }

    public static final String toStr(Object object) {
        try {

            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            log.error("json 转换错误. {}", ToString.toString(object), e);
            throw BizException.throwExp(JsonError.TO_STR_ERROR);
        }
    }
}
