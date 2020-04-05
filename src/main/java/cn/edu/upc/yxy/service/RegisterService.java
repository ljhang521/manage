package cn.edu.upc.yxy.service;

import cn.edu.upc.manage.model.User;
//import cn.edu.upc.yxy.manage.model.User;

public interface RegisterService {
    public void insertUser(User user);
    public User selectByUsername(String username);

}
