package com.sdu.waiwaimarket.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("want")
public class WantDAO {
    @TableId(type = IdType.AUTO)
    Integer wantId;
    Integer userId;
    Integer goodsId;

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
}
