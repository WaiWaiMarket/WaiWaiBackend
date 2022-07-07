package com.sdu.waiwaimarket.service;

import com.sdu.waiwaimarket.pojo.ImgDAO;
import com.sdu.waiwaimarket.pojo.ImgVO;

import java.util.List;

public interface ImgService {
    public List<ImgVO> getAllImg(Integer id);
    public ImgVO getImg(Integer id);
    public boolean insertImg(ImgDAO imgDAO);
    public boolean deleteImg(Integer id);
}
