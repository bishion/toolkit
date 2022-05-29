package cn.bishion.toolkit.sample.web;

import cn.bishion.toolkit.pangolin.entrance.dto.ReqInfoHolder;
import cn.bishion.toolkit.sample.service.BizService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: guofangbi
 * @date: 2022/5/28-21:30
 * @version: 1.0.0
 */
@RestController
public class BizController {
    @Resource
    private BizService bizService;
    private ExecutorService executorService = Executors.newCachedThreadPool();

    @RequestMapping("/remote")
    public String remote() {
        Arrays.asList(123, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 11, 21, 22, 222, 223, 345, 5, 566).parallelStream().forEach(item -> System.out.println(ReqInfoHolder.getReqInfo())
        );


        return bizService.searchBing();
    }

}
