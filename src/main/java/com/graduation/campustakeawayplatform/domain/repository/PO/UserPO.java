package com.graduation.campustakeawayplatform.domain.repository.PO;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 
 * @TableName user
 */
@TableName(value ="user")
@Data
public class UserPO implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id")
    private String id;

    /**
     * 登录名
     */
    @TableField(value = "login_name")
    private String loginName;

    /**
     * 密码
     */
    @TableField(value = "pass_word")
    private String passWord;

    /**
     * 性别 1：男   2： 女
     */
    @TableField(value = "sex")
    private Integer sex;

    /**
     * 收货地址
     */
    @TableField(value = "address")
    private String address;

    /**
     * 启用： 0，锁定： 1
     */
    @TableField(value = "enable_flag")
    private Integer enableFlag;

    /**
     * 用户类型 1：学生 2： 老师
     */
    @TableField(value = "user_type")
    private Integer userType;

    /**
     * 创建时间
     */
    @TableField(value = "create_date")
    private LocalDateTime createDate;

    /**
     * 最后更新时间
     */
    @TableField(value = "last_update_date")
    private LocalDateTime lastUpdateDate;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        UserPO other = (UserPO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getLoginName() == null ? other.getLoginName() == null : this.getLoginName().equals(other.getLoginName()))
                && (this.getPassWord() == null ? other.getPassWord() == null : this.getPassWord().equals(other.getPassWord()))
                && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
                && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
                && (this.getEnableFlag() == null ? other.getEnableFlag() == null : this.getEnableFlag().equals(other.getEnableFlag()))
                && (this.getUserType() == null ? other.getUserType() == null : this.getUserType().equals(other.getUserType()))
                && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
                && (this.getLastUpdateDate() == null ? other.getLastUpdateDate() == null : this.getLastUpdateDate().equals(other.getLastUpdateDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getLoginName() == null) ? 0 : getLoginName().hashCode());
        result = prime * result + ((getPassWord() == null) ? 0 : getPassWord().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getEnableFlag() == null) ? 0 : getEnableFlag().hashCode());
        result = prime * result + ((getUserType() == null) ? 0 : getUserType().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getLastUpdateDate() == null) ? 0 : getLastUpdateDate().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", loginName=").append(loginName);
        sb.append(", passWord=").append(passWord);
        sb.append(", sex=").append(sex);
        sb.append(", address=").append(address);
        sb.append(", enableFlag=").append(enableFlag);
        sb.append(", userType=").append(userType);
        sb.append(", createDate=").append(createDate);
        sb.append(", lastUpdateDate=").append(lastUpdateDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}