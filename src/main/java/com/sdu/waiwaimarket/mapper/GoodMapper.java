package com.sdu.waiwaimarket.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sdu.waiwaimarket.pojo.GoodDAO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GoodMapper extends BaseMapper<GoodDAO> {
    @Select(" select * from goods where goodsname like '%${name}%' ")
    public List<GoodDAO> goodSelectByName(String name);
}
