package cn.edu.upc.ljh.controller;

import cn.edu.upc.manage.common.CommonReturnType;
import cn.edu.upc.manage.model.User;
import cn.edu.upc.ljh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@Controller
@RequestMapping(value="/user",method = {RequestMethod.POST,RequestMethod.GET})
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * gsl
     * 从user表获取管理者名单：manager
     * @date 2020/4/2
     * @return managerList
     */
    @RequestMapping("/manager")
    @ResponseBody
    public CommonReturnType getManagerList(){
        List<User> managerList = userService.selectManager();
        return CommonReturnType.create(managerList,"获取成功");
    }

    @RequestMapping("/json4")
    @ResponseBody
    public CommonReturnType jsonTest4(){
        User user = userService.selectUser(1);
        List l=new ArrayList();
        l.add(user);

        return CommonReturnType.create(l);
    }

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
