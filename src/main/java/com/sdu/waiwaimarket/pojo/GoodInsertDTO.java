package com.sdu.waiwaimarket.pojo;

public class GoodInsertDTO {
    String goodsname;           //商品名字
    Integer userid;             //卖家id
    Integer goodsprice;         //商品价格
    String goodsdesc;           //商品描述
    Integer goodslevel;         //商品成色
    Integer categoryid;         //商品类型
    Integer goodsstatus;        //商品状态

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
