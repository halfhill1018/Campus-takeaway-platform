package com.graduation.campustakeawayplatform.domain.repository.PO;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 
 * @TableName order_main
 */
@TableName(value ="order_main")
@Data
public class OrderMainPO implements Serializable {
    /**
     * 订单id
     */
    @TableId(value = "id")
    private String id;

    /**
     * 订单号
     */
    @TableField(value = "order_number")
    private String orderNumber;

    /**
     * 买家id
     */
    @TableField(value = "buyer_id")
    private String buyerId;

    /**
     * 卖家id
     */
    @TableField(value = "seller_id")
    private String sellerId;

    /**
     * 订单状态
     */
    @TableField(value = "order_status")
    private String orderStatus;

    /**
     * 订单类型
     */
    @TableField(value = "order_type")
    private String orderType;

    /**
     * 订单快照id
     */
    @TableField(value = "order_snapshot_id")
    private String orderSnapshotId;

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
        OrderMainPO other = (OrderMainPO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOrderNumber() == null ? other.getOrderNumber() == null : this.getOrderNumber().equals(other.getOrderNumber()))
            && (this.getBuyerId() == null ? other.getBuyerId() == null : this.getBuyerId().equals(other.getBuyerId()))
            && (this.getSellerId() == null ? other.getSellerId() == null : this.getSellerId().equals(other.getSellerId()))
            && (this.getOrderStatus() == null ? other.getOrderStatus() == null : this.getOrderStatus().equals(other.getOrderStatus()))
            && (this.getOrderType() == null ? other.getOrderType() == null : this.getOrderType().equals(other.getOrderType()))
            && (this.getOrderSnapshotId() == null ? other.getOrderSnapshotId() == null : this.getOrderSnapshotId().equals(other.getOrderSnapshotId()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getLastUpdateDate() == null ? other.getLastUpdateDate() == null : this.getLastUpdateDate().equals(other.getLastUpdateDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOrderNumber() == null) ? 0 : getOrderNumber().hashCode());
        result = prime * result + ((getBuyerId() == null) ? 0 : getBuyerId().hashCode());
        result = prime * result + ((getSellerId() == null) ? 0 : getSellerId().hashCode());
        result = prime * result + ((getOrderStatus() == null) ? 0 : getOrderStatus().hashCode());
        result = prime * result + ((getOrderType() == null) ? 0 : getOrderType().hashCode());
        result = prime * result + ((getOrderSnapshotId() == null) ? 0 : getOrderSnapshotId().hashCode());
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
        sb.append(", orderNumber=").append(orderNumber);
        sb.append(", buyerId=").append(buyerId);
        sb.append(", sellerId=").append(sellerId);
        sb.append(", orderStatus=").append(orderStatus);
        sb.append(", orderType=").append(orderType);
        sb.append(", orderSnapshotId=").append(orderSnapshotId);
        sb.append(", createDate=").append(createDate);
        sb.append(", lastUpdateDate=").append(lastUpdateDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}