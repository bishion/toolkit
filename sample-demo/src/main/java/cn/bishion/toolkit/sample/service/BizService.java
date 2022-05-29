package cn.bishion.toolkit.sample.service;

import cn.bishion.toolkit.sample.remote.BingRemote;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: guofangbi
 * @date: 2022/5/28-20:08
 * @version: 1.0.0
 */
@Service
public class BizService {
    @Resource
    private BingRemote bingRemote;

    public String searchBing() {
        return bingRemote.search("test");
    }
}
