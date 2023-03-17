package io.github.bishion.web.starter;

//import cn.hutool.core.util.IdUtil;
//import org.apache.ibatis.mapping.SqlSource;
//import org.apache.ibatis.scripting.xmltags.XMLLanguageDriver;
//import org.apache.ibatis.session.Configuration;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @GetMapping("login")
    public String login() {
        return "IdUtil.fastUUID()";
    }

    public static void main(String[] args) {
       /* String script = "<script> select * from user_info <if test=\"username !=null\">where username=#{username}</if></script>";

        XMLLanguageDriver driver = new XMLLanguageDriver();
        Map<String, String> param = new HashMap<String, String>() {
            {
                put("username", "1");
            }
        };
        SqlSource sqlSource = driver.createSqlSource(new Configuration(), script, String.class);

        System.out.println(sqlSource);*/
    }

}
