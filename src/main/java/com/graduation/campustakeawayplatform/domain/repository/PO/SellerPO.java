package com.graduation.campustakeawayplatform.domain.repository.PO;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import lombok.Data;

/**
 * 
 * @TableName seller
 */
@TableName(value ="seller")
@Data
public class SellerPO implements Serializable {
    /**
     * id
     */
    @TableId(value = "id")
    private String id;

    /**
     * 用户id
     */
    @TableField(value = "user_id")
    private String userId;

    /**
     * 店铺名称
     */
    @TableField(value = "shop_name")
    private String shopName;

    /**
     * 店铺类型，如小吃，粉
     */
    @TableField(value = "shop_type")
    private String shopType;

    /**
     * 认证状态
     */
    @TableField(value = "authentication_flag")
    private Integer authenticationFlag;

    /**
     * 营业执照
     */
    @TableField(value = "business_license")
    private String businessLicense;

    /**
     * 创建时间
     */
    @TableField(value = "create_date")
    private Date createDate;

    /**
     * 最后更新时间
     */
    @TableField(value = "last_update_date")
    private Date lastUpdateDate;

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
        SellerPO other = (SellerPO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getShopName() == null ? other.getShopName() == null : this.getShopName().equals(other.getShopName()))
            && (this.getShopType() == null ? other.getShopType() == null : this.getShopType().equals(other.getShopType()))
            && (this.getAuthenticationFlag() == null ? other.getAuthenticationFlag() == null : this.getAuthenticationFlag().equals(other.getAuthenticationFlag()))
            && (this.getBusinessLicense() == null ? other.getBusinessLicense() == null : this.getBusinessLicense().equals(other.getBusinessLicense()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getLastUpdateDate() == null ? other.getLastUpdateDate() == null : this.getLastUpdateDate().equals(other.getLastUpdateDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getShopName() == null) ? 0 : getShopName().hashCode());
        result = prime * result + ((getShopType() == null) ? 0 : getShopType().hashCode());
        result = prime * result + ((getAuthenticationFlag() == null) ? 0 : getAuthenticationFlag().hashCode());
        result = prime * result + ((getBusinessLicense() == null) ? 0 : getBusinessLicense().hashCode());
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
        sb.append(", userId=").append(userId);
        sb.append(", shopName=").append(shopName);
        sb.append(", shopType=").append(shopType);
        sb.append(", authenticationFlag=").append(authenticationFlag);
        sb.append(", businessLicense=").append(businessLicense);
        sb.append(", createDate=").append(createDate);
        sb.append(", lastUpdateDate=").append(lastUpdateDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}