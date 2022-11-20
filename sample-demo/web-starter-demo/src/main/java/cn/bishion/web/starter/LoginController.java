package cn.bishion.web.starter;

import cn.hutool.core.util.IdUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @GetMapping("login")
    public String login() {
        return IdUtil.fastUUID();
    }

}
