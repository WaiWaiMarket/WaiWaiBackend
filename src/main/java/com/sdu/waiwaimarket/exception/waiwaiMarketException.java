package com.sdu.waiwaimarket.exception;

import com.sdu.waiwaimarket.pojo.ServerResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice //调用每个controller时，自动调用类中的方法
public class waiwaiMarketException {

    @ExceptionHandler// 发生了异常，自动执行exceptionHandler
    public ServerResult exceptionHandler(Throwable e) {
        //得到异常信息
        String message = e.getMessage();
        //保存到数据库,通过网页显示异常，判断异常的等级
        e.printStackTrace();//把异常打印到控制台
        //返回错误信息给前端
        ServerResult serverResult = new ServerResult(500, "服务器出错,到控制台查看错误详细信息!", message);
        return serverResult;
    }
}
