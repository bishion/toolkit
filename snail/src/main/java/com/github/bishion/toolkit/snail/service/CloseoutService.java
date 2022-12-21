package com.github.bishion.toolkit.snail.service;

import com.github.bishion.toolkit.snail.dto.StampTrack;

/**
 * 收尾服务
 *
 * @author: guofangbi
 * @date: 2022-06-05 21:11:47
 * @version: 1.0.0
 */
public interface CloseoutService {
    /**
     * 收尾
     *
     * @param stampTrack 邮票跟踪
     */
    void posted(StampTrack stampTrack);
}
