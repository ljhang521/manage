package cn.edu.upc.wwp.service;

import cn.edu.upc.manage.model.Area;

import java.util.List;

public interface AreaService {

    public List<Area> selectArea();
    public void updateArea(Area record);
    public void insertArea(Area record);
    public void deleteFlag(Area area);
}
