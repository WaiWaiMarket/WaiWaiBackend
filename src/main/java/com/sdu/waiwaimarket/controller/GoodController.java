package com.sdu.waiwaimarket.controller;

import com.sdu.waiwaimarket.pojo.GoodInsertDTO;
import com.sdu.waiwaimarket.pojo.GoodUpdateDTO;
import com.sdu.waiwaimarket.pojo.GoodVO;
import com.sdu.waiwaimarket.pojo.ServerResult;
import com.sdu.waiwaimarket.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@CrossOrigin
public class GoodController {
    @Autowired
    GoodService goodService;

    //添加商品
    @RequestMapping(value = "/good/insert", method = {RequestMethod.POST})
    public ServerResult goodInsert(GoodInsertDTO goodInsertDTO){
        boolean isSuccess = goodService.goodInsert(goodInsertDTO);
        if (isSuccess)
            return new ServerResult(0, "成功添加商品数据！",  null);
        return new ServerResult(500, "添加商品数据失败！", null);
    }

    //修改商品
    @RequestMapping(value = "/good/update", method = {RequestMethod.POST})
    public ServerResult goodUpdate(GoodUpdateDTO goodUpdateDTO){
        boolean isSuccess = goodService.goodUpdate(goodUpdateDTO);
        if (isSuccess)
            return new ServerResult(0, "成功修改商品数据！",  null);
        return new ServerResult(500, "修改商品数据失败！", null);
    }

    //删除商品
    @RequestMapping(value = "/good/delete", method = {RequestMethod.GET})
    public ServerResult goodDelete(Integer id){
        boolean isSuccess = goodService.goodDelete(id);
        if (isSuccess)
            return new ServerResult(0, "成功删除商品数据！",  null);
        return new ServerResult(500, "删除商品数据失败！", null);
    }

    @RequestMapping(value = "/good/select/categoryid", method = {RequestMethod.GET})
    public ServerResult goodSelectByCategory(Integer id){
        List<GoodVO> goodVOS = goodService.goodSelectByCategory(id);

        return new ServerResult(0, "获取单个商品数据成功！", goodVOS);
    }


    @RequestMapping(value = "/good/select/goodsid", method = {RequestMethod.GET})
    public ServerResult goodSelectById(Integer id){
        GoodVO goodVO = goodService.goodSelectById(id);

        return new ServerResult(0, "获取单个商品数据成功！", goodVO);
    }

    @RequestMapping(value = "/good/select/new", method = {RequestMethod.GET})
    public ServerResult goodSelectByNew(Integer num){
        List<GoodVO> goodVOS = goodService.goodSelectByNew(num);
        return new ServerResult(0, "获取最新商品数据成功！", goodVOS);
    }

    @RequestMapping(value = "/good/select/name", method = {RequestMethod.GET})
    public ServerResult goodSelectByName(String name){
        List<GoodVO> goodVOS = goodService.goodSelectByName(name);
        return new ServerResult(0, "查找商品数据成功！", goodVOS);
    }
}
