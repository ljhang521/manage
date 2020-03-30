package cn.edu.upc.wwp.service;

import cn.edu.upc.manage.model.Technology;
import cn.edu.upc.wwp.controller.param.TechnologyParam;

import java.util.List;

public interface TechnologyService {

   public List<Technology> selectTechnology();

   public void updateTechnology(Technology upTechnologyParam);
    public void insertTechnology(Technology upTechnologyParam);
   public void deleteFlag(Technology deleteRecord);
}
