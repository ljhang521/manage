package cn.edu.upc.xjs.service.impl;


import cn.edu.upc.manage.dao.ProjectMapper;
import cn.edu.upc.manage.dao.ViewGroupUser2Mapper;
import cn.edu.upc.manage.dao.ViewGroupUserMapper;
import cn.edu.upc.manage.model.ViewGroupUser;
import cn.edu.upc.manage.model.ViewGroupUser2;
import cn.edu.upc.xjs.service.ProjectServiceXJS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("projectService5")
public class ProjectServiceXJSImpl implements ProjectServiceXJS {
    @Autowired
    ProjectMapper projectMapper;
    @Autowired
    ViewGroupUserMapper  ViewGroupUserMapper;
    @Autowired
    cn.edu.upc.manage.dao.ViewGroupUser2Mapper ViewGroupUser2Mapper;

    @Override
    public List<String> getProjectName() {
        return projectMapper.getProjectName();
    }
   @Override
    public List<ViewGroupUser>getGroupUser(Integer projectId){
        return   ViewGroupUserMapper.getGroupUser(projectId);
   }
    @Override
    public  List<ViewGroupUser2>getGroupPerson(Integer projectId){
        List<ViewGroupUser2> list=ViewGroupUser2Mapper.getGroupPerson(projectId);
        for(ViewGroupUser2 v:list){
            String temp="";
            ViewGroupUser2 vu=new ViewGroupUser2();
            vu.setProjectId(projectId);
            vu.setId(v.getId());
            vu.setUserType((byte)0);
            List<ViewGroupUser2> leader=ViewGroupUser2Mapper.getGroupPersonType(vu);
            temp="组长：";
            if(leader.size()>0)temp+=leader.get(0).getRealName();
            temp+="  ||  组员：";
            vu.setUserType((byte)1);
            List<ViewGroupUser2> ee=ViewGroupUser2Mapper.getGroupPersonType(vu);
            for(ViewGroupUser2 v1:ee){
                temp+=v1.getRealName()+",";
            }
            v.setRealName(temp);
        }
        return  list;
    }
}
