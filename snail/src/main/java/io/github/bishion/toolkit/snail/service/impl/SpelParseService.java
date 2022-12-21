package io.github.bishion.toolkit.snail.service.impl;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import io.github.bishion.common.consts.BaseConst;
import io.github.bishion.common.dto.BizException;
import io.github.bishion.toolkit.snail.consts.SnailError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.expression.BeanFactoryResolver;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.Map;

/**
 * @author: guofangbi
 * @since 2022/6/12-21:17
 * @version: 1.0.0
 */
@Slf4j
public class SpelParseService {
    private static final Cache<String, Expression> cache
            = CacheBuilder.newBuilder().maximumSize(BaseConst.INT_100).build();
    private BeanFactoryResolver beanFactoryResolver;
    private ExpressionParser parser = new SpelExpressionParser();

    public SpelParseService(BeanFactoryResolver beanFactoryResolver) {
        this.beanFactoryResolver = beanFactoryResolver;
    }

    public String parseSpel(String spel, Map<String, Object> paramMap) {

        StandardEvaluationContext context = new StandardEvaluationContext();
        context.setBeanResolver(beanFactoryResolver);

        for (Map.Entry<String, Object> entry : paramMap.entrySet()) {
            context.setVariable(entry.getKey(), entry.getValue());
        }
        return getExpression(spel).getValue(context, String.class);
    }

    private Expression getExpression(String spel) {
        try {
            return cache.get(spel, () -> parser.parseExpression(spel));
        } catch (Exception e) {
            log.error("spel 解析失败. {},", e.getMessage());
            throw BizException.throwExp(SnailError.SPEL_PARSE_FAIL, spel);
        }
    }

}
