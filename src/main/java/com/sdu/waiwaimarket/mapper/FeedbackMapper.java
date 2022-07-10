package com.sdu.waiwaimarket.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sdu.waiwaimarket.pojo.FeedbackDAO;
import com.sdu.waiwaimarket.pojo.GoodDAO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface FeedbackMapper extends BaseMapper<FeedbackDAO> {

    @Select(" select * from feedback where  like '%${userid}%' ")
    public IPage<FeedbackDAO> selectByPage(IPage<FeedbackDAO> userPage , @Param("userid")Integer userid);
}
