package com.sdu.waiwaimarket.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sdu.waiwaimarket.pojo.*;

public interface UserService {
    public boolean UserpwdUpdate(UserpwdUpdateDTO userpwdUpdateDTO);
    public IPage<UserDAO> UserSelectAll(Integer pageNum, Integer pageSize);
    public boolean UserCreateBack(UserCreateBackDTO userCreateBackDTO);
    public Integer UserRegister(UserRegisterDTO userRegisterDTO);
    public int UserLogin(String userName,String userpwd);
    public boolean UserDataUpdate(UserDataUpdateDTO userDataUpdateDTO);
    public boolean UserGoodsStatus(UserGoodsStatusDTO userGoodsStatusDTO);
    public UserDataSelectVO UserDataSelect(UserDataSelectDTO userDataSelectDTO);
    public IPage<GoodDAO> UserGoodsSelect(Integer pageNum, Integer pageSize,Integer userid);
    public IPage<OrderDAO> UserOrderSelect(Integer pageNum, Integer pageSize,Integer userid);
}
