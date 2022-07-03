package cn.bishion.toolkit.snail.aspect;

import cn.bishion.toolkit.common.consts.BaseConst;
import cn.bishion.toolkit.common.dto.BaseResult;
import cn.bishion.toolkit.snail.annotation.Stamp;
import cn.bishion.toolkit.snail.dto.StampTrack;
import cn.bishion.toolkit.snail.service.BuildStampTrackService;
import cn.bishion.toolkit.snail.service.impl.StampTrackService;
import cn.hutool.core.text.CharSequenceUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * 打点核心切面
 *
 * @author: guofangbi
 * @date: 2022/6/4-20:45
 * @version: 1.0.0
 */
@Slf4j
@Aspect
public class StampAspect {
    @Value("${toolkit.snail.maxRespLen:1024}")
    private Integer maxRespLen;

    @Resource
    private BuildStampTrackService buildStampTrackService;
    @Resource
    private StampTrackService stampTrackService;

    @Around(value = "@annotation(cn.bishion.toolkit.snail.annotation.Stamp)&&@annotation(stamp)")
    public Object process(ProceedingJoinPoint joinPoint, Stamp stamp) throws Throwable {
        Long startTime = System.currentTimeMillis();


        Object[] args = joinPoint.getArgs();
        StampTrack.StampTrackBuilder builder = buildStampTrackService.createStampTrackBuilder(stamp, args);
        try {
            Object result = joinPoint.proceed();
            String response = Objects.isNull(result) ? null : result.toString();
            if (result instanceof BaseResult && !((BaseResult<?>) result).valid()) {
                builder.success(BaseConst.FAILURE);
            } else {
                builder.success(BaseConst.SUCCESS);
            }
            builder.response(CharSequenceUtil.subPre(response, maxRespLen));
            buildStampTrackService.buildReqAndResp(builder, stamp, args, response);
            return result;
        } catch (Exception e) {
            builder.success(BaseConst.FAILURE).response(CharSequenceUtil.subPre(e.getMessage(), maxRespLen));
            throw e;
        } finally {
            Long endTime = System.currentTimeMillis();
            builder.costTime(endTime - startTime).endTime(endTime);

            stampTrackService.persist(builder.build(), stamp);
        }
    }

}
