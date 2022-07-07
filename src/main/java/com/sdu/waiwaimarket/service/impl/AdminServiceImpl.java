package com.sdu.waiwaimarket.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sdu.waiwaimarket.mapper.AdminMapper;
import com.sdu.waiwaimarket.pojo.AdminDAO;
import com.sdu.waiwaimarket.pojo.AdminDTO;
import com.sdu.waiwaimarket.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminMapper adminMapper;

    @Override
    public Integer login(AdminDTO adminDTO) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("adminname",adminDTO.getAdminname());
        queryWrapper.eq("adminpwd",adminDTO.getAdminpwd());

        AdminDAO adminDAO = adminMapper.selectOne(queryWrapper);
        // 判断登录是否成功
        if(adminDAO != null ) {
            return adminDAO.getAdminid();
        } else {
            return -1;
        }
    }

    @Override
    public String SelectById(Integer adminid) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("adminid",adminid);

        AdminDAO adminDAO = adminMapper.selectOne(queryWrapper);
        // 判断登录是否成功
        if(adminDAO != null ) {
            return adminDAO.getAdminname();
        } else {
            return "NULL";
        }
    }
}
