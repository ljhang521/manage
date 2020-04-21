package cn.edu.upc.zy.service;

import cn.edu.upc.manage.model.*;

import java.util.List;
import java.util.Map;

public interface MessageService {
    public  void insertMessage(Message message);
    List<ViewMessageState> getMessageList(ViewMessageState message);
    List<ViewMessageState> getMessageList(int id);
    void updateReader(ViewMessageState message);
    List<Project> getProjectList();
    List<GroupEx> getGroupList();
    List<User> getUserList();
}
