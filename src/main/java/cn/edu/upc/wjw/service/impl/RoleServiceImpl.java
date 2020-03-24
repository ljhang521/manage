package cn.edu.upc.wjw.service.impl;


import cn.edu.upc.manage.dao.RoleMapper;
import cn.edu.upc.manage.model.Role;
import cn.edu.upc.wjw.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("rolesServiceImpl")
public class RoleServiceImpl implements RoleService {
    @Resource
    public RoleMapper roleMapper;

    @Override
    public void insertRole(Role role) {
        role.setOperator("test");
        roleMapper.insertSelective(role);
    }

    @Override
    public List<Role> selectAllRole() {
        return roleMapper.selectAllRole();
    }





    @Resource
    private RoleMapper rolesDao;
    public Role selectRoles(Integer id) {
        return rolesDao.selectRoles(id);
    }



    @Override
    public void deleteRole(Role role){
        roleMapper.setdelFlag(role);
    }

    @Override
    public void updateRole(Role role) {
        roleMapper.updateByPrimaryKeySelective(role);
    }


}
