package cn.edu.upc.whn.service;

import cn.edu.upc.manage.model.ViewMessageState;

import java.util.List;

public interface TestService {
    List<ViewMessageState> getMessageList(Integer id);
}
