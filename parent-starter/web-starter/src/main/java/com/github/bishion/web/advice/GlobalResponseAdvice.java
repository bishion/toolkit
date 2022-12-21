package com.github.bishion.web.advice;

import cn.hutool.core.util.StrUtil;
import com.github.bishion.common.dto.BaseResult;
import com.github.bishion.common.util.JsonUtil;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice
public class GlobalResponseAdvice implements ResponseBodyAdvice {

    @Override
    public boolean supports(MethodParameter methodParameter, Class converterType) {

        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType,
                                  Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {


        if (body instanceof String) {
            return JsonUtil.toStr(BaseResult.success(body));
        }

        return (MediaType.APPLICATION_JSON_VALUE.equalsIgnoreCase(String.valueOf(request.getHeaders().getContentType()))
                && !(StrUtil.containsAny(request.getURI().getPath(), "/health", "/swagger-resources")))
                ? BaseResult.success(body) : body;
    }
}