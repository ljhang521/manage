package cn.edu.upc.manage.model;

import java.util.List;

/**
 * 项目小组
 *
 * @author zhenwei
 * @date 2020/3/13
 */
public class GroupExNew {

    private Integer id;
    private Integer projectId;
    private String groupName;
    private List<GroupUserNew> memberList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<GroupUserNew> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<GroupUserNew> memberList) {
        this.memberList = memberList;
    }
}
