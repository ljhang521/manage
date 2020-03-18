package cn.edu.upc.manage.dao;

import cn.edu.upc.manage.model.GroupUser;

import java.util.List;

public interface GroupUserMapper {
    /**
     * 选取小组成员
     *
     * @param groupId
     * @return
     */
    List<GroupUser> selectGroupUser(Integer groupId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group_user
     *
     * @mbg.generated Tue Mar 17 22:10:51 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group_user
     *
     * @mbg.generated Tue Mar 17 22:10:51 CST 2020
     */
    int insert(GroupUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group_user
     *
     * @mbg.generated Tue Mar 17 22:10:51 CST 2020
     */
    int insertSelective(GroupUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group_user
     *
     * @mbg.generated Tue Mar 17 22:10:51 CST 2020
     */
    GroupUser selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group_user
     *
     * @mbg.generated Tue Mar 17 22:10:51 CST 2020
     */
    int updateByPrimaryKeySelective(GroupUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group_user
     *
     * @mbg.generated Tue Mar 17 22:10:51 CST 2020
     */
    int updateByPrimaryKey(GroupUser record);
}