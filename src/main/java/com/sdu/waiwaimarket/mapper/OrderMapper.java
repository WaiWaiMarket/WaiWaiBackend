package com.sdu.waiwaimarket.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sdu.waiwaimarket.pojo.GoodVO;
import com.sdu.waiwaimarket.pojo.OrderDAO;
import com.sdu.waiwaimarket.pojo.OrderVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface OrderMapper extends BaseMapper<OrderDAO> {
    @Select("select o1.orderid,o1.buyid,o1.sellid,o1.goodsid,o1.orderstatus,o1.orderdate,u1.username as buyername,u2.username " +
            "as sellername,g1.goodsname,g1.goodsprice from orderinfo o1,user u1, user u2,goods g1 where o1.buyid=u1.userid and " +
            "o1.sellid=u2.userid and o1.goodsid=g1.goodsid and o1.buyid='${userId}'")
    public IPage<OrderVO> orderSelectByUserIdPage(IPage<OrderVO> userPage, @Param("userId")Integer userId);

    @Select("select o1.orderid,o1.buyid,o1.sellid,o1.goodsid,o1.orderstatus,o1.orderdate,u1.username as buyername,u2.username " +
            "as sellername,g1.goodsname,g1.goodsprice from orderinfo o1,user u1, user u2,goods g1 where o1.buyid=u1.userid and " +
            "o1.sellid=u2.userid and o1.goodsid=g1.goodsid")
    public IPage<OrderVO> orderSelectAllByPage(IPage<OrderVO> userPage);

    @Select("select * from orderinfo where buyid = #{buyid}")
    public IPage<OrderDAO> UserOrderSelect(IPage<OrderDAO> orderDAOIPage, @Param("buyid")Integer buyid);
}
