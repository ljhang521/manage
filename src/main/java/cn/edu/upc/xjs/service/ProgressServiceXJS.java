package cn.edu.upc.xjs.service;


import cn.edu.upc.manage.model.Progress;
import cn.edu.upc.manage.model.ViewGroupUser;
import cn.edu.upc.manage.model.ViewGroupUserGrouser;

import javax.swing.text.View;
import java.util.List;

public interface ProgressServiceXJS {
    /**
     * 获取小组及人员设定
     *
     * @param projectId
     * @return
     */


    List<Progress> selectProgress(Progress projectId);
    /**
     * 获取小组列表人员显示
     *
     * @param projectId
     * @return
     */

    /**
     * 新增项目进度
     *
     * @param progress
     */
    void insertProgress(Progress progress);

    /**
     * 修改项目内容
     *
     * @param change
     * @return
     */
    int updateDel(Progress change);

    /**
     * 根据id获取项目进度
     *
     * @return
     */
    List<Progress> select();

    /**
     * 删除项目进度
     *
     * @param delete
     * @return
     */
    int updateDelete(Progress delete);
}
