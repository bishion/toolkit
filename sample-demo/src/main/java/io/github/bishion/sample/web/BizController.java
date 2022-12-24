package io.github.bishion.sample.web;

import io.github.bishion.sample.service.BizService;
import io.github.bishion.sample.service.SpelService;
import io.github.bishion.toolkit.snail.annotation.Stamp;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: guofangbi
 * @version: 1.0.0
 * @since 2022/5/28-21:30
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
        return spelService.spelParser(text, null);
    }
}
