package cn.edu.upc.ln.controller;

import cn.edu.upc.ln.service.RolerManageService;
import cn.edu.upc.manage.common.CommonReturnType;
import cn.edu.upc.manage.model.RolerManage;
import cn.edu.upc.manage.model.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Controller
@RequestMapping(value="/manage1",method = {RequestMethod.POST,RequestMethod.GET})
public class RolerController {
    @Autowired
    private RolerManageService rolerManageService;

    @RequestMapping("/Role")
    @ResponseBody
    public CommonReturnType disRoler(){
        List<RolerManage> r1 = rolerManageService.selectAllRoler();
        return CommonReturnType.create(r1);
    }

    @RequestMapping("/insertNewRole")
    @ResponseBody
    public CommonReturnType insertNewRole(@RequestBody RolerManage para){
        para.setDeleteMark(0);
        rolerManageService.insertNewRoler(para);
        List<RolerManage> r1=rolerManageService.selectAllRoler();
        return CommonReturnType.create(r1,"新增成功");
    }

    @RequestMapping("/updateRole")
    @ResponseBody
    public CommonReturnType updateRole(@RequestBody RolerManage para){
        rolerManageService.updateRoler(para);
        return CommonReturnType.create(null,null,0,"修改成功");
    }

    @RequestMapping("/deleteRole")
    @ResponseBody
    public CommonReturnType deleteRole(@RequestBody Test para){
        RolerManage r3=rolerManageService.selectRolerManage(para.getId());
        r3.setDeleteMark(1);
        rolerManageService.updateRoler(r3);
        return CommonReturnType.create(null,null,0,"删除成功");
    }
}
