package com.sdu.waiwaimarket.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sdu.waiwaimarket.pojo.GoodDAO;
import com.sdu.waiwaimarket.pojo.OrderDAO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface OrderMapper extends BaseMapper<OrderDAO> {

    @Select("select * from orderinfo where buyid = #{buyid}")
    public IPage<OrderDAO> UserOrderSelect(IPage<OrderDAO> orderDAOIPage, @Param("buyid")Integer buyid);
}
