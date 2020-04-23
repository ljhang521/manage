package cn.edu.upc.zy.controller;

import cn.edu.upc.dzw.service.ProjectServiceDZW;
import cn.edu.upc.ljh.service.ProjectService;
import cn.edu.upc.manage.common.CommonReturnType;
import cn.edu.upc.manage.model.Message;
import cn.edu.upc.manage.model.Project;
import cn.edu.upc.manage.model.ViewMessageState;
import cn.edu.upc.zy.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@Controller
@RequestMapping(value="/message",method={RequestMethod.POST, RequestMethod.GET})

public class MessageController {
    @Autowired
    private MessageService messageService;
    //发送信息模块
    @RequestMapping("/insertNewMessage")
    @ResponseBody
    public CommonReturnType insertNewMessage(@RequestBody Message message){
        messageService.insertMessage(message);
        return CommonReturnType.create(null);
    }
    //获取收到的信息模块
    @RequestMapping("/getList")
    @ResponseBody
    public CommonReturnType getList(@RequestBody ViewMessageState message){
        return CommonReturnType.create(messageService.getMessageList(message));
    }
    //更新阅读转态
    @RequestMapping("/updateReader")
    @ResponseBody
    public CommonReturnType updateReader(@RequestBody ViewMessageState message){

        messageService.updateReader(message);
        return CommonReturnType.create(null);
    }
    //为发送信息提供名单（项目，小组，人员）
    @RequestMapping("/test")
    @ResponseBody
    public CommonReturnType test(){
        Map<String,Object> list = new LinkedHashMap<String,Object>();
        list.put("technology",messageService.getProjectList());
        list.put("group",messageService.getGroupList());
        list.put("user",messageService.getUserList());
        return CommonReturnType.create(list);
    }

    @RequestMapping("/test1")
    @ResponseBody
    public CommonReturnType test1(@RequestBody Map<String, Integer> id){
        System.out.println(id.get("id"));
        return CommonReturnType.create(messageService.getMessageList(id.get("id")));
    }
}
