package cn.edu.upc.wwp.service;

import cn.edu.upc.manage.model.WorkPlace;

import java.util.List;

public interface WorkPlaceService {

    public List<WorkPlace> selectWorkPlace();
    public void updateWorkPlace(WorkPlace recordUp);
    public void insertsWorkPlace(WorkPlace recordIn);
    public void deleteFlag(WorkPlace recordDel);
}
