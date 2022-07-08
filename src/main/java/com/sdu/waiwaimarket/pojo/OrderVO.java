package com.sdu.waiwaimarket.pojo;

import java.util.Date;

public class OrderVO {
    Integer orderid; //订单编号
    Integer buyid; //买家id
    Integer sellid; //卖家id
    Integer goodsid; //商品id
    Integer orderstatus; //订单状态
    Date orderdate; //订单日期
    String buyername; //买家姓名
    String sellername; //卖家姓名
    String goodsname; //商品名称
    Integer goodsprice; //商品价格

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

    public String getBuyername() {
        return buyername;
    }

    public void setBuyername(String buyername) {
        this.buyername = buyername;
    }

    public String getSellername() {
        return sellername;
    }

    public void setSellername(String sellername) {
        this.sellername = sellername;
    }

    public String getGoodname() {
        return goodsname;
    }

    public void setGoodname(String goodname) {
        this.goodsname = goodname;
    }

    public Integer getGoodprice() {
        return goodsprice;
    }

    public void setGoodprice(Integer goodprice) {
        this.goodsprice = goodprice;
    }
}
