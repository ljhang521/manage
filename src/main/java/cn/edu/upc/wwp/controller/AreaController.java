package cn.edu.upc.wwp.controller;

import cn.edu.upc.manage.common.CommonReturnType;
import cn.edu.upc.manage.model.Area;
import cn.edu.upc.wwp.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Controller
@RequestMapping(value="/area",method={RequestMethod.POST, RequestMethod.GET})
public class AreaController {
    @Autowired
    AreaService areaService;
    @RequestMapping("/selectArea")

    @ResponseBody
    public CommonReturnType select(){
        List<Area> list1= areaService.selectArea();
        return  CommonReturnType.create(list1);
    }

    @RequestMapping("/insertPlace")

    @ResponseBody
    public CommonReturnType insert(@RequestBody Area area){
        areaService.insertArea(area);
        List<Area> list2= areaService.selectArea();
        return  CommonReturnType.create(list2,"查询成功");

    }

    @RequestMapping("/updateNewPlace")

    @ResponseBody
    public CommonReturnType update(@RequestBody Area area) {

        areaService.updateArea(area);
        return CommonReturnType.create(null);
    }

    @RequestMapping("/deletePlace")

    @ResponseBody
    public CommonReturnType deleteFlag(@RequestBody Area area){
        areaService.deleteFlag(area);
        return  CommonReturnType.create("null");
    }
}
