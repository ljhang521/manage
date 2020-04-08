package cn.edu.upc.ljh.service.impl;

import cn.edu.upc.dzh.until.SysUser;
import cn.edu.upc.manage.dao.ProjectMapper;
import cn.edu.upc.manage.model.Project;
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
        //int managerId=2; //session获取
        Integer loginId = SysUser.getCurrentUserId();
        System.out.println(loginId);
        return projectMapper.selectByManager(loginId);
    }

    @Override
    public Project selectByPrimaryKey(int id) {
        return projectMapper.selectByPrimaryKey(id);
    }
}
