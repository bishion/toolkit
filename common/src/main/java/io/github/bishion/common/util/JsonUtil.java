package io.github.bishion.common.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.bishion.common.consts.JsonError;
import io.github.bishion.common.dto.BizException;

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
            throw BizException.throwExp(JsonError.TO_STR_ERROR, ToString.toString(object));
        }
    }
}
