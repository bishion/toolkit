package io.github.bishion.mybatis;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;

public abstract class BaseEntity {
    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 版本标识
     */
    @Version
    @TableField(value = "version", fill = FieldFill.INSERT)
    private Integer version;

    /**
     * 是否删除
     */
    @TableField(value = "is_deleted")
    private String isDeleted;

    /**
     * 创建人
     */
    @TableField(value = "creator", fill = FieldFill.INSERT)
    private String creator;

    /**
     * 创建时间
     */
    @TableField(value = "gmt_created", fill = FieldFill.INSERT_UPDATE)
    private Date gmtCreated;

    /**
     * 修改人
     */
    @TableField(value = "modifier", fill = FieldFill.INSERT_UPDATE)
    private String modifier;

    /**
     * 修改时间
     */
    @TableField(value = "gmt_modified", fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "id=" + id +
                ", version=" + version +
                ", isDeleted='" + isDeleted + '\'' +
                ", creator='" + creator + '\'' +
                ", gmtCreated=" + gmtCreated +
                ", modifier='" + modifier + '\'' +
                ", gmtModified=" + gmtModified +
                '}';
    }
}
