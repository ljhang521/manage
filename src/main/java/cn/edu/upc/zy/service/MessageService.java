package cn.edu.upc.zy.service;

import cn.edu.upc.manage.model.Message;
import cn.edu.upc.manage.model.ViewMessageState;

import java.util.List;

public interface MessageService {
    public  void insertMessage(Message message);
    List<ViewMessageState> getMessageList(Integer id);
    void updateReader(int id, int uid);
}
