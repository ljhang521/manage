package cn.edu.upc.xjs.service;


import cn.edu.upc.manage.model.ViewGroupUser;

import java.util.List;

public interface ProjectServiceXJS {
    /**
     * 获取项目列表
     *
     * @return
     */
    List<String> getProjectName();
    /**
     * 人员设定
     *
     * @return
     */
    List<ViewGroupUser> getGroupUser(Integer projectId);
}
