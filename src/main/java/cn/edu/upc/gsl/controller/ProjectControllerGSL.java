package cn.edu.upc.gsl.controller;


import cn.edu.upc.gsl.service.ProjectServiceGSL;
import cn.edu.upc.manage.common.CommonReturnType;
import cn.edu.upc.manage.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 项目
 *
 *根据名称模糊查询
 * @author gsl
 * @date 2020/3/12
 */
@CrossOrigin
@Controller
@RequestMapping(value = "/project2", method = {RequestMethod.POST, RequestMethod.GET})
public class ProjectControllerGSL {

    @Autowired
    private ProjectServiceGSL projectService;


    @RequestMapping("/projectList")
    @ResponseBody
    public CommonReturnType getProjects(@RequestBody Project project) {
        String projectName = project.getProjectName();
        List<Project> projectList = projectService.selectProjectList(projectName);
        return CommonReturnType.create(projectList);
    }
}
