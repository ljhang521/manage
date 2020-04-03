package cn.edu.upc.gsl.service.impl;

import cn.edu.upc.gsl.service.WorkPlaceService;
import cn.edu.upc.manage.dao.WorkPlaceMapper;
import cn.edu.upc.manage.model.WorkPlace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("workPlace")
public class WorkPlaceServiceImpl implements WorkPlaceService {
    @Autowired
    WorkPlaceMapper workPlaceMapper;
    @Override
    public List<WorkPlace> workPlaceList() {
        return workPlaceMapper.selectWorkPlaceList();
    }
}
