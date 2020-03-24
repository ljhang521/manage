package cn.edu.upc.ln.controller;

import cn.edu.upc.ln.service.PriManageService;
import cn.edu.upc.manage.common.CommonReturnType;
import cn.edu.upc.manage.model.PrivilegeManage;
import cn.edu.upc.manage.model.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Controller
@RequestMapping(value="/manage1",method = {RequestMethod.POST,RequestMethod.GET})
public class PrivilegeController {
    @Autowired
    private PriManageService priManageService;

    @RequestMapping("/setRight")
    @ResponseBody
    public CommonReturnType disRight(){
        List<PrivilegeManage> p1 = priManageService.selectAllPrivilege();
        return CommonReturnType.create(p1);
    }

    @RequestMapping("/insertNewRight")
    @ResponseBody
    public CommonReturnType insertNewRight(){
        PrivilegeManage p2=new PrivilegeManage();
        p2.setDeleteMark(0);
        priManageService.insertNewPrivilege(p2);
        List<PrivilegeManage> p1 = priManageService.selectAllPrivilege();
        return CommonReturnType.create(p1);
    }

    @RequestMapping("/updateRight")
    @ResponseBody
    public CommonReturnType updateRight(@RequestBody PrivilegeManage para){
        priManageService.updatePrivilege(para);
        return CommonReturnType.create(null,null,0,"更新成功");
    }

    @RequestMapping("/deleteRight")
    @ResponseBody
    public CommonReturnType deleteRight(@RequestBody Test para){
        PrivilegeManage p3=priManageService.selectPrivilegeManage(para.getId());
        p3.setDeleteMark(1);
        priManageService.updatePrivilege(p3);
        return CommonReturnType.create(null,null,0,"删除成功");
    }
}
