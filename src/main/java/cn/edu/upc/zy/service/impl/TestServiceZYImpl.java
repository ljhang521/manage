package cn.edu.upc.zy.service.impl;

import cn.edu.upc.manage.dao.MessageMapper;
import cn.edu.upc.manage.dao.ViewMessageStateMapper;
import cn.edu.upc.manage.model.Message;
import cn.edu.upc.manage.model.ViewMessageState;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TestServiceZYImpl implements TestServiceZY{
    @Autowired
    ViewMessageStateMapper viewMessageStateMapper;
    @Autowired
    MessageMapper messageMapper;
    @Override
    public List<ViewMessageState> getMessageList(Integer id) {
        List<ViewMessageState> list = viewMessageStateMapper.getMessageList(id);
        return list;
    }

    @Override
    public void updateReader(int id, int uid) {
        Message result = messageMapper.selectByPrimaryKey(id);
        if (result != null){
            Message message = new Message();
            message.setId(id);
            message.setReader(result.getReader()+uid+',');
            messageMapper.updateByPrimaryKeySelective(message);
        }

    }
}
