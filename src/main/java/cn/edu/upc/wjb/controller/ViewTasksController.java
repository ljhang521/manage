package cn.edu.upc.wjb.controller;


import cn.edu.upc.manage.common.CommonReturnType;
import cn.edu.upc.wjb.service.ViewTasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;


@CrossOrigin
@Controller

@RequestMapping(value="/project",method = {RequestMethod.POST,RequestMethod.GET})

public class ViewTasksController {
    @Autowired
    ViewTasksService viewTasksService;

    @RequestMapping("/getProjectEmployeeRoleList")
    @ResponseBody
    public CommonReturnType getTasksList(HttpSession session){

        return CommonReturnType.create(viewTasksService.getTasksList(session));

    }
}
