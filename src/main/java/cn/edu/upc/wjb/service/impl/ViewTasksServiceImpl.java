package cn.edu.upc.wjb.service.impl;

import cn.edu.upc.manage.dao.ViewTasksMapper;
import cn.edu.upc.manage.model.ViewTasks;
import cn.edu.upc.wjb.service.ViewTasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViewTasksServiceImpl implements ViewTasksService {
    @Autowired
    ViewTasksMapper viewTasksMapper;

    @Override
    public List<ViewTasks> getTasksList() {
        List<ViewTasks> list = viewTasksMapper.getTasksList();
        return list;
    }
}
