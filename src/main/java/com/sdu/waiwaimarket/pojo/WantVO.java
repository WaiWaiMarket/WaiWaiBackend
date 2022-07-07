package com.sdu.waiwaimarket.pojo;

public class WantVO {
    Integer wantId;//我想要编号
    Integer userId;//用户编号
    Integer goodsId;//商品编号
    String goodsname;//商品名字
    Integer goodsprice;//商品价格
    String goodsimg;//图片地址
    Integer goodsstatus;//商品状态

    public Integer getWantId() {
        return wantId;
    }

    public void setWantId(Integer wantId) {
        this.wantId = wantId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public Integer getGoodsprice() {
        return goodsprice;
    }

    public void setGoodsprice(Integer goodsprice) {
        this.goodsprice = goodsprice;
    }

    public String getGoodsimg() {
        return goodsimg;
    }

    public void setGoodsimg(String goodsimg) {
        this.goodsimg = goodsimg;
    }

    public Integer getGoodsstatus() {
        return goodsstatus;
    }

    public void setGoodsstatus(Integer goodsstatus) {
        this.goodsstatus = goodsstatus;
    }
}
