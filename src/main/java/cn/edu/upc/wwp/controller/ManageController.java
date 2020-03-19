package cn.edu.upc.wwp.controller;

import cn.edu.upc.manage.common.CommonReturnType;
import cn.edu.upc.manage.model.Manage;
import cn.edu.upc.wwp.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Controller
@RequestMapping(value="/manage",method={RequestMethod.POST, RequestMethod.GET})

public class ManageController {
    @Autowired
    public ManageService manageService;
    @RequestMapping("/setTechnology")

    @ResponseBody
    public CommonReturnType select(){

        List<Manage> list1= manageService.selectTechnology();

        return  CommonReturnType.create(list1,"查询成功");
    }
    @ResponseBody

    @RequestMapping("/updateTechnology")
    public CommonReturnType update(@RequestBody Manage manage){

        manageService.updateTechnology(manage);

        return  CommonReturnType.create(null);
    }
    @ResponseBody

    @RequestMapping("/insertNewTechnology")
    public CommonReturnType insert(@RequestBody Manage manage){
        manageService.insertTechnology(manage);
        List<Manage> list1= manageService.selectTechnology();
        String msg;
        return  CommonReturnType.create(list1,"chaxun");
    }

    @ResponseBody

    @RequestMapping("/deleteNewTechnology")
    public CommonReturnType delete(@RequestParam(value= "id") Integer id){
        manageService.deleteTechnology(id);
        return  CommonReturnType.create("null");
    }
}
