package com.sdu.waiwaimarket.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sdu.waiwaimarket.pojo.GoodDAO;
import com.sdu.waiwaimarket.pojo.GoodVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GoodMapper extends BaseMapper<GoodDAO> {
    @Select(" select * from goods where goodsname like '%${name}%' ")
    public List<GoodDAO> goodSelectByName(String name);

    @Select("select goods.goodsname, goods.userid, user.username, goods.goodsprice, goods.goodsdesc," +
            " goods.goodsimg, goods.goodslevel, category.categoryid, category.categoryname, goods.goodsstatus " +
            "FROM goods, category, user WHERE goods.userid=user.userid" +
            " and goods.categoryid=category.categoryid and goods.goodsstatus!=1 and " +
            "goods.categoryid='${id}' ")
    public IPage<GoodVO> goodSelectByCategoryPage(IPage<GoodVO> userPage, @Param("id")Integer id);



    @Select(" select * from goods where goodsname like '%${name}%' ")
    public IPage<GoodDAO> selectByPage(IPage<GoodDAO> userPage ,@Param("name")String name);


    @Select("select goods.goodsname, goods.userid, user.username, goods.goodsprice, goods.goodsdesc," +
            " goods.goodsimg, goods.goodslevel, category.categoryid, category.categoryname, goods.goodsstatus " +
            "FROM goods, category, user WHERE goods.userid=user.userid" +
            " and goods.categoryid=category.categoryid and goods.goodsstatus!=1 and " +
            "goods.goodsname like '%${name}%' ")
    public IPage<GoodVO> selectByPage2(IPage<GoodVO> userPage ,@Param("name")String name);
}
