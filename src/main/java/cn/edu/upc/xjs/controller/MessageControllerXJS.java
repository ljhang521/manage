package cn.edu.upc.xjs.controller;

import cn.edu.upc.manage.common.CommonReturnType;
import cn.edu.upc.manage.model.Message;
import cn.edu.upc.xjs.Service.MessageServiceXJS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Controller
@RequestMapping(value="/message",method = {RequestMethod.POST,RequestMethod.GET})

public class MessageControllerXJS {
    @Autowired
    private MessageServiceXJS messageServiceXJS;
    @RequestMapping("/insertNewMessage")
    @ResponseBody
    public CommonReturnType insertNewMsg (@RequestBody Message message){
        messageServiceXJS.insertMessage(message);
        return CommonReturnType.create(null);
    }
}
