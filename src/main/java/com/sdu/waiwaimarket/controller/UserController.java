package com.sdu.waiwaimarket.controller;

import com.sdu.waiwaimarket.pojo.*;
import com.sdu.waiwaimarket.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    UserService userService;


    //用户个人信息修改
    @RequestMapping("/user/UserDataUpdate")
    public ServerResult UserDataUpdate(UserDataUpdateDTO userDataUpdateDTO){
        boolean isSuccess = userService.UserDataUpdate(userDataUpdateDTO);
        if(isSuccess)
            return new ServerResult(0,"个人信息修改成功",null);
        return new ServerResult(500,"个人信息修改失败",null);
    }
    //用户商品状态修改
    @RequestMapping("/user/UserGoodsStatus")
    public ServerResult UserGoodsStatus(UserGoodsStatusDTO userGoodsStatusDTO){
        boolean isSuccess = userService.UserGoodsStatus(userGoodsStatusDTO);
        if(isSuccess)
            return new ServerResult(0,"修改商品状态成功",null);
        return new ServerResult(500,"修改商品状态失败",null);
    }
    //用户个人信息查询
    @RequestMapping("/user/UserDataSelect")
    public ServerResult UserDataSelect(UserDataSelectDTO userDataSelectDTO){
        UserDataSelectVO userDataSelectVO = userService.UserDataSelect(userDataSelectDTO);
        return new ServerResult(0,"查找用户个人信息成功",userDataSelectVO);
    }
    //查看某用户的商品信息(卖家查自己上架的商品)
    @RequestMapping("/user/UserGoodsSelect")
    public ServerResult UserGoodsSelect(UserGoodsSelectDTO userGoodsSelectDTO){
        UserGoodsSelectVO userGoodsSelectVO = userService.UserGoodsSelect(userGoodsSelectDTO);
        return new ServerResult(0,"查找商品信息成功",userGoodsSelectVO);
    }
    //查看某用户的订单信息
    @RequestMapping("/user/UserOrderSelect")
    public ServerResult UserOrderSelect(UserOrderSelectDTO userOrderSelectDTO){
        UserOrderSelectVO userOrderSelectVO = userService.UserOrderSelect(userOrderSelectDTO);
        return new ServerResult(0,"查看用户订单信息成功",userOrderSelectVO);
    }

}
