package com.sdu.waiwaimarket.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sdu.waiwaimarket.mapper.GoodMapper;
import com.sdu.waiwaimarket.mapper.OrderMapper;
import com.sdu.waiwaimarket.mapper.UserMapper;
import com.sdu.waiwaimarket.pojo.*;
import com.sdu.waiwaimarket.service.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    GoodMapper goodMapper;

    //更新订单
    @Override
    public boolean orderUpdate(OrderUpdateDTO orderUpdateDTO) {

        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("orderid",orderUpdateDTO.getOrderid());

        //新的数据放在dao中
        OrderDAO orderDAO = new OrderDAO();
        BeanUtils.copyProperties(orderUpdateDTO,orderDAO);

        int updateRow = orderMapper.update(orderDAO,queryWrapper);
        return updateRow>=1?true:false;

    }

    //新增订单
    @Override
    public boolean orderInsert(OrderInsertDTO orderInsertDTO) {
        OrderDAO orderDAO = new OrderDAO();
        BeanUtils.copyProperties(orderInsertDTO,orderDAO);
        int insertRow = orderMapper.insert(orderDAO);

        return insertRow>=1?true:false;

    }

    @Override
    public boolean orderDelete(Integer orderId) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("orderid",orderId);

        int deleteRow = orderMapper.delete(queryWrapper);
        return deleteRow>=1?true:false;
    }

//    @Override
//    public List<OrderVO> orderSelectByUserId(Integer userId) {
//        List<OrderDAO> daoList = orderMapper.selectList(null);
//
//        ArrayList<OrderVO> voList = new ArrayList<>();
//        for (OrderDAO orderDAO:daoList) {
//            QueryWrapper goodQueryWrapper = new QueryWrapper();
//            goodQueryWrapper.eq("goodsid",orderDAO.getOrderid());
//            QueryWrapper buyQueryWrapper = new QueryWrapper();
//            buyQueryWrapper.eq("userid",orderDAO.getOrderid());
//            QueryWrapper sellQueryWrapper = new QueryWrapper();
//            sellQueryWrapper.eq("userid",orderDAO.getOrderid());
//
//            GoodDAO goodDAO = goodMapper.selectOne(goodQueryWrapper);
//            UserDAO buyerDAO = userMapper.selectOne(buyQueryWrapper);
//            UserDAO sellerDAO=userMapper.selectOne(sellQueryWrapper);
//
//            OrderVO orderVO = new OrderVO();
//            orderVO.setBuyername(buyerDAO.getUsername());
//            orderVO.setSellername(sellerDAO.getUsername());
//            orderVO.setGoodname(goodDAO.getGoodsname());
//            orderVO.setGoodprice(goodDAO.getGoodsprice());
//            BeanUtils.copyProperties(orderDAO,orderVO);
//            voList.add(orderVO);
//        }
//        //3,返回voList
//        return voList;
//    }

    @Override
    public IPage<OrderVO> orderSelectByUserIdPage(Integer pageNum, Integer pageSize, Integer userId) {
        Page<OrderVO> page = new Page(pageNum , pageSize);
        IPage<OrderVO> productIPage = orderMapper.orderSelectByUserIdPage(page,userId);

        return productIPage;
    }

//    @Override
//    public List<OrderVO> orderSelectAll() {
//        List<OrderDAO> daoList = orderMapper.selectList(null);
//
//        ArrayList<OrderVO> voList = new ArrayList<>();
//        for (OrderDAO orderDAO:daoList) {
//            QueryWrapper goodQueryWrapper = new QueryWrapper();
//            goodQueryWrapper.eq("goodsid",orderDAO.getOrderid());
//            QueryWrapper buyQueryWrapper = new QueryWrapper();
//            buyQueryWrapper.eq("userid",orderDAO.getOrderid());
//            QueryWrapper sellQueryWrapper = new QueryWrapper();
//            sellQueryWrapper.eq("userid",orderDAO.getOrderid());
//
//            GoodDAO goodDAO = goodMapper.selectOne(goodQueryWrapper);
//            UserDAO buyerDAO = userMapper.selectOne(buyQueryWrapper);
//            UserDAO sellerDAO=userMapper.selectOne(sellQueryWrapper);
//
//            OrderVO orderVO = new OrderVO();
//            orderVO.setBuyername(buyerDAO.getUsername());
//            orderVO.setSellername(sellerDAO.getUsername());
//            orderVO.setGoodname(goodDAO.getGoodsname());
//            orderVO.setGoodprice(goodDAO.getGoodsprice());
//            BeanUtils.copyProperties(orderDAO,orderVO);
//            voList.add(orderVO);
//        }
//        //3,返回voList
//        return voList;
//    }

    @Override
    public IPage<OrderVO> orderSelectAllByPage(Integer pageNum, Integer pageSize) {
        Page<OrderVO> page = new Page(pageNum , pageSize);
        IPage<OrderVO> productIPage = orderMapper.orderSelectAllByPage(page);

        return productIPage;
    }
}
