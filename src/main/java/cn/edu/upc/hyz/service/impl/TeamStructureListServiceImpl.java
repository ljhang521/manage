package cn.edu.upc.hyz.service.impl;


import cn.edu.upc.hyz.service.TeamStructureListService;
import cn.edu.upc.manage.dao.TechnologyMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.List;

@Service("TeamStructureListt")
public class TeamStructureListServiceImpl implements TeamStructureListService {
    @Resource
    TechnologyMapper technologyMapper;
    @Override
    public List<LinkedHashMap<String, Object>> selectTeamStructureListTechnology() {
        return technologyMapper.selectTeamStructureListTechnology();
    }
    public List<LinkedHashMap<String, Object>> selectTeamStructureListTechnologyTest() {
        return technologyMapper.selectTeamStructureListTechnologyTest();
    }
    public List<LinkedHashMap<String, Object>> selectTeamStructureListTechnologySecond(int technologyId){
        return technologyMapper.selectTeamStructureListTechnologySecond(technologyId);
    }
    public List<LinkedHashMap<String, Object>> selectTeamStructureListUser(int technologyIdSecond){
        return technologyMapper.selectTeamStructureListUser(technologyIdSecond);
    }
}
