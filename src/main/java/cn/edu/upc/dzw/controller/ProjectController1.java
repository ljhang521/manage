package cn.edu.upc.dzw.controller;

import cn.edu.upc.dzw.service.ProjectService;
import cn.edu.upc.manage.common.CommonReturnType;
import cn.edu.upc.manage.model.Project;
import cn.edu.upc.manage.model.ProjectDetail;
import cn.edu.upc.manage.model.ProjectNew;
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
public class ProjectController1 {

    @Autowired
    private ProjectService projectService;

    @RequestMapping(value = "/addProject")
    @ResponseBody
    public CommonReturnType addProject(@RequestBody Project project) {
        projectService.addProject(project);
        List<ProjectNew> projectList = projectService.getProjectListNew();
        return CommonReturnType.create(projectList, "插入成功");
    }

    @RequestMapping(value = "/getProject")
    @ResponseBody
    public CommonReturnType getProject(@RequestBody Project record) {
        ProjectNew project = projectService.getProjectNew(record.getId());
        return CommonReturnType.create(project, "查询成功");
    }

    @RequestMapping(value = "/changeProject")
    @ResponseBody
    public CommonReturnType changeProject(@RequestBody Project project) {
        projectService.changeProject(project);
        List<ProjectNew> projectList = projectService.getProjectListNew();
        return CommonReturnType.create(projectList, "修改成功");
    }

    @RequestMapping(value = "/deleteProject")
    @ResponseBody
    public CommonReturnType deleteProject(@RequestBody Project project) {
        projectService.deleteProject(project);
        List<ProjectNew> projectList = projectService.getProjectListNew();
        return CommonReturnType.create(projectList, "删除成功");
    }

    @RequestMapping(value = "/getProjectDetail")
    @ResponseBody
    public CommonReturnType getProjectDetail(@RequestBody Project project) {
        ProjectDetail projectDetail = projectService.getProjectDetail(project.getId());
        return CommonReturnType.create(projectDetail, "查询成功");
    }
}
