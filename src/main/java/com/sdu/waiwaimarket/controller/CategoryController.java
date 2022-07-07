package com.sdu.waiwaimarket.controller;

import com.sdu.waiwaimarket.pojo.CategoryDTO;
import com.sdu.waiwaimarket.pojo.CategoryVO;
import com.sdu.waiwaimarket.pojo.GoodVO;
import com.sdu.waiwaimarket.pojo.ServerResult;
import com.sdu.waiwaimarket.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    //获取所有分类
    @RequestMapping(value = "/category/all", method = {RequestMethod.GET})
    public ServerResult getAllCategory(){
        List<CategoryVO> categoryVOS = categoryService.getAllCategory();

        return new ServerResult(0, "成功获取全部商品类别！", categoryVOS);
    }

    //添加分类
    @RequestMapping(value = "/category/insert", method = {RequestMethod.POST})
    public ServerResult insertCategory(CategoryDTO categoryDTO){
        boolean isSuccess = categoryService.insertCategory(categoryDTO);
        if(isSuccess)
            return new ServerResult(0, "成功添加商品类别！", null);

        return new ServerResult(500, "添加商品类别失败！", null);
    }

    //修改分类
    @RequestMapping(value = "/category/update", method = {RequestMethod.POST})
    public ServerResult updateCategory(CategoryDTO categoryDTO){
        boolean isSuccess = categoryService.updateCategory(categoryDTO);
        if(isSuccess)
            return new ServerResult(0, "修改添加商品类别！", null);

        return new ServerResult(500, "修改商品类别失败！", null);
    }

    //删除分类
    @RequestMapping(value = "/category/delete", method = {RequestMethod.GET})
    public ServerResult deleteCategory(Integer id){
        boolean isSuccess = categoryService.deleteCategory(id);
        if(isSuccess)
            return new ServerResult(0, "修改删除商品类别！", null);

        return new ServerResult(500, "删除商品类别失败！", null);
    }
}
