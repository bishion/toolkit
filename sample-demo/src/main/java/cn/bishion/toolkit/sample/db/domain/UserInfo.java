package cn.bishion.toolkit.sample.db.domain;

import cn.bishion.mybatis.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
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