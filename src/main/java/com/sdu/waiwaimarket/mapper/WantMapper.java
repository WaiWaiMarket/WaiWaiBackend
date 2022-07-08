package com.sdu.waiwaimarket.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sdu.waiwaimarket.pojo.WantDAO;
import com.sdu.waiwaimarket.pojo.WantVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface WantMapper extends BaseMapper<WantDAO> {
    @Select("select want.wantid, goods.goodsid, goods.goodsname, goods.userid, goods.goodsprice, goods.goodsdesc," +
            " goods.goodslevel, goods.goodsdate, goods.goodsstatus FROM goods, want WHERE goods.userid=want.userid " +
            "and goods.goodsid=want.goodsid and want.userid='${userId}' ")
    public IPage<WantVO> wantSelectAll(Page<WantVO> page,  @Param("userId")Integer userId);
}
