package cn.edu.upc.ljh.controller;

import cn.edu.upc.ljh.common.CommonReturnType;
import cn.edu.upc.ljh.model.User;
import cn.edu.upc.ljh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@Controller
@RequestMapping(value="/project",method = {RequestMethod.POST,RequestMethod.GET})
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("/json")
    @ResponseBody
    public CommonReturnType jsonTest(){
         User user = userService.selectUser(1);
         List l=new ArrayList();
        l.add(user);

        return CommonReturnType.create(l);
    }
    @RequestMapping("/json1")
    @ResponseBody
    public CommonReturnType stringTest(@RequestBody User webUser,HttpServletRequest request){

        request.getSession().setAttribute("user",webUser);
        User user = userService.selectUser(1);
        List l=new ArrayList();
        l.add(user);
        l.add(request.getSession().getAttribute("user"));
        return CommonReturnType.create(l);

    }
    @RequestMapping("/json2")
    @ResponseBody
    public CommonReturnType intTest(@RequestBody int i){
        User user = userService.selectUser(1);
        List l=new ArrayList();
        l.add(user);
        l.add(user);
        return CommonReturnType.create(l);

    }
}
