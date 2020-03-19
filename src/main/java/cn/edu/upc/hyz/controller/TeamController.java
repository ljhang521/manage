package cn.edu.upc.hyz.controller;

import cn.edu.upc.hyz.service.TeamStructureListService;
import cn.edu.upc.manage.common.CommonReturnType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@Controller
@RequestMapping(value = "/teamStructure", method = {RequestMethod.POST, RequestMethod.GET})
public class TeamController {
    @Autowired
    private TeamStructureListService teamStructureListService;
    @RequestMapping("/getTeamStructure")
    @ResponseBody
    public CommonReturnType getTeamStructure(){
        //先获得tecnology的name1和name2
        List<LinkedHashMap<String,Object>> l = teamStructureListService.selectTeamStructureListTechnology();
        for(Map<String,Object> lm:l){
            Object value = lm.get("technologyIdSecond");
            System.out.println(value);
            int technologyIdSecond =Integer.parseInt(value.toString());
            lm.remove("technologyIdSecond");
            //通过tecnology2的id查出与之相关的user（id和name），group_user（user_type），
            // （或许有manager）
            List<LinkedHashMap<String,Object>> ll = teamStructureListService.selectTeamStructureListUser(technologyIdSecond);
            //将数据处理成json样式
            List <Map<String,Object>> lllm = new ArrayList();
            Map<String,Object> map = new LinkedHashMap();
            int  group_id=0,num =1;
            for(Map<String,Object> llm:ll){
            int flag =Integer.parseInt(llm.get("group_id").toString());
               if(group_id == 0){
                   map.put("groupLeader",llm.get("user_name"));
                   group_id = Integer.parseInt(llm.get("group_id").toString());
                   num = 1;
               } else if(group_id != 0 && group_id == flag) {
                    map.put("groupMember"+num++,llm.get("user_name"));
               }else{
                   lllm.add(map);
                   System.out.println(map);
                   map = new LinkedHashMap();
                   map.put("groupLeader",llm.get("user_name"));
                   num = 1;
               }
            }
            //处理过的数据放入list
            lm.put("groupList",lllm);
        }
        return CommonReturnType.create(l);
    }
}
