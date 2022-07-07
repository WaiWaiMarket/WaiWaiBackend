package com.sdu.waiwaimarket.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sdu.waiwaimarket.mapper.GoodMapper;
import com.sdu.waiwaimarket.mapper.OrderMapper;
import com.sdu.waiwaimarket.mapper.UserMapper;
import com.sdu.waiwaimarket.pojo.*;
import com.sdu.waiwaimarket.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    GoodMapper goodMapper;
    @Autowired
    OrderMapper orderMapper;


    @Override
    public Integer UserRegister(UserRegisterDTO userRegisterDTO) {

        //1.判断用户名是否存在，若存在则不能用
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("username",userRegisterDTO.getUsername());

        UserDAO userDAO = userMapper.selectOne(queryWrapper);
        if(userDAO == null){ //说明用户名不存在，可以使用
            //2.把用户名和密码保存到数据库
            UserDAO insertUserDAO = new UserDAO();//userDAO是专门操作数据库的类
            //insertUserDAO.setName(userDTO.getName());//参数为函数的参数DTO
            //insertUserDAO.setPassword(userDTO.getPassword());
            BeanUtils.copyProperties(userRegisterDTO,insertUserDAO);
            int insertRow = userMapper.insert(insertUserDAO);//最后对数据库实际操作，离不开Mapper的调用
            if(insertRow==0){//判断操作的行数，>0成功，==0失败
                throw new RuntimeException("注册,保存数据失败");
            }else {
                //3.查询用户的编号
                //select * from user where name = '' and password = ''
                QueryWrapper selectQueryWrapper = new QueryWrapper();
                selectQueryWrapper.eq("username",userRegisterDTO.getUsername());
                selectQueryWrapper.eq("userpwd",userRegisterDTO.getUserpwd());

                UserDAO selectUserDAO = userMapper.selectOne(selectQueryWrapper);
                return selectUserDAO.getUserid();
            }

        }
        throw new RuntimeException("用户名已经存在");
    }

    //用户登录
    @Override
    public int UserLogin(Integer userid, String userpwd) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("userid",userid);

        UserDAO userDAO = userMapper.selectOne(queryWrapper);
        if(userDAO.getUserpwd().equals(userpwd))
            return userid;
        return -1;
    }

    //用户个人信息修改
    @Override
    public boolean UserDataUpdate(UserDataUpdateDTO userDataUpdateDTO) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("userid",userDataUpdateDTO.getUserid());
        //新数据放到DAO中
        UserDAO userDAO = new UserDAO();
        BeanUtils.copyProperties(userDataUpdateDTO,userDAO);

        int updateRow = userMapper.update(userDAO,queryWrapper);
        return updateRow>=1?true:false;
    }

    //用户商品状态修改
    @Override
    public boolean UserGoodsStatus(UserGoodsStatusDTO userGoodsStatusDTO) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("goodsid",userGoodsStatusDTO.getGoodsid());
        //新数据放到DAO中
        GoodDAO goodDAO = new GoodDAO();
        BeanUtils.copyProperties(userGoodsStatusDTO,goodDAO);

        int updateRow = goodMapper.update(goodDAO,queryWrapper);
        return updateRow>=1?true:false;
    }

    //用户个人信息查询
    @Override
    public UserDataSelectVO UserDataSelect(UserDataSelectDTO userDataSelectDTO) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("userid",userDataSelectDTO.getUserid());

        UserDAO userDAO = userMapper.selectOne(queryWrapper);
        UserDataSelectVO userDataSelectVO = new UserDataSelectVO();
        BeanUtils.copyProperties(userDAO,userDataSelectVO);
        return userDataSelectVO;
    }

    //查看某用户的商品信息(卖家查自己上架的商品)
    @Override
    public UserGoodsSelectVO UserGoodsSelect(UserGoodsSelectDTO userGoodsSelectDTO) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("goodsid",userGoodsSelectDTO.getGoodsid());

        GoodDAO goodDAO = goodMapper.selectOne(queryWrapper);
        UserGoodsSelectVO userGoodsSelectVO = new UserGoodsSelectVO();
        BeanUtils.copyProperties(goodDAO,userGoodsSelectVO);
        return userGoodsSelectVO;

    }
    //查看某用户的订单信息
    @Override
    public UserOrderSelectVO UserOrderSelect(UserOrderSelectDTO userOrderSelectDTO) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("orderid",userOrderSelectDTO.getOrderid());

        OrderDAO orderDAO = orderMapper.selectOne(queryWrapper);
        UserOrderSelectVO userOrderSelectVO = new UserOrderSelectVO();
        BeanUtils.copyProperties(orderDAO,userOrderSelectVO);
        return userOrderSelectVO;


    }
}
