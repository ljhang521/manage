package cn.edu.upc.ljh.service.impl;

import cn.edu.upc.ljh.service.UserService;
import cn.edu.upc.manage.dao.UserMapper;
import cn.edu.upc.manage.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userDao;

    public User selectUser(int userId) {
        return userDao.selectByPrimaryKey(userId);
    }
    public void updateUser(User user){
        userDao.updateByPrimaryKeySelective(user);
    }
}
