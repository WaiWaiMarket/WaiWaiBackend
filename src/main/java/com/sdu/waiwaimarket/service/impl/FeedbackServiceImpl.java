package com.sdu.waiwaimarket.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sdu.waiwaimarket.mapper.FeedbackMapper;
import com.sdu.waiwaimarket.pojo.*;
import com.sdu.waiwaimarket.service.FeedbackService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    FeedbackMapper feedbackMapper;

    @Override
    public boolean feedbackInsert(FeedbackInsertDTO feedbackInsertDTO) {
        FeedbackDAO feedbackDAO = new FeedbackDAO();
        BeanUtils.copyProperties(feedbackInsertDTO,feedbackDAO);
        int insertRow = feedbackMapper.insert(feedbackDAO);

        return insertRow>=1;
    }

    @Override
    public boolean feedbackDelete(Integer feedbackid){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("feedbackid",feedbackid);
        int deleteRow = feedbackMapper.delete(queryWrapper);

        return deleteRow>=1;
    }

    @Override
    public List<FeedbackVO> feedbackSelectByuserId(Integer userid) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("userid",userid);
        List<FeedbackDAO> daoList = feedbackMapper.selectList(queryWrapper);
        List<FeedbackVO> feedbackVOS = new ArrayList<>();

        for(FeedbackDAO feedbackDAO:daoList){
            FeedbackVO feedbackVO = new FeedbackVO();
            BeanUtils.copyProperties(feedbackDAO,feedbackVO);
            feedbackVOS.add(feedbackVO);
        }
        return feedbackVOS;
    }

    @Override
    public FeedbackVO feedbackSelectByorderId(Integer orderid) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("orderid",orderid);
        FeedbackDAO feedbackDAO = feedbackMapper.selectOne(queryWrapper);
        FeedbackVO feedbackVO = new FeedbackVO();
        BeanUtils.copyProperties(feedbackDAO,feedbackVO);
        return feedbackVO;
    }


}
