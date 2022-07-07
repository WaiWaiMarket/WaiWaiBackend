package com.sdu.waiwaimarket.controller;

import com.sdu.waiwaimarket.pojo.AdminDTO;
import com.sdu.waiwaimarket.pojo.ServerResult;
import com.sdu.waiwaimarket.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
public class AdminController {

    @Autowired
    AdminService adminService;

    @RequestMapping("/admin/login")
    // http://localhost:9003/admin/login?adminname=a&adminpwd=a
    public ServerResult login(AdminDTO adminDTO){
        Integer id = adminService.login(adminDTO);
        if(id >= 1){
            return new ServerResult(0, "登录成功", id);
        }
        else {
            ServerResult serverResult = new ServerResult(101, "登录失败", null);
            return serverResult;
        }
    }

    @GetMapping("/admin/selectById")
    public ServerResult adminSelectById(String adminid){
        String ret = adminService.SelectById(Integer.valueOf(adminid));
        return new ServerResult(0, "获取信息成功", ret);
    }

}
