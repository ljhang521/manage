package cn.edu.upc.wjw.controller;

import cn.edu.upc.manage.common.CommonReturnType;
import cn.edu.upc.manage.model.Rights;
import cn.edu.upc.wjw.service.impl.RightServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//注意：写完一个新的接口记得重启tomcat，否则postman会报404，找不到这个接口
@CrossOrigin//解决跨域问题
@Controller
@RequestMapping(value="/manage",method = {RequestMethod.POST,RequestMethod.GET})
public class RightController {
    @Autowired(required = false)
    @Qualifier("rightServiceImpl")
    private RightServiceImpl rightService;

    @RequestMapping("/insertNewRight")
    @ResponseBody
    public CommonReturnType insertNewRight(@RequestBody Rights rights){
        rightService.insertRight(rights);
        //注意：第22行的rightService首字母r一定要小写！错误犯两次了！！！
        return CommonReturnType.create(null);
    }//新增
    @RequestMapping("/setRight")
    @ResponseBody
    public CommonReturnType selectAllRights(){
        List<Rights> r = rightService.selectAllRights();
        return CommonReturnType.create(r);
    }//显示

    @RequestMapping("/deleteRight")
    @ResponseBody
    public CommonReturnType deleteRight(@RequestBody Rights rights){
        rightService.deleteRight(rights);
        //id是rights表私有的，若想调用则应使用getid()方法
        return CommonReturnType.create(null);
    }//删除

    @RequestMapping("/updateRight")
    @ResponseBody
    public CommonReturnType updateRight(@RequestBody Rights rights){
        rightService.updateRight(rights);
        return CommonReturnType.create(null);
    }//更新
}
