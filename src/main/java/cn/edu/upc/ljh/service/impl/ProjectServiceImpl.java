package cn.edu.upc.ljh.service.impl;

import cn.edu.upc.ljh.dao.ProjectMapper;
import cn.edu.upc.ljh.model.Project;
import cn.edu.upc.ljh.service.ProjectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("projectService")
public class ProjectServiceImpl implements ProjectService {
    @Resource
    private ProjectMapper projectMapper;
    @Override
    public void insertProject(Project project) {
            projectMapper.insertSelective(project);
    }

    @Override
    public List<Project> selectByManager() {
        int managerId=2; //session获取
        return projectMapper.selectByManager(managerId);
    }

    @Override
    public Project selectByPrimaryKey(int id) {
        return projectMapper.selectByPrimaryKey(id);
    }
}
