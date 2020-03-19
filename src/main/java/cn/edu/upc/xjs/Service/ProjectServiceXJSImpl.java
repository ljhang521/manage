package cn.edu.upc.xjs.Service;


import cn.edu.upc.manage.dao.ProjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("projectService5")

public class ProjectServiceXJSImpl implements ProjectServiceXJS {
    @Autowired
    ProjectMapper projectMapper;

    @Override
    public List<String> getProjectName(){
      return  projectMapper.getProjectName();
    }

}
