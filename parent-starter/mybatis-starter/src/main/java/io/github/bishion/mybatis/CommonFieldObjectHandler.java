package io.github.bishion.mybatis;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import io.github.bishion.common.biz.ReqInfoService;
import io.github.bishion.common.consts.BaseConst;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.reflection.MetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author MyMetaObjectHandler
 */
@Component
public class CommonFieldObjectHandler implements MetaObjectHandler {
    private static final Logger log = LoggerFactory.getLogger(CommonFieldObjectHandler.class);
    @Resource
    private ReqInfoService reqInfoService;

    /**
     * 插入时的填充策略
     *
     * @param metaObject MetaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        Date now = new Date();
        this.setFieldValByName("gmtCreated", now, metaObject);
        this.setFieldValByName("gmtModified", now, metaObject);
        String operator = getOperator();
        log.debug("start insert fill operator:{}", operator);

        this.setFieldValByName("creator", operator, metaObject);
        this.setFieldValByName("modifier", operator, metaObject);
        this.setFieldValByName("version", BaseConst.INT_1, metaObject);
    }

    /**
     * 更新时的填充策略
     *
     * @param metaObject 元数据
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        String operator = getOperator();
        log.debug("start update fill operator:{}", operator);

        this.setFieldValByName("gmtModified", new Date(), metaObject);
        this.setFieldValByName("modifier", operator, metaObject);
    }

    private String getOperator() {
        return StringUtils.defaultIfBlank(reqInfoService.operatorNo(), BaseConst.UNKNOWN);
    }

}
