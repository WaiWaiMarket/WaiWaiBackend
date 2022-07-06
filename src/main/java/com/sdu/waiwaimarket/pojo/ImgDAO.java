package com.sdu.waiwaimarket.pojo;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName("img")
public class ImgDAO {
    Integer imgsid;
    Integer goodsid;
    String imgurl;

    public Integer getImgsid() {
        return imgsid;
    }

    public void setImgsid(Integer imgsid) {
        this.imgsid = imgsid;
    }

    public Integer getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Integer goodsid) {
        this.goodsid = goodsid;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }
}
