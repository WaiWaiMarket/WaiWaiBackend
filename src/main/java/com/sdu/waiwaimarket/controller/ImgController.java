package com.sdu.waiwaimarket.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sdu.waiwaimarket.mapper.ImgMapper;
import com.sdu.waiwaimarket.pojo.CategoryVO;
import com.sdu.waiwaimarket.pojo.ImgDAO;
import com.sdu.waiwaimarket.pojo.ImgVO;
import com.sdu.waiwaimarket.pojo.ServerResult;
import com.sdu.waiwaimarket.service.CategoryService;
import com.sdu.waiwaimarket.service.ImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
public class ImgController {
    @Autowired
    ImgService imgService;

    //获取某个商品全部图片
    @RequestMapping(value = "/img/all", method = {RequestMethod.GET})
    public ServerResult getAllImg(Integer id){
        List<ImgVO> imgVOS = imgService.getAllImg(id);

        return new ServerResult(0, "获取全部商品图片成功！", imgVOS);
    }

    //根据图片id获取图片
    @RequestMapping(value = "/img/one", method = {RequestMethod.GET})
    public ServerResult getImg(Integer id){
        ImgVO imgVO = imgService.getImg(id);

        return new ServerResult(0, "获取图片成功！", imgVO);
    }

    @Value("${SavePath.ProfilePhoto}")
    private String ProfilePhotoSavePath;   //图标图片存储路径
    @Value("${SavePath.ProfilePhotoMapper}")
    private String ProfilePhotoMapperPath;   //图标映射路径

    //上传图片
    @PostMapping("/img/upload")
    public ServerResult imgUpload(@RequestParam("file") MultipartFile fileUpload, Integer id){
        ImgDAO imgDAO = new ImgDAO();
        imgDAO.setGoodsid(id);
        //获取文件名
        String fileName = fileUpload.getOriginalFilename();
        //获取文件后缀名。也可以在这里添加判断语句，规定特定格式的图片才能上传，否则拒绝保存。
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        //为了避免发生图片替换，这里使用了文件名重新生成
        fileName = UUID.randomUUID()+suffixName;

        String property = System.getProperty("user.dir");
        String ProfilePhotoSavePath = property + "\\upload\\";
        System.out.println(ProfilePhotoSavePath);
        try {
            //将图片保存到文件夹里
            fileUpload.transferTo(new File(ProfilePhotoSavePath+fileName));
            //返回imgDAO
            imgDAO.setImgurl(fileName);
            //插入到Img表
            boolean isSuccess = imgService.insertImg(imgDAO);
            if(isSuccess)
                return new ServerResult(0, "创建图片成功！", imgDAO);
        } catch (Exception e) {
            e.printStackTrace();
            return new ServerResult(500, "创建图片失败", e.getMessage());
        }
        return new ServerResult(500, "创建图片失败", null);
    }

    @PostMapping("/img/delete")
    public ServerResult imgDelete(Integer id){
        boolean isSuccess = imgService.deleteImg(id);

        if (isSuccess)
            return new ServerResult(0, "成功删除商品图片！",  null);
        return new ServerResult(500, "删除商品图片失败！", null);
    }


}
