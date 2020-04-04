package cn.edu.upc.ln.controller;

import cn.edu.upc.ln.service.RolerManageService;
import cn.edu.upc.manage.common.CommonReturnType;
import cn.edu.upc.manage.model.*;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
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
        List<ViewRightsRole> r1 = rolerManageService.selectAllRoler();
        return CommonReturnType.create(r1);
    }

    @RequestMapping("/insertNewRole")
    @ResponseBody
    public CommonReturnType insertNewRole(@RequestBody JSONObject para){
        String roleName=para.getString("roleName");
        JSONArray jsonArray = para.getJSONArray("rightsList");
        int len=jsonArray.size();
        Role role =new Role();
        role.setRoleName(roleName);
        role.setDelFlag(0);
        int roleId=rolerManageService.insertNewRole(role);
        for(int a=0;a<len;a++)
        {
            int rightId=jsonArray.getInteger(a);
            RightRole rightRole =new RightRole();
            rightRole.setRightId(rightId);
            rightRole.setRoleId(roleId);
            rightRole.setDelFlag(0);
            rolerManageService.insertNewRightRole(rightRole);
        }
        return CommonReturnType.create(null,null,0,"新增成功");
    }

    @RequestMapping("/updateRole")
    @ResponseBody
    public CommonReturnType updateRole(@RequestBody JSONObject para){
        int deleteId=para.getInteger("roleId");
        rolerManageService.deleteRightRole(deleteId);
        JSONArray jsonArray = para.getJSONArray("rightsList");
        String roleName=para.getString("roleName");
        RightRoleInput r=new RightRoleInput();
        r.setId(deleteId);
        r.setRoleName(roleName);
        rolerManageService.updateRoleName(r);
        int length=jsonArray.size();
        for(int b=0;b<length;b++)
        {
            int rightId=jsonArray.getInteger(b);
            RightRole rightRole =new RightRole();
            rightRole.setRightId(rightId);
            rightRole.setRoleId(deleteId);
            rightRole.setDelFlag(0);
            rolerManageService.insertNewRightRole(rightRole);
        }
        return CommonReturnType.create(null,null,0,"修改成功");
    }

    @RequestMapping("/deleteRole")
    @ResponseBody
    public CommonReturnType deleteRole(@RequestBody Test para){
        rolerManageService.delete(para.getId());
        return CommonReturnType.create(null,null,0,"删除成功");
    }

    @RequestMapping("/selectItem")
    @ResponseBody
    public CommonReturnType selectItem(@RequestBody Test para){
        List<RightRole> r1=rolerManageService.selectByRoleId(para.getId());
        return CommonReturnType.create(r1);
    }
}
