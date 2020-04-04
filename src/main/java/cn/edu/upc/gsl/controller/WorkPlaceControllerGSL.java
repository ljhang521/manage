package cn.edu.upc.gsl.controller;

import cn.edu.upc.gsl.service.WorkPlaceService;
import cn.edu.upc.manage.common.CommonReturnType;
import cn.edu.upc.manage.model.WorkPlace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author gsl
 * @date 2020/3/21
 */
@CrossOrigin
@Controller
@RequestMapping(value = "/workPlace", method = {RequestMethod.POST, RequestMethod.GET})
public class WorkPlaceControllerGSL {

    @Autowired
    private WorkPlaceService workPlaceService;

    @RequestMapping("/list")
    @ResponseBody
    public CommonReturnType workPlaceList(){
        List<WorkPlace> workPlaceList = workPlaceService.workPlaceList();
        return CommonReturnType.create(workPlaceList,"成功返回所有地点");
    }

}
