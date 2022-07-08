package com.sdu.waiwaimarket.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sdu.waiwaimarket.pojo.*;

import java.util.List;

public interface FeedbackService {

    public boolean feedbackInsert(FeedbackInsertDTO feedbackInsertDTO);
    public boolean feedbackDelete(Integer feedbackid);
    public List<FeedbackVO> feedbackSelectByuserId(Integer userid);
    public FeedbackVO feedbackSelectByorderId(Integer orderid);
    public IPage<FeedbackDAO> feedbackSelectAll(Integer pageNum, Integer pageSize, Integer userid);
}
