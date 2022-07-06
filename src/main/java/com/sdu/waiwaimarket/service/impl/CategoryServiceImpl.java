package com.sdu.waiwaimarket.service.impl;

import com.sdu.waiwaimarket.mapper.CategoryMapper;
import com.sdu.waiwaimarket.pojo.CategoryDAO;
import com.sdu.waiwaimarket.pojo.CategoryVO;
import com.sdu.waiwaimarket.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public List<CategoryVO> getAllCategory() {
        List<CategoryDAO> categoryDAOS = categoryMapper.selectList(null);
        List<CategoryVO> categoryVOS = new ArrayList<>();
        for(CategoryDAO categoryDAO:categoryDAOS){
            CategoryVO categoryVO = new CategoryVO();
            BeanUtils.copyProperties(categoryDAO, categoryVO);
            categoryVOS.add(categoryVO);
        }
        return categoryVOS;
    }
}
