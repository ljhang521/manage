package cn.edu.upc.wjb.controller;

import cn.edu.upc.manage.common.CommonReturnType;
import cn.edu.upc.manage.model.Report;
import cn.edu.upc.wjb.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/projectReport",method ={RequestMethod.POST,RequestMethod.GET})
@CrossOrigin(allowCredentials = "true",allowedHeaders = "*")
public class ReportController {
    @Autowired
    ReportService reportService;

    @RequestMapping("/getProjectReportList")
    @ResponseBody
    public CommonReturnType select(@RequestBody Report report){
        return CommonReturnType.create(reportService.getListByParam(report.getProjectId(),report.getGroupId(),report.getEmployeeId()));
    }
    @RequestMapping("/getProjectReportChickList")
    @ResponseBody
    public CommonReturnType checkSelect(@RequestParam(value = "pid") int pid, @RequestParam(value = "gid") int gid, @RequestParam(value = "eid") int eid){
        return CommonReturnType.create(reportService.getListByParam(pid,gid,eid));
    }

    @RequestMapping("/insertProjectReportList")
    @ResponseBody
    public CommonReturnType insertNewMessage(@RequestBody Report report){
        reportService.insertReport(report);
        return CommonReturnType.create(null);

    }

}
