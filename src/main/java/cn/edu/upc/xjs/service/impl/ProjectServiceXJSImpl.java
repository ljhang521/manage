package cn.edu.upc.xjs.service.impl;


import cn.edu.upc.manage.dao.ProjectMapper;
import cn.edu.upc.manage.dao.ViewGroupUser2Mapper;
import cn.edu.upc.manage.dao.ViewGroupUserMapper;
import cn.edu.upc.manage.model.ViewGroupUser;
import cn.edu.upc.manage.model.ViewGroupUser2;
import cn.edu.upc.xjs.service.ProjectServiceXJS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return  ViewGroupUser2Mapper.getGroupPerson(projectId);
    }
}
