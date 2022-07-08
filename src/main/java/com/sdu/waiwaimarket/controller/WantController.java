package com.sdu.waiwaimarket.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sdu.waiwaimarket.pojo.ServerResult;
import com.sdu.waiwaimarket.pojo.WantDAO;
import com.sdu.waiwaimarket.pojo.WantInsertDTO;
import com.sdu.waiwaimarket.pojo.WantVO;
import com.sdu.waiwaimarket.service.WantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class WantController {

    @Autowired
    WantService wantService;

    @RequestMapping(value = "/want/insert",method = {RequestMethod.GET})
    public ServerResult wantInsert(WantInsertDTO wantInsertDTO){
        boolean isSuccess = wantService.wantInsert(wantInsertDTO);
        if(isSuccess){
            return new ServerResult(0,"成功添加到购物车",null);
        }
        else {
            return  new ServerResult(500,"添加失败",null);
        }
    }

    @RequestMapping(value = "/want/delete", method = {RequestMethod.GET})
    public  ServerResult wantDelete(Integer id){
        boolean isSuccess = wantService.wantDelete(id);
        if(isSuccess){
            return new ServerResult(0,"成功删除",null);
        }
        else {
            return new ServerResult(500,"删除失败",null);
        }
    }

    @RequestMapping(value = "/want/wantSelectById",method = {RequestMethod.POST})
    public  ServerResult wantSelectById(Integer id){
        List<WantVO> wantVOS = wantService.wantSelectById(id);
        return new ServerResult(0,"查询成功",wantVOS);
    }

    @RequestMapping(value = "/want/selectAllByPage",method = {RequestMethod.POST})
    public ServerResult wantSelectAllByPage(Integer pageNum, Integer pageSize, Integer userId){
        IPage<WantVO> wantVOIPage = wantService.wantSelectAll(pageNum, pageSize, userId);
        return new ServerResult(0,"查询成功",wantVOIPage);
    }

}
