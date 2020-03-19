package cn.edu.upc.whn.service.impl;

import cn.edu.upc.manage.dao.ViewMessageStateMapper;
import cn.edu.upc.manage.model.ViewMessageState;
import cn.edu.upc.whn.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {
    @Autowired
    ViewMessageStateMapper viewMessageStateMapper;

    @Override
    public List<ViewMessageState> getMessageList(Integer id) {
        List<ViewMessageState> list = viewMessageStateMapper.getMessageList(id);
        return list;
    }
}
