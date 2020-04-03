package cn.edu.upc.manage.model;

import java.util.Date;

public class WorkPlace {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column work_place.id
     *
     * @mbg.generated Tue Mar 31 11:23:10 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column work_place.work_place
     *
     * @mbg.generated Tue Mar 31 11:23:10 CST 2020
     */
    private String workPlace;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column work_place.creat_time
     *
     * @mbg.generated Tue Mar 31 11:23:10 CST 2020
     */
    private Date creatTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column work_place.del_flag
     *
     * @mbg.generated Tue Mar 31 11:23:10 CST 2020
     */
    private Integer delFlag;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column work_place.operator
     *
     * @mbg.generated Tue Mar 31 11:23:10 CST 2020
     */
    private String operator;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column work_place.operator_ip
     *
     * @mbg.generated Tue Mar 31 11:23:10 CST 2020
     */
    private String operatorIp;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column work_place.operator_time
     *
     * @mbg.generated Tue Mar 31 11:23:10 CST 2020
     */
    private Date operatorTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column work_place.id
     *
     * @return the value of work_place.id
     *
     * @mbg.generated Tue Mar 31 11:23:10 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column work_place.id
     *
     * @param id the value for work_place.id
     *
     * @mbg.generated Tue Mar 31 11:23:10 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column work_place.work_place
     *
     * @return the value of work_place.work_place
     *
     * @mbg.generated Tue Mar 31 11:23:10 CST 2020
     */
    public String getWorkPlace() {
        return workPlace;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column work_place.work_place
     *
     * @param workPlace the value for work_place.work_place
     *
     * @mbg.generated Tue Mar 31 11:23:10 CST 2020
     */
    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace == null ? null : workPlace.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column work_place.creat_time
     *
     * @return the value of work_place.creat_time
     *
     * @mbg.generated Tue Mar 31 11:23:10 CST 2020
     */
    public Date getCreatTime() {
        return creatTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column work_place.creat_time
     *
     * @param creatTime the value for work_place.creat_time
     *
     * @mbg.generated Tue Mar 31 11:23:10 CST 2020
     */
    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column work_place.del_flag
     *
     * @return the value of work_place.del_flag
     *
     * @mbg.generated Tue Mar 31 11:23:10 CST 2020
     */
    public Integer getDelFlag() {
        return delFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column work_place.del_flag
     *
     * @param delFlag the value for work_place.del_flag
     *
     * @mbg.generated Tue Mar 31 11:23:10 CST 2020
     */
    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column work_place.operator
     *
     * @return the value of work_place.operator
     *
     * @mbg.generated Tue Mar 31 11:23:10 CST 2020
     */
    public String getOperator() {
        return operator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column work_place.operator
     *
     * @param operator the value for work_place.operator
     *
     * @mbg.generated Tue Mar 31 11:23:10 CST 2020
     */
    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column work_place.operator_ip
     *
     * @return the value of work_place.operator_ip
     *
     * @mbg.generated Tue Mar 31 11:23:10 CST 2020
     */
    public String getOperatorIp() {
        return operatorIp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column work_place.operator_ip
     *
     * @param operatorIp the value for work_place.operator_ip
     *
     * @mbg.generated Tue Mar 31 11:23:10 CST 2020
     */
    public void setOperatorIp(String operatorIp) {
        this.operatorIp = operatorIp == null ? null : operatorIp.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column work_place.operator_time
     *
     * @return the value of work_place.operator_time
     *
     * @mbg.generated Tue Mar 31 11:23:10 CST 2020
     */
    public Date getOperatorTime() {
        return operatorTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column work_place.operator_time
     *
     * @param operatorTime the value for work_place.operator_time
     *
     * @mbg.generated Tue Mar 31 11:23:10 CST 2020
     */
    public void setOperatorTime(Date operatorTime) {
        this.operatorTime = operatorTime;
    }
}