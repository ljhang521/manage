package cn.edu.upc.zy.controller;

import cn.edu.upc.zy.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@CrossOrigin
@Controller
@RequestMapping(value="/message",method={RequestMethod.POST, RequestMethod.GET})

public class MessageController {
    @Autowired
    private MessageService messageService;
//    @RequestMapping("/insertNewMeaasge")
//
//    @ResponseBody
}
