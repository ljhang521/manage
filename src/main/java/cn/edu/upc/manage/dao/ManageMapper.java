package cn.edu.upc.manage.dao;

import cn.edu.upc.manage.model.Manage;

import java.util.List;

public interface ManageMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manage
     *
     * @mbg.generated Fri Mar 13 21:18:29 CST 2020
     */
    int deleteByPrimaryKey(Integer id);
    List<Manage> manageSelect();
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manage
     *
     * @mbg.generated Fri Mar 13 21:18:29 CST 2020
     */
    int insert(Manage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manage
     *
     * @mbg.generated Fri Mar 13 21:18:29 CST 2020
     */
    int insertSelective(Manage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manage
     *
     * @mbg.generated Fri Mar 13 21:18:29 CST 2020
     */
    Manage selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manage
     *
     * @mbg.generated Fri Mar 13 21:18:29 CST 2020
     */
    int updateByPrimaryKeySelective(Manage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manage
     *
     * @mbg.generated Fri Mar 13 21:18:29 CST 2020
     */
    int updateByPrimaryKey(Manage record);
}