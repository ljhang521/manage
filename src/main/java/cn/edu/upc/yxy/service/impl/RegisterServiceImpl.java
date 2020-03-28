package cn.edu.upc.yxy.service.impl;

import cn.edu.upc.manage.dao.UserMapper;
import cn.edu.upc.manage.model.User;
import cn.edu.upc.yxy.service.RegisterService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("registerService")
public class RegisterServiceImpl implements RegisterService {
    @Resource
    private UserMapper userMapper;
    @Override
    public void insertUser(User user) {
        userMapper.insertSelective(user);
    }
    @Transactional
    @Override
    public void changePasswordByEmail(String newPassword, String email){
        userMapper.changePasswordByEmail(newPassword,email);
    }

    @Override
    public User selectByEmail(String email){
        return userMapper.selectByEmail(email);
    }
    @Override
    public User selectByUserName(User user){
        return userMapper.selectByUserName(user);
    }
}
