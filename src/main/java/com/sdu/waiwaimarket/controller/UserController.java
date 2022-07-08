package com.sdu.waiwaimarket.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
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

    //查询所有用户
    @RequestMapping("/user/UserSelectByPage")
    public ServerResult userSelectByPage(Integer pageNum, Integer pageSize){
        IPage<UserDAO> userDAOIPage = userService.UserSelectAll(pageNum,pageSize);
        return new ServerResult(0,"返回分页内容成功",userDAOIPage);
    }

    //用户根据订单生成反馈
    @RequestMapping("/user/UserCreateBack")
    public ServerResult UserCreateBack(UserCreateBackDTO userCreateBackDTO){
        boolean isSuccess = userService.UserCreateBack(userCreateBackDTO);
        if(isSuccess)
            return new ServerResult(0,"生成成功",null);
        return new ServerResult(0,"生成失败",null);
    }

    //用户注册
    @RequestMapping("/user/UserRegister")
    public ServerResult UserRegister(UserRegisterDTO userRegisterDTO){
        Integer id = userService.UserRegister(userRegisterDTO);
        return new ServerResult(0,"注册成功",id);
    }

    //用户登录
    @RequestMapping("/user/UserLogin")
    public ServerResult UserLogin(String username, String userpwd){
        int id = userService.UserLogin(username, userpwd);
        if(id>0)
            return new ServerResult(0,"登录成功",id);
        return new ServerResult(101,"登录失败",-1);

    }
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
