package cn.bishion.toolkit.sample.web;

import cn.bishion.toolkit.sample.service.BizService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: guofangbi
 * @date: 2022/5/28-21:30
 * @version: 1.0.0
 */
@RestController
public class BizController {
    @Resource
    private BizService bizService;

    @RequestMapping("/remote")
    public String remote() {
        return bizService.searchBing();
    }
    
}
