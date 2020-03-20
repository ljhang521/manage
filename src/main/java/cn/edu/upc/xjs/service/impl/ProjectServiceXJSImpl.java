package cn.edu.upc.xjs.service.impl;


import cn.edu.upc.manage.dao.ProjectMapper;
import cn.edu.upc.xjs.service.ProjectServiceXJS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("projectService5")
public class ProjectServiceXJSImpl implements ProjectServiceXJS {
    @Autowired
    ProjectMapper projectMapper;

    @Override
    public List<String> getProjectName() {
        return projectMapper.getProjectName();
    }

}
