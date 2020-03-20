package cn.edu.upc.wjw.service.impl;

import cn.edu.upc.manage.dao.RightsMapper;
import cn.edu.upc.manage.model.Rights;
import cn.edu.upc.wjw.service.RightService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("rightServiceImpl")
public class RightServiceImpl implements RightService {
    @Resource
    public RightsMapper rightMapper;

    @Override
    public void insertRight(Rights rights) {
        rights.setOperator("test");
        rightMapper.insertSelective(rights);
    }


//    @Resource
//    private RightsMapper rightDao;
//    public Rights selectRight(Integer id) {
//        return rightDao.selectRight(id);
//    }


    @Override
    public void deleteRight(Rights rights){
        rightMapper.setdelFrag(rights);

    }

    @Override
    public void updateRight(Rights rights) {
        rightMapper.updateByPrimaryKeySelective(rights);
    }

    @Override
    public List<Rights> selectAllRights() {
        return rightMapper.selectAllRights();
    }
}
