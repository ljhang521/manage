package cn.edu.upc.wwp.service.impl;

import cn.edu.upc.manage.dao.WorkPlaceMapper;
import cn.edu.upc.manage.model.WorkPlace;
import cn.edu.upc.wwp.service.WorkPlaceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service("workPlaceService")
public class WorkPlaceServiceImpl implements WorkPlaceService {
    @Resource
    WorkPlaceMapper workPlaceMapper;

    @Override
    public List<WorkPlace> selectWorkPlace() {
        return workPlaceMapper.selectWorkPlace();
    }

    @Override
    public void updateWorkPlace(WorkPlace recordUp) {
        recordUp.setOperator("test");
        workPlaceMapper.updateByPrimaryKeySelective(recordUp);
    }

    @Override
    public void insertsWorkPlace(WorkPlace recordIn) {
        recordIn.setOperator("test");
        workPlaceMapper.insertSelective(recordIn);
    }

    @Override
    public void deleteFlag(WorkPlace recordDel) {
        WorkPlace result = workPlaceMapper.selectByPrimaryKey(recordDel.getId());
        if (result!= null){
            recordDel.setDelFlag(1);
            workPlaceMapper.updateByPrimaryKeySelective(recordDel);

        }
    }
}
