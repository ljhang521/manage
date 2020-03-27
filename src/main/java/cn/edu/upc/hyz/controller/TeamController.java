package cn.edu.upc.hyz.controller;

import cn.edu.upc.hyz.service.TeamStructureListService;
import cn.edu.upc.manage.common.CommonReturnType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

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
            //System.out.println(value);
            int technologyIdSecond =Integer.parseInt(value.toString());
            lm.remove("technologyIdSecond");
            //没有组长的方向为空
            lm.put("manager","");
            //通过tecnology2的id查出与之相关的user（id和name），group_user（user_type），
            // （或许有manager）
            List<LinkedHashMap<String,Object>> ll = teamStructureListService.selectTeamStructureListUser(technologyIdSecond);
            //将数据处理成json样式
            List <Map<String,Object>> GroupList = new ArrayList();
            //对数据按小组划分
            Map<String,List<Map<String,Object>>> Group_Data = new HashMap<String,List<Map<String,Object>>>();
            for (Map<String, Object> map : ll) {
                String groupId = map.get("group_id").toString();
                List<Map<String,Object>> listMap = Group_Data.get(groupId);//数据按模板编号分类
                if(listMap == null){
                    listMap = new ArrayList<Map<String,Object>>();
                    Group_Data.put(groupId, listMap);
                }
                listMap.add(map);
            }
            System.out.println(Group_Data);
            //对数据按角色和组员类型划分
            for (String key  : Group_Data.keySet()) {
                Map<String,Object> GroupUsers = new LinkedHashMap<String, Object>();
                int num = 1;
                for(Map<String,Object> groupUser : Group_Data.get(key)){
                    int role = Integer.parseInt(groupUser.get("role").toString());
                    if(role == 0){
                        lm.put("manager",groupUser.get("real_name"));
                        // System.out.println("manager:"+llm.get("real_name"));
                        continue;
                    }
                    int user_type =Integer.parseInt(groupUser.get("user_type").toString());
                    if(user_type == 0){
                        GroupUsers.put("groupLeader",groupUser.get("real_name"));
                    }else if(user_type == 1){
                        GroupUsers.put("groupMember"+num++,groupUser.get("real_name"));
                    }
                }
                GroupList.add(GroupUsers);
            }
            lm.put("groupList",GroupList);

        }
        return CommonReturnType.create(l);
    }
}
