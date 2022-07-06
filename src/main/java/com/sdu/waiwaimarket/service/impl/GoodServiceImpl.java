package com.sdu.waiwaimarket.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sdu.waiwaimarket.mapper.CategoryMapper;
import com.sdu.waiwaimarket.mapper.GoodMapper;
import com.sdu.waiwaimarket.mapper.UserMapper;
import com.sdu.waiwaimarket.pojo.*;
import com.sdu.waiwaimarket.service.GoodService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoodServiceImpl implements GoodService {
    @Autowired
    GoodMapper goodMapper;
    @Autowired
    CategoryMapper categoryMapper;
    @Autowired
    UserMapper userMapper;

    //添加商品
    @Override
    public boolean goodInsert(GoodInsertDTO goodInsertDTO) {
        GoodDAO goodDAO = new GoodDAO();
        BeanUtils.copyProperties(goodInsertDTO, goodDAO);
        Integer num = goodMapper.insert(goodDAO);

        return num >= 1 ? true : false;
    }

    //修改商品
    @Override
    public boolean goodUpdate(GoodUpdateDTO goodUpdateDTO) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("goodsid", goodUpdateDTO.getGoodsid());

        GoodDAO goodDAO = new GoodDAO();
        BeanUtils.copyProperties(goodUpdateDTO, goodDAO);

        Integer num = goodMapper.update(goodDAO, queryWrapper);

        return num >= 1 ? true : false;
    }


    //删除商品
    @Override
    public boolean goodDelete(Integer id) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("goodsid", id);
        Integer num = goodMapper.delete(queryWrapper);

        return num >= 1 ? true : false;
    }

    @Override
    public List<GoodVO> goodSelectByCategory(Integer id) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("categoryid", id);

        List<GoodDAO> goodDAOS = goodMapper.selectList(queryWrapper);
        List<GoodVO> goodVOS = new ArrayList<>();

        for(GoodDAO goodDAO:goodDAOS){
            //查找分类名称
            QueryWrapper queryWrapper2 = new QueryWrapper();
            queryWrapper2.eq("categoryid", goodDAO.getCategoryid());
            CategoryDAO categoryDAO = categoryMapper.selectOne(queryWrapper2);

            //查找卖家姓名
            QueryWrapper queryWrapper3 = new QueryWrapper();
            queryWrapper3.eq("userid", goodDAO.getUserid());
            UserDAO userDAO = userMapper.selectOne(queryWrapper3);

            GoodVO goodVO = new GoodVO();
            BeanUtils.copyProperties(goodDAO, goodVO);
            goodVO.setCategoryname(categoryDAO.getCategoryname());
            goodVO.setUsername(userDAO.getUsername());
            goodVOS.add(goodVO);
        }

        return goodVOS;
    }

    //按商品号搜索商品
    @Override
    public GoodVO goodSelectById(Integer id) {
        //查找商品
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("goodsid", id);
        GoodDAO goodDAO = goodMapper.selectOne(queryWrapper);

        //查找商品分类名称
        QueryWrapper queryWrapper2 = new QueryWrapper();
        queryWrapper2.eq("categoryid", goodDAO.getCategoryid());
        CategoryDAO categoryDAO = categoryMapper.selectOne(queryWrapper2);

        //查找卖家姓名
        QueryWrapper queryWrapper3 = new QueryWrapper();
        queryWrapper3.eq("userid", goodDAO.getUserid());
        UserDAO userDAO = userMapper.selectOne(queryWrapper3);

        //设置GoodVO
        GoodVO goodVO = new GoodVO();
        BeanUtils.copyProperties(goodDAO, goodVO);
        goodVO.setCategoryname(categoryDAO.getCategoryname());
        goodVO.setUsername(userDAO.getUsername());

        return goodVO;
    }

    @Override
    public List<GoodVO> goodSelectByNew(Integer num) {
        //查找相应商品
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.orderByDesc("goodsdate");
        List<GoodDAO> goodDAOS = goodMapper.selectList(queryWrapper);
        List<GoodVO> goodVOS = new ArrayList<>();
        //判断需求数量是否大于数据库数据量
        if(num > goodDAOS.size())
            num = goodDAOS.size();
        goodDAOS = goodDAOS.subList(0, num);

        for(GoodDAO goodDAO:goodDAOS){
            //查找分类名称
            QueryWrapper queryWrapper2 = new QueryWrapper();
            queryWrapper2.eq("categoryid", goodDAO.getCategoryid());
            CategoryDAO categoryDAO = categoryMapper.selectOne(queryWrapper2);

            //查找卖家姓名
            QueryWrapper queryWrapper3 = new QueryWrapper();
            queryWrapper3.eq("userid", goodDAO.getUserid());
            UserDAO userDAO = userMapper.selectOne(queryWrapper3);

            GoodVO goodVO = new GoodVO();
            BeanUtils.copyProperties(goodDAO, goodVO);
            goodVO.setCategoryname(categoryDAO.getCategoryname());
            goodVO.setUsername(userDAO.getUsername());
            goodVOS.add(goodVO);
        }

        return goodVOS;
    }

    //模糊查询
    @Override
    public List<GoodVO> goodSelectByName(String name) {
        List<GoodDAO> goodDAOS = goodMapper.goodSelectByName(name);
        List<GoodVO> goodVOS  = new ArrayList<>();

        for(GoodDAO goodDAO:goodDAOS){
            //查找分类名称
            QueryWrapper queryWrapper2 = new QueryWrapper();
            queryWrapper2.eq("categoryid", goodDAO.getCategoryid());
            CategoryDAO categoryDAO = categoryMapper.selectOne(queryWrapper2);

            //查找卖家姓名
            QueryWrapper queryWrapper3 = new QueryWrapper();
            queryWrapper3.eq("userid", goodDAO.getUserid());
            UserDAO userDAO = userMapper.selectOne(queryWrapper3);

            GoodVO goodVO = new GoodVO();
            BeanUtils.copyProperties(goodDAO, goodVO);
            goodVO.setCategoryname(categoryDAO.getCategoryname());
            goodVO.setUsername(userDAO.getUsername());
            goodVOS.add(goodVO);
        }

        return goodVOS;
    }
}
