package cn.edu.upc.wwp.service.impl;

import cn.edu.upc.manage.dao.AreaMapper;
import cn.edu.upc.manage.model.Area;
import cn.edu.upc.wwp.service.AreaService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("areaService")
public class AreaServiceImpl implements AreaService {
    @Resource
    AreaMapper areaMapper;


    @Override
    public List<Area> selectArea() {
        return areaMapper.select();
    }

    @Override
    public void updateArea(Area record) {
        areaMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public void insertArea(Area record) {
        record.setOperator("test");
        areaMapper.insertSelective(record);

    }

    @Override
    public void deleteFlag(Area area) {
        Area result = areaMapper.selectByPrimaryKey( area.getId());
        if (result!= null){
            area.setDelFlag(1);
            areaMapper.updateByPrimaryKeySelective(area);
        }
    }


}
