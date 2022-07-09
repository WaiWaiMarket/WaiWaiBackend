package com.sdu.waiwaimarket.pojo;

import java.util.Date;

public class WantVO {
    Integer wantid;
    Integer goodsid;
    String goodsname;
    Integer userid;
    String username;
    Integer goodsprice;
    String goodsdesc;
    String goodslevel;
    Date goodsdate;
    Integer goodsstatus;

    public Integer getWantid() {
        return wantid;
    }

    public void setWantid(Integer wantid) {
        this.wantid = wantid;
    }

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getGoodslevel() {
        return goodslevel;
    }

    public void setGoodslevel(String goodslevel) {
        this.goodslevel = goodslevel;
    }

    public Date getGoodsdate() {
        return goodsdate;
    }

    public void setGoodsdate(Date goodsdate) {
        this.goodsdate = goodsdate;
    }

    public Integer getGoodsstatus() {
        return goodsstatus;
    }

    public void setGoodsstatus(Integer goodsstatus) {
        this.goodsstatus = goodsstatus;
    }
}
