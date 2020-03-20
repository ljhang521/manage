package cn.edu.upc.zy.service.impl;

import cn.edu.upc.manage.model.ViewMessageState;

import java.util.List;

public interface TestServiceZY {
    List<ViewMessageState> getMessageList(Integer id);
    void updateReader(int id, int uid);
}
