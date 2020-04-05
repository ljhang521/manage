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

    @Override
    public User selectByUsername(String username) {
        return userMapper.selectByUsername(username);
    }


}
