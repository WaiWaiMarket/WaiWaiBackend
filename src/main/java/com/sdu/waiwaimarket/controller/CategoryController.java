package com.sdu.waiwaimarket.controller;

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

    @RequestMapping(value = "/category/all", method = {RequestMethod.GET})
    public ServerResult getAllCategory(){
        List<CategoryVO> categoryVOS = categoryService.getAllCategory();

        return new ServerResult(0, "成功获取全部商品类别！", categoryVOS);
    }
}
