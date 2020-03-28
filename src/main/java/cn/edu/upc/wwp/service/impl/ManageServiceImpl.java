package cn.edu.upc.wwp.service.impl;

import cn.edu.upc.manage.dao.ManageMapper;
import cn.edu.upc.manage.model.Manage;
import cn.edu.upc.wwp.service.ManageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service("manageService")
public class ManageServiceImpl implements ManageService {
    @Resource
    ManageMapper manageMapper;

    @Override
    public List<Manage> selectTechnology() {
        return manageMapper.manageSelect();
    }


    @Override
    public void updateTechnology(Manage record) {
        record.setOperator("test");
        manageMapper. updateByPrimaryKeySelective(record);
    }

    @Override
    public void insertTechnology(Manage record) {
        manageMapper.insert(record);
    }

    @Override
    public void deleteFlag(Manage manage) {
        Manage result = manageMapper.selectByPrimaryKey(manage.getId());
        if (result!= null){
            manage.setDelFlag(1);
            manageMapper.updateByPrimaryKeySelective(manage);
        }
    }




}
