package cn.edu.upc.zy.controller;

import cn.edu.upc.zy.service.MessageServiceZY;
import cn.edu.upc.manage.common.CommonReturnType;
import cn.edu.upc.manage.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Controller
@RequestMapping(value="/message9",method={RequestMethod.POST, RequestMethod.GET})

public class MessageControllerZY {
    @Autowired
   private MessageServiceZY messageServiceZY;

    @RequestMapping("/insertNewMessage")
    @ResponseBody
    public CommonReturnType insertNewMessage(@RequestBody Message message){
        messageServiceZY.insertMessage(message);
        return CommonReturnType.create(null);
    }
}
