package cn.edu.upc.ljh.service.impl;

import cn.edu.upc.ljh.dao.UserMapper;
import cn.edu.upc.ljh.model.User;
import cn.edu.upc.ljh.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userDao;

    public User selectUser(int userId) {
        return userDao.selectByPrimaryKey(userId);
    }
}
