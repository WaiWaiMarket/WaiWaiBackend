package com.sdu.waiwaimarket.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

@TableName("orderinfo")
public class OrderDAO {
    @TableId(type = IdType.AUTO)
    Integer orderid; //订单编号
    Integer buyid; //买家id
    Integer sellid; //卖家id
    Integer goodsid; //商品id
    Integer orderstatus; //订单状态
    Date orderdate; //订单日期

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public Integer getBuyid() {
        return buyid;
    }

    public void setBuyid(Integer buyid) {
        this.buyid = buyid;
    }

    public Integer getSellid() {
        return sellid;
    }

    public void setSellid(Integer sellid) {
        this.sellid = sellid;
    }

    public Integer getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Integer goodsid) {
        this.goodsid = goodsid;
    }

    public Integer getOrderstatus() {
        return orderstatus;
    }

    public void setOrderstatus(Integer orderstatus) {
        this.orderstatus = orderstatus;
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }
}
