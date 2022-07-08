package com.sdu.waiwaimarket.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sdu.waiwaimarket.pojo.WantInsertDTO;
import com.sdu.waiwaimarket.pojo.WantVO;

import java.util.List;

public interface WantService {
    public boolean wantInsert(WantInsertDTO wantInsertDTO);
    public boolean wantDelete(Integer id);
    public List<WantVO> wantSelectById(Integer id);
    public IPage<WantVO> wantSelectAll(Integer pageNum, Integer pageSize, Integer userId);
}
