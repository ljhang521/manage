package cn.edu.upc.zy.controller;

import cn.edu.upc.manage.common.CommonReturnType;
import cn.edu.upc.manage.model.Message;
import cn.edu.upc.manage.model.ViewMessageState;
import cn.edu.upc.zy.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Controller
@RequestMapping(value="/message",method={RequestMethod.POST, RequestMethod.GET})

public class MessageController {
    @Autowired
   private MessageService messageService;

    @RequestMapping("/insertNewMessage")
    @ResponseBody
    public CommonReturnType insertNewMessage(@RequestBody Message message){
        messageService.insertMessage(message);
        return CommonReturnType.create(null);
    }
    @RequestMapping("/getList")
    @ResponseBody
    public CommonReturnType getList(@RequestBody ViewMessageState message){
        return CommonReturnType.create(messageService.getMessageList(message));
    }
    @RequestMapping("/updateReader")
    @ResponseBody
    public CommonReturnType updateReader(@RequestBody ViewMessageState message){
        messageService.updateReader(message);
        return CommonReturnType.create(null);
    }
}
