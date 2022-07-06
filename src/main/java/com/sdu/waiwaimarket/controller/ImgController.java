package com.sdu.waiwaimarket.controller;

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

    @RequestMapping(value = "/img/all", method = {RequestMethod.GET})
    public ServerResult getAllImg(Integer id){
        List<ImgVO> imgVOS = imgService.getAllImg(id);

        return new ServerResult(0, "获取全部商品图片成功！", imgVOS);
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
        String ProfilePhotoSavePath = property + "\\src\\main\\resources\\static\\";
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

//    @GetMapping("/deleteProductImage")
//    @ResponseBody
//    public ServerResponse delFile(Integer id,String realUrl) {
//        //字符串截断，获取图片的名称
//        int lastIndexOf = realUrl.lastIndexOf("/");
//        String img_path = realUrl.substring(lastIndexOf + 1, realUrl.length());
//        //拼接图片的绝对地址
//        img_path = "D:\\Project\\manager-api\\src\\main\\resources\\static\\images\\" + img_path;
//
//        File file = new File(img_path);
//        //数据库中删除数据
//        int i = sProductService.deleteProductImage(id);
//        if(i>0){
//            if (file.exists()) {//文件是否存在
//                if (file.delete()) {//存在就删了
//                    return ServerResponse.createServerResponseBySuccess("删除成功");
//                } else {
//                    return ServerResponse.createServerResponseBySuccess("文件删除失败");
//                }
//            }else {
//                return ServerResponse.createServerResponseByFail("文件不存在");
//            }
//        }else {
//            return ServerResponse.createServerResponseByFail("数据删除失败");
//        }
//    }

}
