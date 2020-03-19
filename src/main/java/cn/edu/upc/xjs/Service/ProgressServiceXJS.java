package cn.edu.upc.xjs.Service;


import cn.edu.upc.manage.model.Progress;

import java.util.List;

public interface ProgressServiceXJS {

      List<Progress> selectProgress(Progress projectId);
       void insertProgress(Progress progress);
         int updateDel(Progress change);
         List<Progress> select();
         Progress updateDelete(Integer id);
}
