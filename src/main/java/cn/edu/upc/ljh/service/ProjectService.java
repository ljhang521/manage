package cn.edu.upc.ljh.service;

import cn.edu.upc.manage.model.Project;

import java.util.List;

public interface ProjectService {
    public void insertProject(Project project);
    public List<Project> selectByManager();
    public Project selectByPrimaryKey(int id);
}
