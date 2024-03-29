package io.github.bishion.web.advice;

import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.RandomUtil;
import io.github.bishion.common.consts.BaseConst;
import io.github.bishion.common.dto.BaseResult;
import io.github.bishion.common.dto.BizException;
import io.github.bishion.common.util.ExceptionUtil;
import io.github.bishion.web.consts.WebError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Slf4j
@ControllerAdvice
public class GlobalExceptionAdvice {
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    public Object illegalArgument(IllegalArgumentException e) {
        return BaseResult.fail(WebError.PARAM_ILLEGAL, e.getMessage());
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    public Object requestMethodNotSupported(HttpRequestMethodNotSupportedException e, HttpServletRequest request) {
        log.warn("requestPath:{},method:{}", request.getServletPath(), e.getMethod());
        return BaseResult.fail(WebError.REQ_NOT_SUPPORT);
    }

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    @ResponseBody
    public Object maxUploadSizeExceededException(MaxUploadSizeExceededException e, HttpServletRequest request) {
        log.info("requestPath:{}, msg:{}", request.getServletPath(), e.getMessage());
        if (e.getMaxUploadSize() < 0) {
            return BaseResult.fail(WebError.FILE_TOO_LARGE);
        }
        BigDecimal mSize = BigDecimal.valueOf(e.getMaxUploadSize()).divide(BigDecimal.valueOf(1048576), 0, RoundingMode.UP);
        return BaseResult.fail(WebError.FILE_TOO_LARGE.PARAM_ILLEGAL, "文件不得超过" + mSize + "M，请重新上传。");
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object systemException(Exception e, HttpServletRequest request) {
        String errorCode = randomErrorCode();
        e.printStackTrace();
        log.error("path:{},errCode:{}, error: ", request.getServletPath(), errorCode, e);
        return BaseResult.fail(WebError.SYS_ERROR, randomErrorCode());
    }

    /**
     * 处理业务异常
     */
    @ExceptionHandler(BizException.class)
    @ResponseBody
    Object handleBusinessException(BizException e) {
        log.info("BizException :{},", ExceptionUtil.printStackWith10Lines(e));
        return new BaseResult<>(e.getCode(), e.getMsg());
    }

    private static final String LAST_IP_SEG = (NetUtil.getLocalhost().getAddress()[BaseConst.INT_3] & 0xff)
            + BaseConst.UNDERSCORE;

    public static final String randomErrorCode() {
        return LAST_IP_SEG + RandomUtil.randomString(8);
    }
}
