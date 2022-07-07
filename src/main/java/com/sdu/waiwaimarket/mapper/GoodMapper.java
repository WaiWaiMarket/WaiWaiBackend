package com.sdu.waiwaimarket.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sdu.waiwaimarket.pojo.GoodDAO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GoodMapper extends BaseMapper<GoodDAO> {
    @Select(" select * from goods where goodsname like '%${name}%' ")
    public List<GoodDAO> goodSelectByName(String name);
    @Select(" select * from goods where goodsname like '%${name}%' ")
    public IPage<GoodDAO> selectByPage(IPage<GoodDAO> userPage ,@Param("name")String name);
}
