package io.github.bishion.demo.swagger;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"测试swagger"})
@RestController
public class SwaggerTestController {
    @ApiOperation(value = "health", notes = "health 接口")
    @GetMapping("/health")
    public String health() {
        return "SUCCESS";
    }
}
