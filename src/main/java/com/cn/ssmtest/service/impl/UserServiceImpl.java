package com.cn.ssmtest.service.impl;

import com.cn.ssmtest.dao.IUserDao;
import com.cn.ssmtest.domain.User;
import com.cn.ssmtest.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by 闪闪 on 2017/1/4.
 */
@Service("userService")
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserDao userDao;

    public User getUserById(int userId) {
        return this.userDao.selectByPrimaryKey(userId);
    }
}
