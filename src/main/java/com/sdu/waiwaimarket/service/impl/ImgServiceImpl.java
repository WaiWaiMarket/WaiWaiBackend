package com.sdu.waiwaimarket.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sdu.waiwaimarket.mapper.ImgMapper;
import com.sdu.waiwaimarket.pojo.CategoryDAO;
import com.sdu.waiwaimarket.pojo.CategoryVO;
import com.sdu.waiwaimarket.pojo.ImgDAO;
import com.sdu.waiwaimarket.pojo.ImgVO;
import com.sdu.waiwaimarket.service.ImgService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImgServiceImpl implements ImgService {
    @Autowired
    ImgMapper imgMapper;

    @Override
    public List<ImgVO> getAllImg(Integer id) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("goodsid", id);
        List<ImgDAO> imgDAOS = imgMapper.selectList(queryWrapper);
        List<ImgVO> imgVOS = new ArrayList<>();
        for(ImgDAO imgDAO:imgDAOS){
            ImgVO imgVO = new ImgVO();
            BeanUtils.copyProperties(imgDAO, imgVO);
            imgVOS.add(imgVO);
        }
        return imgVOS;
    }

    @Override
    public ImgVO getImg(Integer id) {

        ImgDAO imgDAO = imgMapper.selectById(id);
        ImgVO imgVO = new ImgVO();
        BeanUtils.copyProperties(imgDAO, imgVO);

        return imgVO;
    }

    @Override
    public boolean insertImg(ImgDAO imgDAO) {
        Integer num = imgMapper.insert(imgDAO);
        return num >= 1 ? true : false;
    }

    @Override
    public boolean deleteImg(Integer id) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("imgid", id);

        Integer num = imgMapper.delete(queryWrapper);

        return num >= 1 ? true : false;
    }
}
