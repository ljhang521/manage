package cn.edu.upc.wjb.service;

import cn.edu.upc.manage.model.ViewTasks;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface ViewTasksService {
    List<ViewTasks> getTasksList(HttpSession session);
}
