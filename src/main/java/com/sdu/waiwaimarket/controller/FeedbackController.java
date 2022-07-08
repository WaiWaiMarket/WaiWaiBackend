package com.sdu.waiwaimarket.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sdu.waiwaimarket.pojo.*;
import com.sdu.waiwaimarket.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class FeedbackController {

    @Autowired
    FeedbackService feedbackService;

    @RequestMapping(value = "/feedback/insert", method = {RequestMethod.POST})
    public ServerResult feedbackInsert(@RequestBody FeedbackInsertDTO feedbackInsertDTO){
        boolean isSuccess = feedbackService.feedbackInsert(feedbackInsertDTO);
        if (isSuccess){
            return new ServerResult(0,"成功添加用户反馈",null);
        }
        else{
            return  new ServerResult(500,"添加失败",null);
        }
    }

    @RequestMapping(value = "/feedback/delete")
    public ServerResult feedbackDelete(Integer id){
        boolean isSuccess = feedbackService.feedbackDelete(id);
        if (isSuccess){
            return new ServerResult(0,"成功删除用户反馈",null);
        }
        else{
            return  new ServerResult(500,"删除失败",null);
        }
    }

    @RequestMapping(value = "/feedback/feedbackSelectByuserId",method = {RequestMethod.POST})
    public  ServerResult feedbackSelectByuserId(Integer id){
        List<FeedbackVO> feedbackVOS = feedbackService.feedbackSelectByuserId(id);
        return new ServerResult(0,"查询成功",feedbackVOS);
    }

    @RequestMapping(value = "/feedback/feedbackSelectByorderId",method = {RequestMethod.POST})
    public ServerResult feedbackSelectByorderId(Integer id){
        FeedbackVO feedbackVO = feedbackService.feedbackSelectByorderId(id);
        return new ServerResult(0,"查询成功",feedbackVO);
    }

}
