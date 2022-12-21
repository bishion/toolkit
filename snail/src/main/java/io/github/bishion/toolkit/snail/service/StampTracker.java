package io.github.bishion.toolkit.snail.service;

import io.github.bishion.toolkit.snail.dto.StampTrack;

/**
 * @author: guofangbi
 * @date: 2022/6/5-11:18
 * @version: 1.0.0
 */
public interface StampTracker {
    /**
     * 持久化追踪数据
     *
     * @param stampTrack 邮票跟踪
     */
    void persist(StampTrack stampTrack);
}
