package cn.bishion.web.advice;

import cn.bishion.toolkit.common.dto.BaseResult;
import cn.bishion.toolkit.common.util.JsonUtil;
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

        if ("/health".equals(request.getURI().getPath())) {
            return body;
        }
        if (body instanceof String) {
            return JsonUtil.toStr(BaseResult.success(body));
        }
        return BaseResult.success(body);
    }
}