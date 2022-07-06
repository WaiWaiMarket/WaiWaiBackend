package com.sdu.waiwaimarket.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sdu.waiwaimarket.pojo.UserDAO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<UserDAO> {
}
