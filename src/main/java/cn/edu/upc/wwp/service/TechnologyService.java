package cn.edu.upc.wwp.service;

import cn.edu.upc.manage.model.Technology;
import cn.edu.upc.wwp.controller.param.TechnologyParam;

import java.util.List;

public interface TechnologyService {

   public List<TechnologyParam> selectTechnology();

   public void updateTechnology(TechnologyParam upTechnologyParam);
    public void insertTechnology(TechnologyParam upTechnologyParam);
   public void deleteFlag(Technology deleteRecord);
}
