package com.sdu.waiwaimarket.pojo;

public class CategoryVO {
    Integer categoryid;         //商品类别
    String categoryname;        //类别名称

    public Integer getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Integer categoryid) {
        this.categoryid = categoryid;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }
}
