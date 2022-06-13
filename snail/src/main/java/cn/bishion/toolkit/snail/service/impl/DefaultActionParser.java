package cn.bishion.toolkit.snail.service.impl;

import cn.bishion.toolkit.snail.service.SnailSpelParser;

/**
 * @author: guofangbi
 * @date: 2022/6/5-11:27
 * @version: 1.0.0
 */
public class DefaultActionParser implements SnailSpelParser {
    public String parse(String action, Object[] params, Object resp) {
        return action;
    }
}
