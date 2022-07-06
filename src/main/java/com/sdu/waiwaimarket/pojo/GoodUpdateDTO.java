package com.sdu.waiwaimarket.pojo;

public class GoodUpdateDTO {
    Integer goodsid;            //商品id
    String goodsname;           //商品名字
    Integer userid;             //卖家id
    Integer goodsprice;         //商品价格
    String goodsdesc;           //商品描述
    String goodsimg;            //商品图片
    Integer goodslevel;         //商品成色
    Integer categoryid;         //商品类型
    Integer goodsstatus;        //商品状态

    public Integer getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Integer goodsid) {
        this.goodsid = goodsid;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getGoodsprice() {
        return goodsprice;
    }

    public void setGoodsprice(Integer goodsprice) {
        this.goodsprice = goodsprice;
    }

    public String getGoodsdesc() {
        return goodsdesc;
    }

    public void setGoodsdesc(String goodsdesc) {
        this.goodsdesc = goodsdesc;
    }

    public String getGoodsimg() {
        return goodsimg;
    }

    public void setGoodsimg(String goodsimg) {
        this.goodsimg = goodsimg;
    }

    public Integer getGoodslevel() {
        return goodslevel;
    }

    public void setGoodslevel(Integer goodslevel) {
        this.goodslevel = goodslevel;
    }

    public Integer getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Integer categoryid) {
        this.categoryid = categoryid;
    }

    public Integer getGoodsstatus() {
        return goodsstatus;
    }

    public void setGoodsstatus(Integer goodsstatus) {
        this.goodsstatus = goodsstatus;
    }
}
