package cn.edu.upc.wwp.controller;

import cn.edu.upc.manage.common.CommonReturnType;
import cn.edu.upc.manage.model.Technology;
import cn.edu.upc.wwp.controller.param.TechnologyParam;
import cn.edu.upc.wwp.service.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Controller
@RequestMapping(value="/technology",method={RequestMethod.POST, RequestMethod.GET})
public class TechnologyController {
    @Autowired
    public TechnologyService technologyService;
    @RequestMapping("/selectTechnology")

    @ResponseBody


    public CommonReturnType select(){

        List<TechnologyParam> list1= technologyService.selectTechnology();

        return  CommonReturnType.create(list1,"查询成功");
    }

    @RequestMapping("/updateTechnology")

    @ResponseBody
    public CommonReturnType update(@RequestBody TechnologyParam upTechnologyParam){

        technologyService.updateTechnology(upTechnologyParam);
        List<TechnologyParam> list1= technologyService.selectTechnology();
        String msg;
        return  CommonReturnType.create(list1,"更新成功");
    }

    @RequestMapping("/insertNewTechnology")

    @ResponseBody
    public CommonReturnType insert(@RequestBody TechnologyParam inTechnologyParam){
        technologyService.insertTechnology(inTechnologyParam);
        List<TechnologyParam> list1= technologyService.selectTechnology();
        String msg;
        return  CommonReturnType.create(list1,"插入成功");
    }

    @RequestMapping("/deleteNewTechnology")

    @ResponseBody
    public CommonReturnType deleteFlag(@RequestBody Technology delTechnology){
        technologyService.deleteFlag(delTechnology);
        return  CommonReturnType.create("null");
    }


}
