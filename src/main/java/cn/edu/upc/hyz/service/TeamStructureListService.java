package cn.edu.upc.hyz.service;

import java.util.LinkedHashMap;
import java.util.List;

public interface TeamStructureListService {
    public List<LinkedHashMap<String, Object>> selectTeamStructureListTechnology();
    public List<LinkedHashMap<String, Object>> selectTeamStructureListUser(int technologyIdSecond);
}
