package com.sdu.waiwaimarket.service;

import com.sdu.waiwaimarket.pojo.GoodInsertDTO;
import com.sdu.waiwaimarket.pojo.GoodUpdateDTO;
import com.sdu.waiwaimarket.pojo.GoodVO;

import java.util.List;

public interface GoodService {
    public boolean goodInsert(GoodInsertDTO goodInsertDTO);
    public boolean goodUpdate(GoodUpdateDTO goodUpdateDTO);
    public boolean goodDelete(Integer id);
    public List<GoodVO> goodSelectByCategory(Integer id);
    public GoodVO goodSelectById(Integer id);
    public List<GoodVO> goodSelectByNew(Integer num);
    public List<GoodVO> goodSelectByName(String name);
}
