package cn.edu.upc.zy.controller;

import cn.edu.upc.whn.service.TestService;
import cn.edu.upc.zy.service.MessageService;
import cn.edu.upc.manage.common.CommonReturnType;
import cn.edu.upc.manage.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Controller
@RequestMapping(value="/message",method={RequestMethod.POST, RequestMethod.GET})

public class MessageController {
    @Autowired
   private MessageService messageService;
    @Autowired
    TestService testService;

    @RequestMapping("/insertNewMessage")
    @ResponseBody
    public CommonReturnType insertNewMessage(@RequestBody Message message){
        messageService.insertMessage(message);
        return CommonReturnType.create(null);
    }
    @RequestMapping("/getList")
    @ResponseBody
    public CommonReturnType getList(@RequestBody Message message){
        return CommonReturnType.create(messageService.getMessageList(message.getId()));
    }
    @RequestMapping("/updateReader")
    @ResponseBody
    public CommonReturnType updateReader(@RequestParam("id") int id,@RequestParam("uid") int uid){
        testService.updateReader(id,uid);
        return CommonReturnType.create(null);
    }
}
