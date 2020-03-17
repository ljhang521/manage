package cn.edu.upc.ljh.service;

import cn.edu.upc.ljh.model.User;

public interface UserService {

    public User selectUser(int userId);
    public List<User> selectUsersByKey(String username);
}
