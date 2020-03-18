package cn.edu.upc.manage.dao;

import cn.edu.upc.manage.model.Progress;

import java.util.List;

public interface ProgressMapper {
    /**
     * 选取某项目下所有小组
     *
     * @param projectId
     * @return
     */
    List<Progress> selectProgressList(Integer projectId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table progress
     *
     * @mbg.generated Fri Mar 13 09:07:48 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table progress
     *
     * @mbg.generated Fri Mar 13 09:07:48 CST 2020
     */
    int insert(Progress record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table progress
     *
     * @mbg.generated Fri Mar 13 09:07:48 CST 2020
     */
    int insertSelective(Progress record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table progress
     *
     * @mbg.generated Fri Mar 13 09:07:48 CST 2020
     */
    Progress selectByPrimaryKey(Integer id);

    List<Progress> selectByProjectId(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table progress
     *
     * @mbg.generated Fri Mar 13 09:07:48 CST 2020
     */
    int updateByPrimaryKeySelective(Progress record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table progress
     *
     * @mbg.generated Fri Mar 13 09:07:48 CST 2020
     */
    int updateByPrimaryKey(Progress record);
}