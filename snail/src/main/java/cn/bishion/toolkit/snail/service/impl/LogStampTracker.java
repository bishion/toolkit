package cn.bishion.toolkit.snail.service.impl;

import cn.bishion.toolkit.snail.dto.StampTrack;
import cn.bishion.toolkit.snail.service.StampTracker;
import lombok.extern.slf4j.Slf4j;

/**
 * @author: guofangbi
 * @date: 2022/6/5-11:44
 * @version: 1.0.0
 */
@Slf4j
public class LogStampTracker implements StampTracker {
    public void persist(StampTrack stampTrack) {
        log.info(stampTrack.toString());
    }
}
