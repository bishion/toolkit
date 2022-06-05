package cn.bishion.toolkit.snail.service;

/**
 * @author: guofangbi
 * @date: 2022/6/4-20:14
 * @version: 1.0.0
 */
public interface ActionParser {
    /**
     * 解析操作内容
     *
     * @param params 参数个数
     * @param action 行动
     * @return {@link String}
     */
    String parse(String action, Object[] params);
}
