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
    private ViewProject projectInfo;
    private List<ViewGroupUser> groupList;

    public List<Progress> getProgressList() {
        return progressList;
    }

    public void setProgressList(List<Progress> progressList) {
        this.progressList = progressList;
    }

    public ViewProject getProjectInfo() {
        return projectInfo;
    }

    public void setProjectInfo(ViewProject projectInfo) {
        this.projectInfo = projectInfo;
    }

    public List<ViewGroupUser> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<ViewGroupUser> groupList) {
        this.groupList = groupList;
    }
}
