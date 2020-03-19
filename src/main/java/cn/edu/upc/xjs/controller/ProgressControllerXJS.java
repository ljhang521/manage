package cn.edu.upc.xjs.controller;
import cn.edu.upc.manage.common.CommonReturnType;
import cn.edu.upc.manage.model.Progress;
import cn.edu.upc.xjs.Service.ProgressServiceXJS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@Controller
@RequestMapping(value="/project",method = {RequestMethod.POST,RequestMethod.GET})
public class ProgressControllerXJS {
    @Autowired
    private ProgressServiceXJS progressService;
    @RequestMapping("/getProgressList1")
    @ResponseBody
    public CommonReturnType getData(@RequestBody Progress projectId){
       List<Progress> list=progressService.selectProgress(projectId);

        return CommonReturnType.create(list);
    }

    @RequestMapping("/addProgress")
    @ResponseBody
    public CommonReturnType addProgress ( @RequestBody Progress progress){
        progressService.insertProgress(progress);
        return CommonReturnType.create(null);
    }

    @RequestMapping("/updateProgress")
    @ResponseBody
    public CommonReturnType updateProgress (@RequestBody Progress change ){

        progressService.updateDel(change);

        List<Progress> list = progressService.select();

        return CommonReturnType.create(list);
    }
    @RequestMapping("/deleteProgress")
    @ResponseBody
    public  CommonReturnType deleteProgress(@RequestBody Integer id){
        progressService.updateDelete(id);

        return CommonReturnType.create(null);

    }
}