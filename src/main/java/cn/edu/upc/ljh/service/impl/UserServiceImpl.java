package cn.edu.upc.ljh.service.impl;

import cn.edu.upc.ljh.dao.IUserDao;
import cn.edu.upc.ljh.model.User;
import cn.edu.upc.ljh.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserDao userDao;

    public User selectUser(long userId) {
        return userDao.selectUser(userId);
    }
}
