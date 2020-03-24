package cn.edu.upc.dzw.service;

import cn.edu.upc.manage.model.*;

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
     * 获取全部项目
     * 加索引对应值
     * 视图
     *
     * @return
     */
    List<ViewProject> getViewProjectList();

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
     * 加索引对应值
     *
     * @param id
     * @return
     */
    ProjectNew getProjectNew(Integer id);

    /**
     * 获取某个项目信息
     * 加索引对应值
     * 视图
     *
     * @param id
     * @return
     */
    ViewProject getViewProject(Integer id);

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

    /**
     * 获取所有人员
     * 项目组信息
     * 未分页
     *
     * @param groupId
     * @return
     */
    List<ViewUserProject> getPersonList(Integer groupId);

    /**
     * 设置人员小组信息
     *
     * @param groupUser
     * @return
     */
    void setPerson(GroupUser groupUser);
}
