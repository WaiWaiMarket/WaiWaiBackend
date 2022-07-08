package com.sdu.waiwaimarket.service;

import com.sdu.waiwaimarket.pojo.AdminDTO;
import com.sdu.waiwaimarket.pojo.FeedbackDAO;
import com.sdu.waiwaimarket.pojo.FeedbackInsertDTO;
import com.sdu.waiwaimarket.pojo.FeedbackVO;

import java.util.List;

public interface FeedbackService {

    public boolean feedbackInsert(FeedbackInsertDTO feedbackInsertDTO);
    public boolean feedbackDelete(Integer feedbackid);
    public List<FeedbackVO> feedbackSelectByuserId(Integer userid);
    public FeedbackVO feedbackSelectByorderId(Integer orderid);
}
