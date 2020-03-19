package cn.edu.upc.gsl.service;

import cn.edu.upc.manage.model.Project;

import java.util.List;

/**
 * @author gsl
 * @date 2020/3/18
 */

public interface ProjectServiceGSL {

    /**
     * 根据项目名称返回对应的项目
     * @param projectName
     * @return
     */
    List<Project> selectProjectList(String  projectName);

}
