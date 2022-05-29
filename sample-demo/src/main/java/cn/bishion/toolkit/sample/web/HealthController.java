package cn.bishion.toolkit.sample.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: guofangbi
 * @date: 2022/5/29-8:57
 * @version: 1.0.0
 */
@RestController
public class HealthController {
    @RequestMapping("/health")
    public String health() {
        return "SUCCESS";
    }
}
