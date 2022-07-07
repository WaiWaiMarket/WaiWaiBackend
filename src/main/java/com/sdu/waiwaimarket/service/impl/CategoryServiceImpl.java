package com.sdu.waiwaimarket.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sdu.waiwaimarket.mapper.CategoryMapper;
import com.sdu.waiwaimarket.pojo.CategoryDAO;
import com.sdu.waiwaimarket.pojo.CategoryDTO;
import com.sdu.waiwaimarket.pojo.CategoryVO;
import com.sdu.waiwaimarket.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.font.TrueTypeFont;

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

    @Override
    public boolean insertCategory(CategoryDTO categoryDTO) {
        CategoryDAO categoryDAO = new CategoryDAO();
        BeanUtils.copyProperties(categoryDTO, categoryDAO);
        Integer num = categoryMapper.insert(categoryDAO);

        return num >= 1 ? true : false;
    }

    @Override
    public boolean updateCategory(CategoryDTO categoryDTO) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("categoryid", categoryDTO.getCategoryid());

        CategoryDAO categoryDAO = new CategoryDAO();
        BeanUtils.copyProperties(categoryDTO, categoryDAO);

        Integer num = categoryMapper.update(categoryDAO, queryWrapper);

        return num >= 1 ? true : false;
    }

    @Override
    public boolean deleteCategory(Integer id) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("categoryid", id);

        Integer num = categoryMapper.delete(queryWrapper);

        return num >= 1 ? true : false;
    }
}
