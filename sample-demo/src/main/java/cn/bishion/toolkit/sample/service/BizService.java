package cn.bishion.toolkit.sample.service;

import cn.bishion.toolkit.sample.remote.BingRemote;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;

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

    public String searchBing(String q) {
        return bingRemote.search(q);
    }


    public String searchBing(Object[] q) {
        return Arrays.toString(q);
    }
}
