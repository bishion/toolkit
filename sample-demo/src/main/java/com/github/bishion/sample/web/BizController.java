package com.github.bishion.sample.web;

import com.github.bishion.common.dto.BaseReqInfo;
import com.github.bishion.sample.service.BizService;
import com.github.bishion.sample.service.SpelService;
import com.github.bishion.toolkit.snail.annotation.Stamp;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    @Resource
    private SpelService spelService;

    @Stamp(action = "test", bizNo = "#req", actionType = "test", module = "sdd")
    @RequestMapping("/remote")
    public String remote() {
        return bizService.searchBing();
    }

    @Stamp(action = "#req", bizNo = "#req", actionType = "test", module = "sdd", actionParser = Stamp.SPEL_ACTION_PARSER)
    @PostMapping(value = "/spel")
    public String spel(@RequestParam("text") String text) {
        BaseReqInfo[] reqInfos = new BaseReqInfo[]{BaseReqInfo.builder().build(), BaseReqInfo.builder().build()};
        return spelService.spelParser(text, reqInfos);
    }
}
