package cn.bishion.toolkit.snail.service.impl;

import cn.bishion.toolkit.common.util.SpringUtil;
import cn.bishion.toolkit.snail.annotation.Stamp;
import cn.bishion.toolkit.snail.dto.StampTrack;
import cn.bishion.toolkit.snail.service.CloseoutService;
import cn.bishion.toolkit.snail.service.StampTracker;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: guofangbi
 * @date: 2022/6/5-21:00
 * @version: 1.0.0
 */
public class StampTrackService {
    @Resource
    private List<StampTracker> stampTrackerList;

    public void persist(StampTrack stampTrack, Stamp stamp) {
        stampTrackerList.parallelStream().forEach(stampTracker ->
                stampTracker.persist(stampTrack)
        );
        SpringUtil.getBean(stamp.closeoutService(), CloseoutService.class).posted(stampTrack);
    }
}
