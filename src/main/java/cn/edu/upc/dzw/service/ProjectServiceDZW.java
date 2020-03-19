package cn.edu.upc.dzw.service;

import cn.edu.upc.manage.model.Project;
import cn.edu.upc.manage.model.ProjectDetail;
import cn.edu.upc.manage.model.ProjectNew;

import java.util.List;

/**
 * @author zhenwei
 * @date 2020/3/12
 */
public interface ProjectServiceDZW {

    /**
     * 获取全部项目
     *
     * @return
     */
    List<Project> getProjectList();

    /**
     * 获取全部项目
     * 加索引对应值
     *
     * @return
     */
    List<ProjectNew> getProjectListNew();

    /**
     * 新增项目
     *
     * @param project
     * @return
     */
    int addProject(Project project);

    /**
     * 获取某个项目信息
     *
     * @param id
     * @return
     */
    Project getProject(Integer id);

    /**
     * 获取某个项目信息
     *
     * @param id
     * @return
     */
    ProjectNew getProjectNew(Integer id);

    /**
     * 修改项目信息
     *
     * @param project
     * @return
     */
    int changeProject(Project project);

    /**
     * 删除某个项目
     *
     * @param project
     * @return
     */
    int deleteProject(Project project);

    /**
     * 获取项目相关所有数据
     *
     * @param id
     * @return
     */
    ProjectDetail getProjectDetail(Integer id);
}
