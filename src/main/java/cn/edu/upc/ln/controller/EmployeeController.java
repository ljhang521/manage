package cn.edu.upc.ln.controller;

import cn.edu.upc.dzh.until.MD5Util;
import cn.edu.upc.ljh.service.UserService;
import cn.edu.upc.ln.service.EmployeeManageService;
import cn.edu.upc.manage.common.CommonReturnType;
import cn.edu.upc.manage.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Controller
@RequestMapping(value="/manage1",method = {RequestMethod.POST,RequestMethod.GET})
public class EmployeeController {
    @Autowired
    private EmployeeManageService employeeManageService;
    @Autowired
    private UserService userService;
    @RequestMapping("/getEmployee")
    @ResponseBody
    public CommonReturnType disEmployee(){
        List<EmployeeSelect> e1 = employeeManageService.selectAllEmployee();
        return CommonReturnType.create(e1);
    }
    @RequestMapping("/search")
    @ResponseBody
    public CommonReturnType searchEmployee(@RequestBody EmployeeSelectInput employeeSelectInput){
        List<EmployeeSelect> e2 = employeeManageService.selectEmployee(employeeSelectInput);
        return CommonReturnType.create(e2);
    }
    @RequestMapping("/deleteUser")
    @ResponseBody
    public CommonReturnType deleteUser(@RequestBody Test para)
    {
        User e3 = userService.selectUser(para.getId());
        e3.setDelFlag(1);
        userService.updateUser(e3);
        return CommonReturnType.create(null,null,0,"删除成功");
    }
    @RequestMapping("/updateUser")
    @ResponseBody
    public CommonReturnType updateUser(@RequestBody User user)
    {
        userService.updateUser(user);
        return CommonReturnType.create(null,null,0,"更新成功");
    }
    @RequestMapping("/changePassword")
    @ResponseBody
    public CommonReturnType changePassWord(@RequestBody ChangePassword para)
    {
        String password= MD5Util.md5(para.getPassword());
        employeeManageService.changePassWord(password,para.getId());
        return CommonReturnType.create(null,null,0,"修改成功");
    }


}
