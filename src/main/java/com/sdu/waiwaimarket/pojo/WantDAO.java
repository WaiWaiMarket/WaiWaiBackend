package com.sdu.waiwaimarket.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("want")
public class WantDAO {
    @TableId(type = IdType.AUTO)
    Integer wantid;
    Integer userid;
    Integer goodsid;

    public Integer getWantid() {
        return wantid;
    }

    public void setWantid(Integer wantid) {
        this.wantid = wantid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Integer goodsid) {
        this.goodsid = goodsid;
    }
}
