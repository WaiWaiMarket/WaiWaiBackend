package com.sdu.waiwaimarket.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sdu.waiwaimarket.pojo.GoodDAO;
import com.sdu.waiwaimarket.pojo.UserDAO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper extends BaseMapper<UserDAO> {

    @Select("select * from user")
    public IPage<UserDAO> userSelectByPage(IPage<UserDAO> userDAOIPage);


}
