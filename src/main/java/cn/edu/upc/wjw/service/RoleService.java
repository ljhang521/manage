package cn.edu.upc.wjw.service;


import cn.edu.upc.manage.model.Role;

import java.util.List;

public interface RoleService {
    void insertRole(Role role);

    //    public void insertRole(Role role);

    List<Role> selectAllRole();
    public void deleteRole(Role role);
    public void updateRole(Role role);
}
