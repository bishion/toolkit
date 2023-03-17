package io.github.bishion.web.health;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HealthController {
    @GetMapping("/health")
    @ResponseBody
    public void health() {
        // 默认不返回
    }
}
