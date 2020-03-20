package cn.edu.upc.zy.controller;

import cn.edu.upc.manage.common.CommonReturnType;
import cn.edu.upc.whn.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/test9",method = RequestMethod.POST)
@CrossOrigin(allowCredentials = "true",allowedHeaders = "*")
public class TestControllerZY {
    @Autowired
    TestService testService;
    @RequestMapping("/getList")
    @ResponseBody
    public CommonReturnType getList(@RequestParam("id") Integer id){
        return CommonReturnType.create(testService.getMessageList(id));
    }
    @RequestMapping("/updateReader")
    @ResponseBody
    public CommonReturnType updateReader(@RequestParam("id") int id,@RequestParam("uid") int uid){
        testService.updateReader(id,uid);
        return CommonReturnType.create(null);
    }

}
