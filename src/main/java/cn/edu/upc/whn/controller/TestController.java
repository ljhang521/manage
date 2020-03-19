package cn.edu.upc.whn.controller;

import cn.edu.upc.manage.common.CommonReturnType;
import cn.edu.upc.whn.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/test",method = RequestMethod.POST)
@CrossOrigin(allowCredentials = "true",allowedHeaders = "*")
public class TestController {
    @Autowired
    TestService testService;

    @RequestMapping("/getList")
    @ResponseBody
    public CommonReturnType getList(@RequestParam("id") Integer id){
        return CommonReturnType.create(testService.getMessageList(id));
    }
}
