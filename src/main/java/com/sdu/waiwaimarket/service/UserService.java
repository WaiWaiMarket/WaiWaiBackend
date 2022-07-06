package com.sdu.waiwaimarket.service;

import com.sdu.waiwaimarket.pojo.*;

public interface UserService {
    public boolean UserDataUpdate(UserDataUpdateDTO userDataUpdateDTO);
    public boolean UserGoodsStatus(UserGoodsStatusDTO userGoodsStatusDTO);
    public UserDataSelectVO UserDataSelect(UserDataSelectDTO userDataSelectDTO);
    public UserGoodsSelectVO UserGoodsSelect(UserGoodsSelectDTO userGoodsSelectDTO);
    public UserOrderSelectVO UserOrderSelect(UserOrderSelectDTO userOrderSelectDTO);
}
