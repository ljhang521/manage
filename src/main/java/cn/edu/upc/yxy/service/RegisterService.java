package cn.edu.upc.yxy.service;

import cn.edu.upc.manage.model.User;
//import cn.edu.upc.yxy.manage.model.User;

public interface RegisterService {
    public void insertUser(User user);
    public void changePasswordByEmail(String newPassword, String email);
    public User selectByEmail(String email);

    User selectByUserName(User user);
}
