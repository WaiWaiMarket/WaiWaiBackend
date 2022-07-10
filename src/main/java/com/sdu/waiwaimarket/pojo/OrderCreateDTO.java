package com.sdu.waiwaimarket.pojo;

public class OrderCreateDTO {
    Integer buyid; //卖家id
    Integer goodsid; //商品id

    public Integer getBuyid() {
        return buyid;
    }

    public void setBuyid(Integer buyid) {
        this.buyid = buyid;
    }

    public Integer getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Integer goodsid) {
        this.goodsid = goodsid;
    }
}
