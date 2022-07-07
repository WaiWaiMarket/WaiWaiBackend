package com.sdu.waiwaimarket.service;


import com.sdu.waiwaimarket.pojo.CategoryDTO;
import com.sdu.waiwaimarket.pojo.CategoryVO;

import java.util.List;


public interface CategoryService {
    public List<CategoryVO> getAllCategory();
    public boolean insertCategory(CategoryDTO categoryDTO);
    public boolean updateCategory(CategoryDTO categoryDTO);
    public boolean deleteCategory(Integer id);
}
