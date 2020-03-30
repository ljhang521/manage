package cn.edu.upc.wwp.service.impl;

import cn.edu.upc.manage.dao.TechnologyMapper;
import cn.edu.upc.manage.model.Technology;
import cn.edu.upc.wwp.controller.param.TechnologyParam;
import cn.edu.upc.wwp.service.TechnologyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service("technologyService")
public class TechnologyServiceImpl implements TechnologyService {
    @Resource
    TechnologyMapper technologyMapper;
    @Override
    public List<TechnologyParam> selectTechnology() {
//        List<TechnologyParam> technologyParamList=new ArrayList<TechnologyParam>();
//        TechnologyParam technologyParam=new TechnologyParam();
//        List<Technology> result = technologyMapper.technologySelect();
//        Map<Integer,String> listMap=new HashMap<Integer,String>();
//        for (Technology res :result)
//        {
//            listMap.put(res.getId(),res.getTechnologyName());
//        }
//        for (Technology res:result) {
//            technologyParam.setId(res.getId());
//            technologyParam.setTelName(res.getTechnologyName());
//            technologyParam.setPid(listMap.get(res.getId()));
//            technologyParamList.add(technologyParam);
//        }

        return technologyMapper.technologySelectParam();
    }

    @Override
    public void updateTechnology(TechnologyParam upTechnologyParam) {
            List<Technology> result=technologyMapper.technologySelect();
            Map<String,Integer> listMap=new HashMap<String,Integer>();
            for (Technology res :result)
            {
                listMap.put(res.getTechnologyName(),res.getId());
            }
        Technology updateRecord=new Technology();
        updateRecord.setId(upTechnologyParam.getId());
        updateRecord.setTechnologyName(upTechnologyParam.getTelName());
        updateRecord.setpId(listMap.get(upTechnologyParam.getPid()));
        updateRecord.setOperator("test");
        technologyMapper.updateByPrimaryKeySelective(updateRecord);
    }

    @Override
    public void insertTechnology(TechnologyParam inTechnologyParam) {
        List<Technology> result = technologyMapper.technologySelect();
        Map<String,Integer> listMap=new HashMap<String,Integer>();
        for (Technology res :result)
        {
            listMap.put(res.getTechnologyName(),res.getId());
        }
        Technology insertRecord=new Technology();
        insertRecord.setTechnologyName(inTechnologyParam.getTelName());
        insertRecord.setpId(listMap.get(inTechnologyParam.getPid()));
        insertRecord.setOperator("test");
        technologyMapper.insertSelective(insertRecord);


    }

    @Override
    public void deleteFlag(Technology deleteRecord) {
       Technology result = technologyMapper.selectByPrimaryKey(deleteRecord.getId());
        if (result!= null){
            deleteRecord.setDelFlag(1);
            technologyMapper.updateByPrimaryKeySelective(deleteRecord);

        }
    }
}
