package cn.edu.upc.xjs.controller;

import cn.edu.upc.manage.common.CommonReturnType;
import cn.edu.upc.manage.model.GroupEx;
import cn.edu.upc.xjs.service.GroupExServiceXJS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Controller
@RequestMapping(value = "/project", method = {RequestMethod.POST, RequestMethod.GET})
public class GroupExControllerXJS {
    @Autowired
    private GroupExServiceXJS groupExServiceXJS;

    @RequestMapping("/addGroup")
    @ResponseBody
    public CommonReturnType addGroupEx(@RequestBody GroupEx groupEx) {
        groupExServiceXJS.insertGroupEx(groupEx);
        List<GroupEx> list = groupExServiceXJS.selectGroupEx();
        return CommonReturnType.create(list);
    }

    @RequestMapping("/changeGroupName")
    @ResponseBody
    public CommonReturnType changeGroupName(@RequestBody GroupEx changeName) {
        groupExServiceXJS.changeGroupEx(changeName);
        List<GroupEx> list = groupExServiceXJS.selectGroupEx();
        return CommonReturnType.create(list);
    }

    @RequestMapping("/deleteGroup")
    @ResponseBody
    public CommonReturnType deleteGroup(@RequestBody GroupEx group) {
        groupExServiceXJS.deleteGroupEx(group);
        List<GroupEx> list = groupExServiceXJS.selectGroupEx();
        return CommonReturnType.create(list, "删除成功");
    }

}
