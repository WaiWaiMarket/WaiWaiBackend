package com.sdu.waiwaimarket.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sdu.waiwaimarket.mapper.GoodMapper;
import com.sdu.waiwaimarket.mapper.WantMapper;
import com.sdu.waiwaimarket.pojo.WantDAO;
import com.sdu.waiwaimarket.pojo.WantInsertDTO;
import com.sdu.waiwaimarket.pojo.WantVO;
import com.sdu.waiwaimarket.service.WantService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sdu.waiwaimarket.service.GoodService;

import java.util.ArrayList;
import java.util.List;

@Service
public class WantServiceImpl implements WantService {

    @Autowired
    WantMapper wantMapper;
    @Autowired
    GoodMapper goodMapper;
    @Autowired
    GoodService goodService;

    @Override
    public boolean wantInsert(WantInsertDTO wantInsertDTO) {
        WantDAO wantDAO = new WantDAO();
        BeanUtils.copyProperties(wantInsertDTO,wantDAO);
        int insertRow = wantMapper.insert(wantDAO);

        return insertRow>=1;
    }

    @Override
    public boolean wantDelete(Integer id) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("wantid",id);
        int deleteRow = wantMapper.delete(queryWrapper);

        return deleteRow>=1;
    }

    @Override
    public List<WantVO> wantSelectById(Integer id) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("userid",id);
        List<WantDAO> daoList = wantMapper.selectList(queryWrapper);
        List<WantVO> wantVOS = new ArrayList<>();
        for(WantDAO wantDAO:daoList){
            WantVO wantVO = new WantVO();
            int goodId=wantDAO.getGoodsid();
            BeanUtils.copyProperties(goodService.goodSelectById(goodId),wantVO);
            wantVO.setUserid(wantDAO.getUserid());

            wantVOS.add(wantVO);
        }
        return wantVOS;
    }

    @Override
    public IPage<WantVO> wantSelectAll(Integer pageNum, Integer pageSize, Integer userId) {
        Page<WantVO> page = new Page(pageNum, pageSize);
        IPage<WantVO> productIPage = wantMapper.wantSelectAll(page, userId);

        return productIPage;
    }
}
