package cn.edu.upc.xjs.controller;


import cn.edu.upc.manage.common.CommonReturnType;
import cn.edu.upc.manage.model.ViewGroupUser;
import cn.edu.upc.manage.model.ViewGroupUser2;
import cn.edu.upc.xjs.service.ProjectServiceXJS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Controller
@RequestMapping(value = "/project", method = {RequestMethod.POST, RequestMethod.GET})
public class ProjectControllerXJS {
    @Autowired
    private ProjectServiceXJS projectServiceXJS;

    @RequestMapping("/getProjectList")
    @ResponseBody
    public CommonReturnType getProjectList() {
        List<String> list = projectServiceXJS.getProjectName();
        return CommonReturnType.create(list);
    }
    @RequestMapping("/getGroupList")
    @ResponseBody
    public CommonReturnType getGroupList(@RequestBody ViewGroupUser group) {
        List<ViewGroupUser> list = projectServiceXJS.getGroupUser(group.getProjectId());
        return CommonReturnType.create(list);
    }
    @RequestMapping("/getGroupPerson")
    @ResponseBody
    public CommonReturnType getGroupPerson(@RequestBody ViewGroupUser2 group) {
        List<ViewGroupUser2> list = projectServiceXJS.getGroupPerson(group.getProjectId());
        return CommonReturnType.create(list);
    }

}

