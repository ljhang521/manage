package cn.edu.upc.dzw.service.impl;

import cn.edu.upc.dzw.service.ProjectServiceDZW;
import cn.edu.upc.manage.dao.*;
import cn.edu.upc.manage.model.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zhenwei
 * @date 2020/3/12
 */
@Service("projectService1")
public class ProjectServiceDZWImpl implements ProjectServiceDZW {

    @Resource
    private ProjectMapper projectMapper;
    @Resource
    private WorkPlaceMapper workPlaceMapper;
    @Resource
    private UserMapper userMapper;
    @Resource
    private ProgressMapper progressMapper;
    @Resource
    private GroupExMapper groupExMapper;
    @Resource
    private GroupUserMapper groupUserMapper;
    @Resource
    private ViewProjectMapper viewProjectMapper;
    @Resource
    private ViewGroupUserMapper viewGroupUserMapper;

    @Resource
    private ViewUserMapper viewUserMapper;

    @Override
    public List<Project> getProjectList() {
        return projectMapper.getProjectList();
    }

    @Override
    public List<ProjectNew> getProjectListNew() {
        List<Project> projectList = getProjectList();
        List<ProjectNew> projectNewList = new ArrayList<>();
        for (int i = 0; i < projectList.size(); i++) {
            String workPlaceName = "";
            if (projectList.get(i).getPlace() != null && workPlaceMapper.selectByPrimaryKey(projectList.get(i).getPlace()) != null) {
                workPlaceName = workPlaceMapper.selectByPrimaryKey(projectList.get(i).getPlace()).getWorkPlace();
            }
            String leaderName = "";
            if (projectList.get(i).getLeader() != null && userMapper.selectByPrimaryKey(projectList.get(i).getLeader()) != null) {
                leaderName = userMapper.selectByPrimaryKey(projectList.get(i).getLeader()).getRealName();
            }
            String managerName = "";
            if (projectList.get(i).getManager() != null && userMapper.selectByPrimaryKey(projectList.get(i).getManager()) != null) {
                managerName = userMapper.selectByPrimaryKey(projectList.get(i).getManager()).getRealName();
            }

            ProjectNew projectNew = new ProjectNew();
            projectNew.setId(projectList.get(i).getId());
            projectNew.setProjectName(projectList.get(i).getProjectName());
            projectNew.setLeader(projectList.get(i).getLeader());
            projectNew.setLeaderName(leaderName);
            projectNew.setManager(projectList.get(i).getManager());
            projectNew.setManagerName(managerName);
            projectNew.setPlace(projectList.get(i).getPlace());
            projectNew.setPlaceName(workPlaceName);
            projectNew.setBeginTime(projectList.get(i).getBeginTime());
            projectNew.setEndTime(projectList.get(i).getEndTime());
            projectNew.setCreateTime(projectList.get(i).getCreateTime());
            projectNew.setDelFlag(projectList.get(i).getDelFlag());
            projectNew.setRemark(projectList.get(i).getRemark());
            projectNew.setOperator(projectList.get(i).getOperator());
            projectNew.setOperatorIp(projectList.get(i).getOperatorIp());
            projectNew.setOperatorTime(projectList.get(i).getOperatorTime());
            projectNewList.add(projectNew);
        }
        return projectNewList;
    }

    @Override
    public List<ViewProject> getViewProjectList() {
        return viewProjectMapper.getViewProjectList();
    }

    @Override
    public int addProject(Project project) {
        Date date = new Date();
        project.setCreateTime(date);
        project.setDelFlag(0);
        project.setOperator("");
        project.setOperatorIp("");
        project.setOperatorTime(date);
        return projectMapper.addProject(project);
    }

    @Override
    public Project getProject(Integer id) {
        return projectMapper.selectByPrimaryKey(id);
    }

    @Override
    public ProjectNew getProjectNew(Integer id) {
        return ProjectToProjectNew(projectMapper.selectByPrimaryKey(id));
    }

    @Override
    public ViewProject getViewProject(Integer id) {
        return viewProjectMapper.selectByPrimaryKey(id);
    }

    @Override
    public int changeProject(Project project) {
        Date date = new Date();
        project.setOperator("");
        project.setOperatorIp("");
        project.setOperatorTime(date);
        return projectMapper.updateByPrimaryKeySelective(project);
    }

    @Override
    public int deleteProject(Project project) {
        Date date = new Date();
        project.setDelFlag(project.getId());
        project.setOperator("");
        project.setOperatorIp("");
        project.setOperatorTime(date);
        return projectMapper.deleteProject(project);
    }

    @Override
    public ProjectDetail getProjectDetail(Integer id) {
        ProjectDetail projectDetail = new ProjectDetail();

//        Project project = projectMapper.selectByPrimaryKey(id);
//        ProjectNew projectNew = ProjectToProjectNew(project);
        ViewProject project = viewProjectMapper.selectByPrimaryKey(id);

        List<Progress> progressList = progressMapper.selectProgressList(id);

//        List<GroupExNew> groupExNewList = new ArrayList<>();
//        List<GroupEx> groupExList = groupExMapper.selectGroup(id);
//        for (int i = 0; i < groupExList.size(); i++) {
//            GroupExNew groupExNew = new GroupExNew();
//
//            groupExNew.setId(groupExList.get(i).getId());
//            groupExNew.setProjectId(groupExList.get(i).getProjectId());
//            groupExNew.setGroupName(groupExList.get(i).getGroupName());
//
//            List<GroupUser> groupUserList = new ArrayList<>();
//            List<GroupUserNew> groupUserNewList = new ArrayList<>();
//            if (groupExList.get(i).getId() != null) {
//                groupUserList = groupUserMapper.selectGroupUser(groupExList.get(i).getId());
//            }
//            for (int j = 0; j < groupUserList.size(); j++) {
//                GroupUserNew groupUserNew = new GroupUserNew();
//                groupUserNew.setId(groupUserList.get(j).getId());
//                groupUserNew.setGroupId(groupUserList.get(j).getGroupId());
//                groupUserNew.setUserId(groupUserList.get(j).getUserId());
//                if (groupUserList.get(j).getUserId() != null && userMapper.selectByPrimaryKey(groupUserList.get(j).getUserId()) != null) {
//                    groupUserNew.setUserName(userMapper.selectByPrimaryKey(groupUserList.get(j).getUserId()).getRealName());
//                } else {
//                    groupUserNew.setUserName("");
//                }
//                groupUserNew.setUserType(groupUserList.get(j).getUserType());
//                groupUserNew.setContent(groupUserList.get(j).getContent());
//                groupUserNew.setDelFlag(groupUserList.get(j).getDelFlag());
//                groupUserNew.setOperator(groupUserList.get(j).getOperator());
//                groupUserNew.setOperatorIp(groupUserList.get(j).getOperatorIp());
//                groupUserNew.setOperatorTime(groupUserList.get(j).getOperatorTime());
//
//                groupUserNewList.add(groupUserNew);
//            }
//            groupExNew.setMemberList(groupUserNewList);
//
//            groupExNewList.add(groupExNew);
//        }
        List<ViewGroupUser> groupUserList = viewGroupUserMapper.selectByPrimaryKey(id);
        List<ViewGroupUserNew> groupUserNewList = new ArrayList<>();

        for (int i = 0; i < groupUserList.size(); i++) {
            ViewGroupUserNew viewGroupUserNew = viewGroupUserMapper.getProjectDetail(groupUserList.get(i).getProjectId(),
                    groupUserList.get(i).getGroupId(), groupUserList.get(i).getUserId());
            groupUserNewList.add(viewGroupUserNew);
        }

        projectDetail.setProgressList(progressList);
        projectDetail.setProjectInfo(project);
        projectDetail.setGroupList(groupUserNewList);
        return projectDetail;
    }

    private ProjectNew ProjectToProjectNew(Project project) {
        String workPlaceName = "";
        if (project.getPlace() != null && workPlaceMapper.selectByPrimaryKey(project.getPlace()) != null) {
            workPlaceName = workPlaceMapper.selectByPrimaryKey(project.getPlace()).getWorkPlace();
        }
        String leaderName = "";
        if (project.getLeader() != null && userMapper.selectByPrimaryKey(project.getLeader()) != null) {
            leaderName = userMapper.selectByPrimaryKey(project.getLeader()).getRealName();
        }
        String managerName = "";
        if (project.getManager() != null && userMapper.selectByPrimaryKey(project.getManager()) != null) {
            managerName = userMapper.selectByPrimaryKey(project.getManager()).getRealName();
        }

        ProjectNew projectNew = new ProjectNew();
        projectNew.setId(project.getId());
        projectNew.setProjectName(project.getProjectName());
        projectNew.setLeader(project.getLeader());
        projectNew.setLeaderName(leaderName);
        projectNew.setManager(project.getManager());
        projectNew.setManagerName(managerName);
        projectNew.setPlace(project.getPlace());
        projectNew.setPlaceName(workPlaceName);
        projectNew.setBeginTime(project.getBeginTime());
        projectNew.setEndTime(project.getEndTime());
        projectNew.setCreateTime(project.getCreateTime());
        projectNew.setDelFlag(project.getDelFlag());
        projectNew.setRemark(project.getRemark());
        projectNew.setOperator(project.getOperator());
        projectNew.setOperatorIp(project.getOperatorIp());
        projectNew.setOperatorTime(project.getOperatorTime());

        return projectNew;
    }


    @Override
    public List<ViewUserProject> getPersonList(Integer groupId) {
        return viewUserMapper.getPersonList(groupId);
    }

    @Override
    public void setPerson(GroupUser groupUser) {
        //之前没有数据时，id可为null，有数据时id要对应
        //userType、userId、groupId不设null
        //增：id为空&userId、groupId不重
        //删：userType不为0和1

        //之前没有数据
        if (groupUserMapper.selectByGroupId(groupUser).size() == 0) {
            //勾选
            if (groupUser.getUserType() == 0 || groupUser.getUserType() == 1) {
                groupUserMapper.insertSelective(groupUser);
            } else {
                //不勾选无操作
            }
        } else {//之前有数据
            //勾选
            if (groupUser.getUserType() == 0 || groupUser.getUserType() == 1) {
                groupUser.setDelFlag(0);
            } else {//取消勾选
                groupUser.setDelFlag(groupUser.getId() == null ? 1 : groupUser.getId());
            }

            groupUserMapper.updateByPrimaryKeySelective(groupUser);
        }
    }
}
