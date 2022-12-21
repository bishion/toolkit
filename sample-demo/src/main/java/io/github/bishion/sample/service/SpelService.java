package io.github.bishion.sample.service;

import cn.hutool.core.util.ArrayUtil;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.expression.BeanFactoryResolver;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: guofangbi
 * @since 2022/6/6-9:43
 * @version: 1.0.0
 */
@Service
public class SpelService {
    @Resource
    private BeanFactory beanFactory;

    public String spelParser(String text, Object[] param) {

        ExpressionParser parser = new SpelExpressionParser();
        StandardEvaluationContext context = new StandardEvaluationContext();
        context.setBeanResolver(new BeanFactoryResolver(beanFactory));
        if (ArrayUtil.length(param) == 1) {
            context.setVariable("req", param[0]);
        } else {
            context.setVariable("req", param);

        }
        return parser.parseExpression(text).getValue(context, String.class);
    }
}
