package cn.bishion.toolkit.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author: guofangbi
 * @date: 2022/5/29-8:56
 * @version: 1.0.0
 */
@SpringBootApplication
@EnableFeignClients
public class SampleDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SampleDemoApplication.class, args);
    }

}
