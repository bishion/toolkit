package cn.bishion.toolkit.snail.service.impl;

import cn.bishion.toolkit.common.consts.BaseConst;
import cn.bishion.toolkit.snail.service.SnailSpelParser;
import cn.hutool.core.util.ArrayUtil;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: guofangbi
 * @date: 2022/6/5-13:17
 * @version: 1.0.0
 */
public class SpelDefaultParser implements SnailSpelParser {
    @Resource
    private SpelParseService spelParseService;

    public String parse(String spel, Object[] params, Object resp) {
        Map<String, Object> param = new HashMap<>(BaseConst.INT_1);
        if (ArrayUtil.length(params) == BaseConst.INT_1) {
            param.put(PARAM_REQ, params[BaseConst.INT_0]);
        } else {
            param.put(PARAM_REQ, params);
        }
        param.put(PARAM_RESP, resp);
        return spelParseService.parseSpel(spel, param);
    }
}
