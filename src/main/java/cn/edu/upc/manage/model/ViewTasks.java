package cn.edu.upc.manage.model;

import java.util.Date;

public class ViewTasks {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column view_tasks.id
     *
     * @mbg.generated Mon Mar 30 17:42:53 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column view_tasks.user_type
     *
     * @mbg.generated Mon Mar 30 17:42:53 CST 2020
     */
    private Byte userType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column view_tasks.project_id
     *
     * @mbg.generated Mon Mar 30 17:42:53 CST 2020
     */
    private Integer projectId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column view_tasks.project_name
     *
     * @mbg.generated Mon Mar 30 17:42:53 CST 2020
     */
    private String projectName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column view_tasks.leader
     *
     * @mbg.generated Mon Mar 30 17:42:53 CST 2020
     */
    private Integer leader;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column view_tasks.place
     *
     * @mbg.generated Mon Mar 30 17:42:53 CST 2020
     */
    private Integer place;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column view_tasks.begin_time
     *
     * @mbg.generated Mon Mar 30 17:42:53 CST 2020
     */
    private Date beginTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column view_tasks.end_time
     *
     * @mbg.generated Mon Mar 30 17:42:53 CST 2020
     */
    private Date endTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column view_tasks.update_time
     *
     * @mbg.generated Mon Mar 30 17:42:53 CST 2020
     */
    private Date updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column view_tasks.user_id
     *
     * @mbg.generated Mon Mar 30 17:42:53 CST 2020
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column view_tasks.group_id
     *
     * @mbg.generated Mon Mar 30 17:42:53 CST 2020
     */
    private Integer groupId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column view_tasks.group_name
     *
     * @mbg.generated Mon Mar 30 17:42:53 CST 2020
     */
    private String groupName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column view_tasks.user_name
     *
     * @mbg.generated Mon Mar 30 17:42:53 CST 2020
     */
    private String userName;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column view_tasks.id
     *
     * @return the value of view_tasks.id
     *
     * @mbg.generated Mon Mar 30 17:42:53 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column view_tasks.id
     *
     * @param id the value for view_tasks.id
     *
     * @mbg.generated Mon Mar 30 17:42:53 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column view_tasks.user_type
     *
     * @return the value of view_tasks.user_type
     *
     * @mbg.generated Mon Mar 30 17:42:53 CST 2020
     */
    public Byte getUserType() {
        return userType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column view_tasks.user_type
     *
     * @param userType the value for view_tasks.user_type
     *
     * @mbg.generated Mon Mar 30 17:42:53 CST 2020
     */
    public void setUserType(Byte userType) {
        this.userType = userType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column view_tasks.project_id
     *
     * @return the value of view_tasks.project_id
     *
     * @mbg.generated Mon Mar 30 17:42:53 CST 2020
     */
    public Integer getProjectId() {
        return projectId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column view_tasks.project_id
     *
     * @param projectId the value for view_tasks.project_id
     *
     * @mbg.generated Mon Mar 30 17:42:53 CST 2020
     */
    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column view_tasks.project_name
     *
     * @return the value of view_tasks.project_name
     *
     * @mbg.generated Mon Mar 30 17:42:53 CST 2020
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column view_tasks.project_name
     *
     * @param projectName the value for view_tasks.project_name
     *
     * @mbg.generated Mon Mar 30 17:42:53 CST 2020
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column view_tasks.leader
     *
     * @return the value of view_tasks.leader
     *
     * @mbg.generated Mon Mar 30 17:42:53 CST 2020
     */
    public Integer getLeader() {
        return leader;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column view_tasks.leader
     *
     * @param leader the value for view_tasks.leader
     *
     * @mbg.generated Mon Mar 30 17:42:53 CST 2020
     */
    public void setLeader(Integer leader) {
        this.leader = leader;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column view_tasks.place
     *
     * @return the value of view_tasks.place
     *
     * @mbg.generated Mon Mar 30 17:42:53 CST 2020
     */
    public Integer getPlace() {
        return place;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column view_tasks.place
     *
     * @param place the value for view_tasks.place
     *
     * @mbg.generated Mon Mar 30 17:42:53 CST 2020
     */
    public void setPlace(Integer place) {
        this.place = place;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column view_tasks.begin_time
     *
     * @return the value of view_tasks.begin_time
     *
     * @mbg.generated Mon Mar 30 17:42:53 CST 2020
     */
    public Date getBeginTime() {
        return beginTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column view_tasks.begin_time
     *
     * @param beginTime the value for view_tasks.begin_time
     *
     * @mbg.generated Mon Mar 30 17:42:53 CST 2020
     */
    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column view_tasks.end_time
     *
     * @return the value of view_tasks.end_time
     *
     * @mbg.generated Mon Mar 30 17:42:53 CST 2020
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column view_tasks.end_time
     *
     * @param endTime the value for view_tasks.end_time
     *
     * @mbg.generated Mon Mar 30 17:42:53 CST 2020
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column view_tasks.update_time
     *
     * @return the value of view_tasks.update_time
     *
     * @mbg.generated Mon Mar 30 17:42:53 CST 2020
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column view_tasks.update_time
     *
     * @param updateTime the value for view_tasks.update_time
     *
     * @mbg.generated Mon Mar 30 17:42:53 CST 2020
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column view_tasks.user_id
     *
     * @return the value of view_tasks.user_id
     *
     * @mbg.generated Mon Mar 30 17:42:53 CST 2020
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column view_tasks.user_id
     *
     * @param userId the value for view_tasks.user_id
     *
     * @mbg.generated Mon Mar 30 17:42:53 CST 2020
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column view_tasks.group_id
     *
     * @return the value of view_tasks.group_id
     *
     * @mbg.generated Mon Mar 30 17:42:53 CST 2020
     */
    public Integer getGroupId() {
        return groupId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column view_tasks.group_id
     *
     * @param groupId the value for view_tasks.group_id
     *
     * @mbg.generated Mon Mar 30 17:42:53 CST 2020
     */
    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column view_tasks.group_name
     *
     * @return the value of view_tasks.group_name
     *
     * @mbg.generated Mon Mar 30 17:42:53 CST 2020
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column view_tasks.group_name
     *
     * @param groupName the value for view_tasks.group_name
     *
     * @mbg.generated Mon Mar 30 17:42:53 CST 2020
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column view_tasks.user_name
     *
     * @return the value of view_tasks.user_name
     *
     * @mbg.generated Mon Mar 30 17:42:53 CST 2020
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column view_tasks.user_name
     *
     * @param userName the value for view_tasks.user_name
     *
     * @mbg.generated Mon Mar 30 17:42:53 CST 2020
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }
}