package cn.edu.upc.wjw.controller;

import cn.edu.upc.manage.common.CommonReturnType;

import cn.edu.upc.manage.model.Role;
import cn.edu.upc.wjw.service.impl.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin//解决跨域问题
@Controller
@RequestMapping(value="/manage",method = {RequestMethod.POST,RequestMethod.GET})
public class RoleController {
    @Autowired(required = false)
    @Qualifier("rolesServiceImpl")
    private RoleServiceImpl roleService;

    @RequestMapping("/Role")
    @ResponseBody
    public CommonReturnType selectAllRole() {
        List<Role> r= roleService.selectAllRole();
        return CommonReturnType.create(r);
    }
    @RequestMapping("/insertRole")
    @ResponseBody
    public CommonReturnType insertNewRight(@RequestBody Role role){
        roleService.insertRole(role);

//        Role rolee = roleService.selectRoles(null);
////        List l2 = new ArrayList();
////        l2.add(rolee);
        return CommonReturnType.create(null);
    }

    @RequestMapping("/deleteRole")
    @ResponseBody
    public CommonReturnType deleteRole(@RequestBody Role role){
        roleService.deleteRole(role);
        return CommonReturnType.create(null);
    }

    @RequestMapping("/updateRole")
    @ResponseBody
    public CommonReturnType updateRole(@RequestBody Role role){
        roleService.updateRole(role);
        return CommonReturnType.create(null);
    }
}
