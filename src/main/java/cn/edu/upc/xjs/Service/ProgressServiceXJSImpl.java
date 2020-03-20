package cn.edu.upc.xjs.Service;


import cn.edu.upc.manage.dao.ProgressMapper;
import cn.edu.upc.manage.model.Progress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("progressServiceXJS")
public class ProgressServiceXJSImpl implements ProgressServiceXJS {
    @Autowired
     private ProgressMapper progressMapper;
      @Override
    public List<Progress> selectProgress(Progress projectId){

          return progressMapper.selectProgress(projectId);
    };
    @Autowired
    private ProgressMapper proMapper;

    @Override
    public void insertProgress(Progress progress) {

       proMapper.insertSelective(progress);
    }
    @Autowired
    private ProgressMapper updateMapper;
   @Override
     public int updateDel(Progress change) {
        return updateMapper.updateByPrimaryKeySelect(change);
    };
@Autowired
    private  ProgressMapper selectMapper;
   @Override
   public  List<Progress> select(){
       return selectMapper.selectByPrimaryKey();
    }
    @Autowired
    private ProgressMapper deleteMapper;
     @Override
    public int updateDelete(Progress delete){

         return deleteMapper.updateDelete(delete);
     }
}
