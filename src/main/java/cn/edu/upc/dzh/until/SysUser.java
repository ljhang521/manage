package cn.edu.upc.dzh.until;

import cn.edu.upc.manage.model.User;
import org.apache.shiro.SecurityUtils;

public class SysUser {
    public static Integer getCurrentUserId(){
        System.out.println(SecurityUtils.getSubject().getPrincipal());
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        return user.getId();
    }
    public static Integer getCurrentUserRole(){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        return user.getRole();
    }
}
