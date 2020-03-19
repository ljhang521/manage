package cn.edu.upc.xjs.controller;

import cn.edu.upc.manage.common.CommonReturnType;
import cn.edu.upc.manage.model.GroupEx;
import cn.edu.upc.xjs.Service.GroupExServiceXJ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Controller
@RequestMapping(value="/project",method = {RequestMethod.POST,RequestMethod.GET})
public class GroupExControllerXJS {
    @Autowired
    private GroupExServiceXJ groupExServiceXJ;
    @RequestMapping("/addGroup")
    @ResponseBody
    public CommonReturnType addGroupEx (@RequestBody GroupEx groupEx){
        groupExServiceXJ.insertGroupEx(groupEx);
        List<GroupEx> list = groupExServiceXJ.selectGroupEx();
        return CommonReturnType.create(list);
    }
    @RequestMapping("/changeGroupName")
    @ResponseBody
    public CommonReturnType changeGroupName(@RequestBody GroupEx changeName){
         groupExServiceXJ.changeGroupEx(changeName);
        List<GroupEx> list = groupExServiceXJ.selectGroupEx();
         return CommonReturnType.create(list);
    }
    @RequestMapping("/deleteGroup")
    @ResponseBody
     public CommonReturnType deleteGroup(@RequestBody GroupEx group){

         groupExServiceXJ.deleteGroupEx(group);
         List<GroupEx>  list = groupExServiceXJ.selectGroupEx();
          return CommonReturnType.create(list,"删除成功");
    }

}
