package cn.edu.upc.manage.dao;

import cn.edu.upc.manage.model.Progress;

import java.util.List;

public interface ProgressMapper {
    /*点击项目名查看项目进度*/
    List<Progress> selectProgress(Progress projectId);
    /* 查看progress表中所有内容 */
    List<Progress> selectByPrimaryKey();
    /* 删除项目进度——确认按钮，做update操作，del_flag赋值为它的id值 */
    int  updateDelete(Progress delete);
    /*  修改项目进度——焦点聚焦及失去onChange输入*/
    int updateByPrimaryKeySelect(Progress change);
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