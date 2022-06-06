package cn.bishion.toolkit.snail.service.impl;

import cn.bishion.toolkit.common.consts.BaseConst;
import cn.bishion.toolkit.snail.service.ActionParser;
import cn.hutool.core.util.ArrayUtil;
import org.springframework.context.expression.BeanFactoryResolver;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * @author: guofangbi
 * @date: 2022/6/5-13:17
 * @version: 1.0.0
 */
public class SpelActionParser implements ActionParser {
    private BeanFactoryResolver beanFactoryResolver;
    private static final String PARAM_REQ = "req";

    public SpelActionParser(BeanFactoryResolver beanFactoryResolver) {
        this.beanFactoryResolver = beanFactoryResolver;
    }

    public String parse(String action, Object[] params) {
        ExpressionParser parser = new SpelExpressionParser();
        StandardEvaluationContext context = new StandardEvaluationContext();
        context.setBeanResolver(beanFactoryResolver);
        if (ArrayUtil.length(params) == BaseConst.INT_1) {
            context.setVariable(PARAM_REQ, params[BaseConst.INT_0]);
        } else {
            context.setVariable(PARAM_REQ, params);

        }
        return parser.parseExpression(action).getValue(context, String.class);
    }
}
