package cn.bishion.mybatis;

import cn.bishion.toolkit.common.consts.BaseConst;
import cn.bishion.toolkit.common.service.BaseReqService;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author MyMetaObjectHandler
 */
@Slf4j
@Component
public class CommonFieldObjectHandler implements MetaObjectHandler {

    @Resource
    private BaseReqService baseReqService;

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
        return StringUtils.defaultIfBlank(baseReqService.getBaseReqInfo().getOperator(), BaseConst.UNKNOWN);
    }

}
