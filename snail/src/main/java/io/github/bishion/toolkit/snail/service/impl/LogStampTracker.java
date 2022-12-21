package io.github.bishion.toolkit.snail.service.impl;

import io.github.bishion.toolkit.snail.dto.StampTrack;
import io.github.bishion.toolkit.snail.service.StampTracker;
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
