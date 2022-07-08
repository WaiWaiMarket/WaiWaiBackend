package com.sdu.waiwaimarket.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sdu.waiwaimarket.pojo.*;

import java.util.List;

public interface OrderService {
    public boolean orderUpdate(OrderUpdateDTO orderUpdateDTO);
    public boolean orderInsert(OrderInsertDTO orderInsertDTO);
    public boolean orderDelete(Integer orderId);
    public List<OrderVO> orderSelectByUserId(Integer userId);
    public IPage<OrderVO> orderSelectByUserIdPage(Integer pageNum, Integer pageSize, Integer userId);
    public List<OrderVO> orderSelectAll();
    public IPage<OrderVO> orderSelectAllByPage(Integer pageNum, Integer pageSize);
}
