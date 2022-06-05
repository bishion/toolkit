package cn.bishion.toolkit.snail.service.impl;

import cn.bishion.toolkit.snail.service.ParamParser;

import java.util.Arrays;

/**
 * @author: guofangbi
 * @date: 2022/6/5-11:28
 * @version: 1.0.0
 */
public class DefaultParamParser implements ParamParser {
    public String parse(Object[] params) {
        return Arrays.deepToString(params);
    }

}
