package cn.edu.upc.ljh.dao;

import cn.edu.upc.ljh.model.User;
import org.apache.ibatis.annotations.Param;

public interface IUserDao {
    User selectUser(long id);
}
