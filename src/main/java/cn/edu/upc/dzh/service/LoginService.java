package cn.edu.upc.dzh.service;

import cn.edu.upc.manage.model.User;

public interface LoginService {
    public User selectByUsername(String userName);
    public void changePasswordByEmail(String newPassword,String email);
    public User selectByEmail(String email);
}
