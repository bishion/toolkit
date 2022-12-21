package io.github.bishion.sample.remote;

import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: guofangbi
 * @date: 2022/5/28-20:04
 * @version: 1.0.0
 */
@FeignClient(name = "bingRemote", url = "https://cn.bing.com")
public interface BingRemote {
    /**
     * 根据关键词搜索Bing的新闻
     *
     * @param key 关键
     * @return {@link String}
     */
    @GetMapping(value = "/news/NewsAnswerV2CarouselAjax")
    String search(@Param("q") String key);
}
