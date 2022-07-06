package com.sdu.waiwaimarket.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sdu.waiwaimarket.mapper.GoodMapper;
import com.sdu.waiwaimarket.mapper.OrderMapper;
import com.sdu.waiwaimarket.mapper.UserMapper;
import com.sdu.waiwaimarket.pojo.*;
import com.sdu.waiwaimarket.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    GoodMapper goodMapper;
    @Autowired
    OrderMapper orderMapper;

    //用户个人信息修改
    @Override
    public boolean UserDataUpdate(UserDataUpdateDTO userDataUpdateDTO) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("userid",userDataUpdateDTO.getUserid());
        //新数据放到DAO中
        UserDAO userDAO = new UserDAO();
        BeanUtils.copyProperties(userDataUpdateDTO,userDAO);

        int updateRow = userMapper.update(userDAO,queryWrapper);
        return updateRow>=1?true:false;
    }

    //用户商品状态修改
    @Override
    public boolean UserGoodsStatus(UserGoodsStatusDTO userGoodsStatusDTO) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("goodsid",userGoodsStatusDTO.getGoodsid());
        //新数据放到DAO中
        GoodDAO goodDAO = new GoodDAO();
        BeanUtils.copyProperties(userGoodsStatusDTO,goodDAO);

        int updateRow = goodMapper.update(goodDAO,queryWrapper);
        return updateRow>=1?true:false;
    }

    //用户个人信息查询
    @Override
    public UserDataSelectVO UserDataSelect(UserDataSelectDTO userDataSelectDTO) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("userid",userDataSelectDTO.getUserid());

        UserDAO userDAO = userMapper.selectOne(queryWrapper);
        UserDataSelectVO userDataSelectVO = new UserDataSelectVO();
        BeanUtils.copyProperties(userDAO,userDataSelectVO);
        return userDataSelectVO;
    }

    //查看某用户的商品信息(卖家查自己上架的商品)
    @Override
    public UserGoodsSelectVO UserGoodsSelect(UserGoodsSelectDTO userGoodsSelectDTO) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("goodsid",userGoodsSelectDTO.getGoodsid());

        GoodDAO goodDAO = goodMapper.selectOne(queryWrapper);
        UserGoodsSelectVO userGoodsSelectVO = new UserGoodsSelectVO();
        BeanUtils.copyProperties(goodDAO,userGoodsSelectVO);
        return userGoodsSelectVO;

    }
    //查看某用户的订单信息
    @Override
    public UserOrderSelectVO UserOrderSelect(UserOrderSelectDTO userOrderSelectDTO) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("orderid",userOrderSelectDTO.getOrderid());

        OrderDAO orderDAO = orderMapper.selectOne(queryWrapper);
        UserOrderSelectVO userOrderSelectVO = new UserOrderSelectVO();
        BeanUtils.copyProperties(orderDAO,userOrderSelectVO);
        return userOrderSelectVO;


    }
}
