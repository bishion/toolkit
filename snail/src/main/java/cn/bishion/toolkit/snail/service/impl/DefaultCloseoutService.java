package cn.bishion.toolkit.snail.service.impl;

import cn.bishion.toolkit.snail.dto.StampTrack;
import cn.bishion.toolkit.snail.service.CloseoutService;

/**
 * @author: guofangbi
 * @date: 2022/6/5-21:13
 * @version: 1.0.0
 */
public class DefaultCloseoutService implements CloseoutService {
    /**
     * 发布
     *
     * @param stampTrack 邮票跟踪
     */
    @Override
    public void posted(StampTrack stampTrack) {
        // 默认不需要收尾动作，所以这里啥也不做
    }
}
