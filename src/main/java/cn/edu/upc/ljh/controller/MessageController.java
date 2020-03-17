package cn.edu.upc.ljh.controller;

import cn.edu.upc.ljh.common.CommonReturnType;
import cn.edu.upc.ljh.model.Message;
import cn.edu.upc.ljh.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Controller
@RequestMapping(value="/message",method = {RequestMethod.POST,RequestMethod.GET})
public class MessageController {
    @Autowired
    private MessageService messageService;
    @RequestMapping("/insertNewMessage")
    @ResponseBody
    public CommonReturnType insertNewMessage(@RequestBody Message message){

        messageService.insertMessage(message);
        return CommonReturnType.create(null);

    }
}
