package com.sdu.waiwaimarket.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sdu.waiwaimarket.mapper.ImgMapper;
import com.sdu.waiwaimarket.pojo.*;
import com.sdu.waiwaimarket.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class OrderController {
    @Autowired
    OrderService orderService;
    @RequestMapping(value = "/order/update",method = {RequestMethod.POST})
    public ServerResult orderUpdate(OrderUpdateDTO dto){
        boolean isSuccess = orderService.orderUpdate(dto);
        if (isSuccess){
            return new ServerResult(0,"订单修改成功！",null);
        }else{
            return new ServerResult(303,"订单修改失败",null);
        }
    }

    @RequestMapping(value = "/order/insert",method = {RequestMethod.POST})
    public ServerResult orderInsert(OrderInsertDTO dto){
        boolean isSuccess = orderService.orderInsert(dto);
        if (isSuccess){
            return new ServerResult(0,"订单添加成功！",null);
        }else{
            return new ServerResult(301,"订单添加失败！",null);
        }
    }

    @RequestMapping(value = "/order/delete",method = {RequestMethod.GET})
    public ServerResult orderDelete(Integer id){
        boolean isSuccess = orderService.orderDelete(id);
        if (isSuccess){
            return new ServerResult(0,"订单删除成功！",null);
        }else{
            return new ServerResult(302,"订单删除失败！",null);

        }
    }

    @RequestMapping(value = "/order/selectByUserId",method = {RequestMethod.GET})
    public ServerResult orderSelectByUserId(Integer userId){
        List<OrderVO> voList = orderService.orderSelectByUserId(userId);
        return new ServerResult(0,"根据用户编号查询订单成功！",voList);
    }

    @RequestMapping(value = "/order/select/userIdPage",method = {RequestMethod.GET})
    public ServerResult orderSelectByUserIdPage(Integer pageNum, Integer pageSize, Integer userId) {
        IPage<OrderVO> orderVOIPage = orderService.orderSelectByUserIdPage(pageNum,pageSize, userId);
        return new ServerResult(0,"返回分类分页内容成功！",orderVOIPage);
    }

    @RequestMapping(value = "/order/select/All",method = {RequestMethod.GET})
    public ServerResult orderSelectAll(){
        List<OrderVO> voList = orderService.orderSelectAll();
        return new ServerResult(0,"根据用户编号查询订单成功！",voList);
    }

    @RequestMapping(value = "/order/select/AllByPage",method = {RequestMethod.GET})
    public ServerResult orderSelectAllByPage(Integer pageNum, Integer pageSize) {
        IPage<OrderVO> orderVOIPage = orderService.orderSelectAllByPage(pageNum,pageSize);
        return new ServerResult(0,"返回分类分页内容成功！",orderVOIPage);
    }




}
