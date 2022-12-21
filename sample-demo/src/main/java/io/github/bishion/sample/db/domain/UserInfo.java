package io.github.bishion.sample.db.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.github.bishion.mybatis.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @TableName user_info
 */
@TableName(value = "user_info")
@Getter
@Setter
public class UserInfo extends BaseEntity implements Serializable {

    /**
     *
     */
    private String username;

    /**
     *
     */
    private String loginName;

    /**
     *
     */
    private String password;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}