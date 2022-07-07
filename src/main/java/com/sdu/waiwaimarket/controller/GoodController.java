package com.sdu.waiwaimarket.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sdu.waiwaimarket.pojo.*;
import com.sdu.waiwaimarket.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
public class GoodController {
    @Autowired
    GoodService goodService;

    //添加商品
    @RequestMapping(value = "/good/insert", method = {RequestMethod.POST})
    public ServerResult goodInsert(@RequestBody GoodInsertDTO goodInsertDTO){
        boolean isSuccess = goodService.goodInsert(goodInsertDTO);
        if (isSuccess)
            return new ServerResult(0, "成功添加商品数据！",  null);
        return new ServerResult(500, "添加商品数据失败！", null);
    }

    //修改商品
    @RequestMapping(value = "/good/update", method = {RequestMethod.POST})
    public ServerResult goodUpdate(@RequestBody GoodUpdateDTO goodUpdateDTO){
        boolean isSuccess = goodService.goodUpdate(goodUpdateDTO);
        if (isSuccess)
            return new ServerResult(0, "成功修改商品数据！",  null);
        return new ServerResult(500, "修改商品数据失败！", null);
    }

    //删除商品
    @RequestMapping(value = "/good/delete")
    public ServerResult goodDelete(Integer id){
        boolean isSuccess = goodService.goodDelete(id);
        if (isSuccess)
            return new ServerResult(0, "成功删除商品数据！",  null);
        return new ServerResult(500, "删除商品数据失败！", null);
    }

    //按类别搜索商品
    @RequestMapping(value = "/good/select/categoryid", method = {RequestMethod.GET})
    public ServerResult goodSelectByCategory(Integer id){
        List<GoodVO> goodVOS = goodService.goodSelectByCategory(id);

        return new ServerResult(0, "获取单个商品数据成功！", goodVOS);
    }

    //搜索特定商品
    @RequestMapping(value = "/good/select/goodsid", method = {RequestMethod.GET})
    public ServerResult goodSelectById(Integer id){
        GoodVO goodVO = goodService.goodSelectById(id);

        return new ServerResult(0, "获取单个商品数据成功！", goodVO);
    }

    //最新商品
    @RequestMapping(value = "/good/select/new", method = {RequestMethod.GET})
    public ServerResult goodSelectByNew(Integer num){
        List<GoodVO> goodVOS = goodService.goodSelectByNew(num);
        return new ServerResult(0, "获取最新商品数据成功！", goodVOS);
    }

    //模糊查询
    @RequestMapping(value = "/good/select/name", method = {RequestMethod.GET})
    public ServerResult goodSelectByName(String name){
        List<GoodVO> goodVOS = goodService.goodSelectByName(name);
        return new ServerResult(0, "查找商品数据成功！", goodVOS);
    }

    @RequestMapping(value = "/good/selectAllByPage",method = {RequestMethod.GET})
    public ServerResult goodSelectAllByPage(Integer pageNum, Integer pageSize, String search) {
        IPage<GoodDAO> goodDAOIPage = goodService.goodSelectAll(pageNum,pageSize,search);
        return new ServerResult(0,"返回分页内容成功",goodDAOIPage);
    }
}
