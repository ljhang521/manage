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


@CrossOrigin
@Controller
@RequestMapping(value = "/teamStructure", method = {RequestMethod.POST, RequestMethod.GET})
public class TeamController {
    @Autowired
    private TeamStructureListService teamStructureListService;
    @RequestMapping("/Test")
    @ResponseBody
    public CommonReturnType Test(){
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
            //System.out.println(Group_Data);
            //对数据按角色和组员类型划分
            for (String key  : Group_Data.keySet()) {
                Map<String,Object> GroupUsers = new LinkedHashMap<String, Object>();
                int num = 1;
                for(Map<String,Object> groupUser : Group_Data.get(key)){
                    int role = Integer.parseInt(groupUser.get("role").toString());
                    if(role == 0){
                        lm.put("manager",groupUser.get("real_name"));
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
        LinkedHashMap<String,Object> organizationStructure = dataProcessing(l);
        return CommonReturnType.create(organizationStructure);
    }

    @RequestMapping("/getTeamStructure")
    @ResponseBody
    public CommonReturnType getTeamStructure(){
        List<LinkedHashMap<String, Object>> technologys = teamStructureListService.selectTeamStructureListTechnologyTest();
        System.out.println(technologys);
        //连接tecnology和technologySecond
        System.out.println(technologys);
        for(Map<String ,Object>technology:technologys ){
            int technologyId = Integer.parseInt(technology.get("technologyId").toString());
            List<LinkedHashMap<String,Object>> technologySecondData ;
            technologySecondData = teamStructureListService.selectTeamStructureListTechnologySecond(technologyId);
            int technologySecondNum = technologySecondData.size();

            for(Map<String,Object> lm:technologySecondData){
                Object value = lm.get("technologyIdSecond");
                //System.out.println(value);
                int technologyIdSecond =Integer.parseInt(value.toString());
                lm.remove("technologyIdSecond");
                //没有组长的方向为空
                lm.put("manager","");
                String groupLeader = "";
                //通过tecnology2的id查出与之相关的user（id和name），group_user（user_type），
                // （或许有manager）
                List<LinkedHashMap<String,Object>> users = teamStructureListService.selectUserForTechnology(technologyIdSecond);
                //将数据处理成json样式
                //存放组员

                List <Map<String,Object>> groupList = new ArrayList();
                Map<String,Object> groupMembers =new LinkedHashMap<String,Object>();
                /*
                * 0--manager组长（项目管理人，只有一个）
                * 1--groupLeader小组长（有数个，放在一起）
                * 2--groupMember组员（有数个）
                * */
                int groupMember  = 1 ;
                int groupLeaderMenber = 0;
                for(LinkedHashMap<String,Object> user:users){
                    System.out.println(user);
                    int  fieldPosition = Integer.parseInt(user.get("field_position").toString());
                    if(fieldPosition == 1){
                        lm.put("manager","负责人：\n"+user.get("real_name"));
                    }
                    else if(fieldPosition == 2){
                        if(groupLeaderMenber++ == 0)
                            groupLeader ="组长：\n" + groupLeader  + user.get("real_name").toString() ;
                        else{
                            groupLeader = groupLeader + "\n" + user.get("real_name").toString() ;
                            groupLeaderMenber ++ ;
                        }

                    }
                    else if(fieldPosition == 3) {
                        groupMembers.put("groupMember" + groupMember++, user.get("real_name").toString());
                    }
                }

                lm.put("groupLeader", groupLeader);
                lm.put("groupLeaderMenber", groupLeaderMenber);
                groupList.add(groupMembers);
                lm.put("groupList",groupList);
            }
            technology.put("technologySecondNum",technologySecondNum);
            technology.put("technologySecond",technologySecondData);

        }
        //连接并处理technology和user

       /* for(Map<String,Object> lm:allData){
            Object value = lm.get("technologyIdSecond");
            int technologyIdSecond =Integer.parseInt(value.toString());
            lm.remove("technologyIdSecond");
            //没有组长的方向为空
            lm.put("manager","项目负责人");
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
            //System.out.println(Group_Data);
            //对数据按角色和组员类型划分
            for (String key  : Group_Data.keySet()) {
                Map<String,Object> GroupUsers = new LinkedHashMap<String, Object>();
                int num = 1;
                for(Map<String,Object> groupUser : Group_Data.get(key)){
                    int role = Integer.parseInt(groupUser.get("role").toString());
                    if(role == 0){
                        lm.put("manager",groupUser.get("real_name"));
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
        }*/
        LinkedHashMap<String,Object> organizationStructure = dataHandling(technologys);
        return CommonReturnType.create(organizationStructure);
    }

    public LinkedHashMap<String,Object> dataProcessing(List<LinkedHashMap<String,Object>> data){
        //根节点
        LinkedHashMap<String,Object> organizationStructure = new  LinkedHashMap<String,Object>();
        organizationStructure.put("name","组织结构");
        List<LinkedHashMap<String,Object>> projects = new ArrayList<LinkedHashMap<String, Object>>();
        //因为原格式将technologyName层数据处理，形成一个technologyName层有多个technologyNameSecond层
        LinkedHashMap<String,Object> technologyName = new  LinkedHashMap<String,Object>();
        List<LinkedHashMap<String,Object>> technologyNames = new ArrayList<LinkedHashMap<String, Object>>();
        technologyName.put("name",data.get(0).get("technologyName"));
        //叶节点
        for(LinkedHashMap<String,Object> data1:data){
            //technologyName层
            if(!technologyName.get("name").equals(data1.get("technologyName"))  ){
                technologyName.put("children",technologyNames);
                projects.add(technologyName);
                technologyName = new  LinkedHashMap<String,Object>();
                technologyNames = new ArrayList<LinkedHashMap<String, Object>>();
                technologyName.put("name",data1.get("technologyName"));
            }
            //technologyNameSecond层
            LinkedHashMap<String,Object> technologyNameSecond = new  LinkedHashMap<String,Object>();
            List<LinkedHashMap<String,Object>> technologyNameSeconds = new ArrayList<LinkedHashMap<String, Object>>();
            technologyNameSecond.put("name",data1.get("technologyNameSecond"));
            //manager层
            LinkedHashMap<String,Object> manager = new  LinkedHashMap<String,Object>();
            List<Object> managers = new ArrayList<Object>();
            manager.put("name",data1.get("manager"));
            int teamNum = 1;
            //group和User层
            List<LinkedHashMap<String,Object>> groupList =(List<LinkedHashMap<String,Object>>) data1.get("groupList");
            for(LinkedHashMap<String,Object> groupl:groupList){
                List<LinkedHashMap<String,Object>> group = new ArrayList<LinkedHashMap<String, Object>>();
                for(String key:groupl.keySet()){
                    LinkedHashMap<String,Object> user = new LinkedHashMap<String,Object>();
                    user.put("name",groupl.get(key));
                    /*List<Object> test = new ArrayList<Object>();
                    user.put("children",test);*/
                    group.add(user);
                }
                //为了能显示，多加一层team
                Map<String,Object> team = new LinkedHashMap<String,Object>();
                team.put("name","队伍"+teamNum++);
                team.put("children",group);
                managers.add(team);
            }
            /*数据处理成
            *Children：
            * [
            *   {
            *   }
            * ]
            * 的形式，为每个map加一层list
            * */
            manager.put("children",managers);
            technologyNameSeconds.add(manager);
            technologyNameSecond.put("children",technologyNameSeconds);
            technologyNames.add(technologyNameSecond);
            //projects.add(technologyName);
        }
        technologyName.put("children",technologyNames);
        projects.add(technologyName);
        organizationStructure.put("children",projects);
        return organizationStructure;
    }

    public LinkedHashMap<String,Object> dataHandling(List<LinkedHashMap<String,Object>> data){
        //根节点
        LinkedHashMap<String,Object> organizationStructure = new  LinkedHashMap<String,Object>();
        organizationStructure.put("name","组织结构");
        List<LinkedHashMap<String,Object>> projects = new ArrayList<LinkedHashMap<String, Object>>();
        //叶节点
        /*数据处理成
         *Children：
         * [
         *   {
         *   }
         * ]
         * 的形式，为每个map加一层list
         * */
        for(LinkedHashMap<String,Object> data1:data){
            //technologyName层
            LinkedHashMap<String,Object> technologyName = new  LinkedHashMap<String,Object>();
            List<LinkedHashMap<String,Object>> technologyNames = new ArrayList<LinkedHashMap<String, Object>>();
            technologyName.put("name",data1.get("technologyName"));
            List<LinkedHashMap<String,Object>> data2 =(List<LinkedHashMap<String,Object>>) data1.get("technologySecond");
            for(LinkedHashMap<String,Object> data3:data2){
                //technologySecondName层
                LinkedHashMap<String,Object> technologyNameSecond = new  LinkedHashMap<String,Object>();
                List<LinkedHashMap<String,Object>> technologyNameSeconds = new ArrayList<LinkedHashMap<String, Object>>();
                technologyNameSecond.put("name",data3.get("technologyNameSecond").toString());
                //manager层
                LinkedHashMap<String,Object> manager = new  LinkedHashMap<String,Object>();
                List<Object> managers = new ArrayList<Object>();
                manager.put("name",data3.get("manager").toString());
                //groupLeader层
                LinkedHashMap<String,Object> groupLeader = new  LinkedHashMap<String,Object>();
                List<Object> groupLeaders = new ArrayList<Object>();
                groupLeader.put("name",data3.get("groupLeader").toString());
                List<Object> GL_SymbolSize =new ArrayList<Object>() ;
                int GL_SymbolSizeWidth = 80 ;
                int GL_SymbolSizeHeight = 45 +
                       15 * Integer.parseInt(data3.get("groupLeaderMenber").toString());
                GL_SymbolSize.add(GL_SymbolSizeWidth);
                GL_SymbolSize.add(GL_SymbolSizeHeight);
                groupLeader.put("symbolSize",GL_SymbolSize);
                //group和User层
                int flag = 0;
                List<LinkedHashMap<String, Object>> groupList = (List<LinkedHashMap<String, Object>>) data3.get("groupList");
                for(LinkedHashMap<String,Object> groupl:groupList){
                    Map<String,Object> groupMenbers = new LinkedHashMap<String, Object>() ;
                    List<Object> GM_SymbolSize =new ArrayList<Object>() ;
                    int GM_SymbolSizeWidth = 80 ;
                    int GM_SymbolSizeHeight = 45 +
                            15 * groupl.size();
                    GM_SymbolSize.add(GM_SymbolSizeWidth);
                    GM_SymbolSize.add(GM_SymbolSizeHeight);
                    String groupMenberNmaes = "\n";
                    for(String key : groupl.keySet()){
                        groupMenberNmaes = groupMenberNmaes +
                                groupl.get(key).toString() + "\n";
                    }
                    groupMenbers.put("name",groupMenberNmaes);
                    groupMenbers.put("symbolSize",GM_SymbolSize);
                    groupLeaders.add(groupMenbers);
                }
                groupLeader.put("children",groupLeaders);
                managers.add(groupLeader);
                manager.put("children",managers);
                technologyNameSeconds.add(manager);
                technologyNameSecond.put("children",technologyNameSeconds);
                technologyNames.add(technologyNameSecond);
            }
            //technologyNameSecond层
            technologyName.put("children",technologyNames);
            projects.add(technologyName);
            //projects.add(technologyName);
        }
        organizationStructure.put("children",projects);
        return organizationStructure;
    }


}
