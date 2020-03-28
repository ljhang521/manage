package cn.edu.upc.yxy.controller;

import cn.edu.upc.manage.common.CommonReturnType;
import cn.edu.upc.manage.model.User;
import cn.edu.upc.yxy.service.RegisterService;
import cn.edu.upc.yxy.utils.MD5Util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



@CrossOrigin
@Controller
@RequestMapping(value="/web")
public class RegisterController {
    @Autowired
    private RegisterService userService;

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public CommonReturnType register(@RequestBody User user){
        System.out.println(user.getUserName());
        User code = userService.selectByUserName(user);
        System.out.println(code.getUserName());

        if(code!=null){

            return CommonReturnType.create("用户名已注册");
        }
        else
            if(user.getPassword().equals(user.getPassword2())){
            user.setPassword(MD5Util.md5(user.getPassword()));
            userService.insertUser(user);
        }else{
            System.out.println("error");
        }

        return CommonReturnType.create(null);

    }




}

