package cn.edu.upc.xjs.controller;


import cn.edu.upc.manage.common.CommonReturnType;
import cn.edu.upc.xjs.Service.ProjectServiceXJS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@CrossOrigin
@Controller
@RequestMapping(value="/project",method = {RequestMethod.POST,RequestMethod.GET})
public class ProjectControllerXJS {
    @Autowired
    private ProjectServiceXJS projectServiceXJS;
    @RequestMapping("/getProjectList")
    @ResponseBody
    public CommonReturnType getProjectList(){
        List<String> list= projectServiceXJS.getProjectName();
        return CommonReturnType.create(list);
    }

}

