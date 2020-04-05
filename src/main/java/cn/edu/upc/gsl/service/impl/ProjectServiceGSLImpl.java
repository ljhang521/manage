package cn.edu.upc.gsl.service.impl;

import cn.edu.upc.gsl.service.ProjectServiceGSL;
import cn.edu.upc.manage.dao.ProjectMapper;
import cn.edu.upc.manage.dao.UserMapper;
import cn.edu.upc.manage.dao.WorkPlaceMapper;
import cn.edu.upc.manage.model.Project;
import cn.edu.upc.manage.model.User;
import cn.edu.upc.manage.model.WorkPlace;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author gsl
 * @date
 */
@Service("projectServiceGSL")
public class ProjectServiceGSLImpl implements ProjectServiceGSL {


    @Resource
    ProjectMapper projectMapper;
    @Resource
    WorkPlaceMapper workPlaceMapper;
    @Resource
    UserMapper userMapper;

    /**
     * 根据项目名称返回对应的项目列表
     *
     * @param projectName 项目名称
     * @return
     */
    @Override
    public List<Project> selectProjectList(String projectName) {

        List<Project> projectList;
        //查询满足条件的所有项目数据
        if (projectName == null || "".equals(projectName)) {
            projectList = projectMapper.getProjectList();
        } else {
            projectList = projectMapper.selectByProjectName(projectName);
        }
        //循环用来进行连表查询并赋值
        for (Project eachProject : projectList) {
            Integer workPlaceId = eachProject.getPlace();
            Integer managerId = eachProject.getManager();

            if (workPlaceId != null) {
                WorkPlace workPlace = workPlaceMapper.selectByPrimaryKey(workPlaceId);
                //增加判空，因为有可能出现虽然在project表里有此worePlaceId,
                // 但在work_place表里的del_flag != 0（即已被软删除）的情况
                if (workPlace != null) {
                    String workPlaceName = workPlace.getWorkPlace();
                    eachProject.setWorkPlaceName(workPlaceName);
                } else {
                    eachProject.setWorkPlaceName("空");
                }
            } else {
                eachProject.setWorkPlaceName("暂无");
            }
            if (managerId != null) {
                User manager = userMapper.selectByPrimaryKey(managerId);
                //增加判空
                if (manager != null) {
                    eachProject.setManagerName(manager.getRealName());
                } else {
                    eachProject.setManagerName("空");
                }
            } else {
                eachProject.setManagerName("暂无");
            }
        }
        return projectList;
    }

}
