package cn.edu.upc.manage.model;

import java.util.List;

/**
 * 项目相关所有数据
 *
 * @author zhenwei
 * @date 2020/3/13
 */
public class ProjectDetail {

    private List<Progress> progressList;
    private ProjectNew projectInfo;
    private List<GroupExNew> groupList;

    public List<Progress> getProgressList() {
        return progressList;
    }

    public void setProgressList(List<Progress> progressList) {
        this.progressList = progressList;
    }

    public ProjectNew getProjectInfo() {
        return projectInfo;
    }

    public void setProjectInfo(ProjectNew projectInfo) {
        this.projectInfo = projectInfo;
    }

    public List<GroupExNew> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<GroupExNew> groupList) {
        this.groupList = groupList;
    }
}
