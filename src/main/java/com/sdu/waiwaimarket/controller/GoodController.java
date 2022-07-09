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
        Integer id = goodService.goodInsert(goodInsertDTO);
        if (id >= 0)
            return new ServerResult(0, "成功添加商品数据！",  id);
        return new ServerResult(500, "添加商品数据失败！", null);
    }

    //添加商品主图
    @RequestMapping(value = "/good/insertImg", method = {RequestMethod.POST})
    public ServerResult goodInsertImg(@RequestBody GoodInsertImgDTO goodInsertDTO){
        boolean isSuccess = goodService.goodInsertImg(goodInsertDTO);
        if (isSuccess)
            return new ServerResult(0, "成功添加商品主图！",  null);
        return new ServerResult(500, "添加商品主图失败！", null);
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
    public ServerResult goodDelete(Integer goodsid){
        boolean isSuccess = goodService.goodDelete(goodsid);
        if (isSuccess)
            return new ServerResult(0, "成功删除商品数据！",  null);
        return new ServerResult(500, "删除商品数据失败！", null);
    }

    //按类别搜索商品
    @RequestMapping(value = "/good/select/categoryid", method = {RequestMethod.GET})
    public ServerResult goodSelectByCategory(Integer categoryid){
        List<GoodVO> goodVOS = goodService.goodSelectByCategory(categoryid);

        return new ServerResult(0, "获取单个商品数据成功！", goodVOS);
    }

    //搜索特定商品
    @RequestMapping(value = "/good/select/goodsid", method = {RequestMethod.GET})
    public ServerResult goodSelectById(Integer goodsid){
        GoodVO goodVO = goodService.goodSelectById(goodsid);

        return new ServerResult(0, "获取单个商品数据成功！", goodVO);
    }

    //最新商品
    @RequestMapping(value = "/good/select/new", method = {RequestMethod.GET})
    public ServerResult goodSelectByNew(Integer num){
        List<GoodVO> goodVOS = goodService.goodSelectByNew(num);
        return new ServerResult(0, "获取最新商品数据成功！", goodVOS);
    }

    //低价好物
    @RequestMapping(value = "/good/select/price", method = {RequestMethod.GET})
    public ServerResult goodSelectByPrice(Integer num){
        List<GoodVO> goodVOS = goodService.goodSelectByPrice(num);
        return new ServerResult(0, "获取最新低价数据成功！", goodVOS);
    }

    //模糊查询
    @RequestMapping(value = "/good/select/name", method = {RequestMethod.GET})
    public ServerResult goodSelectByName(String goodsname){
        List<GoodVO> goodVOS = goodService.goodSelectByName(goodsname);
        return new ServerResult(0, "查找商品数据成功！", goodVOS);
    }

    //热门商品
    @RequestMapping(value = "/good/select/HOT", method = {RequestMethod.GET})
    public ServerResult goodSelectByHOT(Integer num){
        List<GoodVO> goodVOS = goodService.goodSelectByHOT(num);
        return new ServerResult(0, "查找热门商品数据成功！", goodVOS);
    }
    //改变商品状态
    @RequestMapping(value = "/good/setGoodStatus", method = {RequestMethod.GET})
    public ServerResult setGoodStatus(Integer goodid, Integer status){
        boolean isSuccess = goodService.goodUpdateStatus(goodid, status);
        if (isSuccess)
            return new ServerResult(0, "成功修改商品状态！",  null);
        return new ServerResult(500, "修改商品状态失败！", null);
    }

    //分页查询全部商品
    @RequestMapping(value = "/good/selectAllByPage",method = {RequestMethod.GET})
    public ServerResult goodSelectAllByPage(Integer pageNum, Integer pageSize, String search) {
        IPage<GoodDAO> goodDAOIPage = goodService.goodSelectAll(pageNum,pageSize,search);
        return new ServerResult(0,"返回分页内容成功",goodDAOIPage);
    }
    //分页查询全部商品
    @RequestMapping(value = "/good/selectAllByPage2",method = {RequestMethod.GET})
    public ServerResult goodSelectAllByPage2(Integer pageNum, Integer pageSize, String search) {
        IPage<GoodVO> goodDAOIPage = goodService.goodSelectAll2(pageNum,pageSize,search);
        return new ServerResult(0,"返回分页内容成功",goodDAOIPage);
    }
    //分页查询谋种类的全部的商品
    @RequestMapping(value = "/good/select/categoryPage",method = {RequestMethod.GET})
    public ServerResult goodSelectByCategoryPage(Integer pageNum, Integer pageSize, Integer id) {
        IPage<GoodVO> goodVOIPage = goodService.goodSelectByCategoryPage(pageNum, pageSize, id);
        return new ServerResult(0,"返回分类分页内容成功！",goodVOIPage);
    }
}
