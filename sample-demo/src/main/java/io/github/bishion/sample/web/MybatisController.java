package io.github.bishion.sample.web;

import io.github.bishion.sample.db.domain.UserInfo;
import io.github.bishion.sample.db.mapper.UserInfoMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class MybatisController {

    @Resource
    private UserInfoMapper userInfoMapper;

    @GetMapping("/user/insert")
    public String insert() {
        UserInfo userInfo = new UserInfo();

        userInfo.setLoginName("testLoginName");
        userInfo.setPassword("testPassword");
        userInfo.setUsername("testUsername");

        int insert = userInfoMapper.insert(userInfo);
        return String.valueOf(insert);
    }

    @GetMapping("/user/update")
    public String update() {
        UserInfo userInfo = new UserInfo();
        userInfo.setVersion(2);
        userInfo.setUsername("testUpdate");
        userInfo.setId(5L);
        int insert = userInfoMapper.updateById(userInfo);
        return String.valueOf(insert);
    }
}
