package com.sdu.waiwaimarket.service;

import com.sdu.waiwaimarket.pojo.AdminDTO;

public interface AdminService {
    public Integer login(AdminDTO adminDTO);
    public String SelectById(Integer adminid);
}
