package cn.edu.upc.wwp.service;

import cn.edu.upc.manage.model.Manage;

import java.util.List;


public interface ManageService {
    public List<Manage > selectTechnology();
    public void updateTechnology(Manage record);
    public void insertTechnology(Manage record);
    public void deleteTechnology(Integer id);
}
