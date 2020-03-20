package cn.edu.upc.xjs.service;


import cn.edu.upc.manage.model.Progress;

import java.util.List;

public interface ProgressServiceXJS {

      List<Progress> selectProgress(Progress projectId);
    /*新增项目进度*/
      void insertProgress(Progress progress);
    /*修改项目内容*/
         int updateDel(Progress change);
    /*根据id获取项目进度*/
         List<Progress> select();
    /*删除项目进度*/
         int updateDelete(Progress delete);
}
