package cn.edu.upc.ljh.controller;

import cn.edu.upc.manage.common.CommonReturnType;
import cn.edu.upc.manage.model.Progress;
import cn.edu.upc.ljh.service.ProgressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Controller
@RequestMapping(value="/progress",method = {RequestMethod.POST,RequestMethod.GET})
public class ProgressController {

    @Autowired
    private ProgressService progressService;


    @RequestMapping("/getProgressList")
    @ResponseBody
    public CommonReturnType getProjectList(@RequestBody Progress progress) {
        if(progress.getProjectId()==0){progress.setProjectId(1);}
        List<Progress> p=progressService.selectByProjectId(progress.getProjectId());
        return CommonReturnType.create(p);
    }
    @RequestMapping("/addProgressList")
    @ResponseBody
    public CommonReturnType addProjectList(@RequestBody Progress progress) {
        if(progress.getProjectId()==0){progress.setProjectId(1);}
        progressService.insert(progress);
        List<Progress> p=progressService.selectByProjectId(progress.getProjectId());
        return CommonReturnType.create(p);
    }
    @RequestMapping("/deleteProgressList")
    @ResponseBody
    public CommonReturnType deleteProjectList(@RequestBody Progress progress) {
        int projectId=progress.getProjectId();
        progressService.delete(progress.getId());
        List<Progress> p=progressService.selectByProjectId(projectId);
        return CommonReturnType.create(p);
    }
    @RequestMapping("/updateProgressList")
    @ResponseBody
    public CommonReturnType updateProjectList(@RequestBody Progress progress) {
        progressService.update(progress);
        List<Progress> p=progressService.selectByProjectId(progress.getProjectId());
        return CommonReturnType.create(p);
    }
}
