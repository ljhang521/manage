package cn.edu.upc.gsl.service;

import cn.edu.upc.manage.model.WorkPlace;

import java.util.List;

/**
 * @author gsl
 * @date 2020/3/31
 */
public interface WorkPlaceService {

    /**
     * 获取全部项目地址
     * @return
     */
    List<WorkPlace> workPlaceList();
}
