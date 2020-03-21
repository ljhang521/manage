package cn.edu.upc.dzw.controller;

import cn.edu.upc.dzw.service.ProjectServiceDZW;
import cn.edu.upc.manage.common.CommonReturnType;
import cn.edu.upc.manage.model.Project;
import cn.edu.upc.manage.model.ProjectDetail;
import cn.edu.upc.manage.model.ProjectNew;
import cn.edu.upc.manage.model.ViewProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 项目
 *
 * @author zhenwei
 * @date 2020/3/12
 */
@CrossOrigin
@Controller
@RequestMapping(value = "/project1", method = {RequestMethod.POST, RequestMethod.GET})
public class ProjectControllerDZW {

    @Autowired
    private ProjectServiceDZW projectServiceDZW;

    @RequestMapping(value = "/addProject")
    @ResponseBody
    public CommonReturnType addProject(@RequestBody Project project) {
        projectServiceDZW.addProject(project);
        List<ViewProject> projectList = projectServiceDZW.getViewProjectList();
        return CommonReturnType.create(projectList, "插入成功");
    }

    @RequestMapping(value = "/getProject")
    @ResponseBody
    public CommonReturnType getProject(@RequestBody Project record) {
        ViewProject project = projectServiceDZW.getViewProject(record.getId());
        return CommonReturnType.create(project, "查询成功");
    }

    @RequestMapping(value = "/changeProject")
    @ResponseBody
    public CommonReturnType changeProject(@RequestBody Project project) {
        projectServiceDZW.changeProject(project);
        List<ViewProject> projectList = projectServiceDZW.getViewProjectList();
        return CommonReturnType.create(projectList, "修改成功");
    }

    @RequestMapping(value = "/deleteProject")
    @ResponseBody
    public CommonReturnType deleteProject(@RequestBody Project project) {
        projectServiceDZW.deleteProject(project);
        List<ViewProject> projectList = projectServiceDZW.getViewProjectList();
        return CommonReturnType.create(projectList, "删除成功");
    }

    @RequestMapping(value = "/getProjectDetail")
    @ResponseBody
    public CommonReturnType getProjectDetail(@RequestBody Project project) {
        ProjectDetail projectDetail = projectServiceDZW.getProjectDetail(project.getId());
        return CommonReturnType.create(projectDetail, "查询成功");
    }
}
