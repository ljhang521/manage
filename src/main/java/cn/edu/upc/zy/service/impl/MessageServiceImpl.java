package cn.edu.upc.zy.service.impl;

import cn.edu.upc.manage.dao.ViewMessageStateMapper;
import cn.edu.upc.manage.model.ViewMessageState;
import cn.edu.upc.zy.service.MessageService;
import cn.edu.upc.manage.dao.MessageMapper;
import cn.edu.upc.manage.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("messageService")
public class MessageServiceImpl implements MessageService {
    @Autowired
    ViewMessageStateMapper viewMessageStateMapper;
    @Resource
    private MessageMapper messageMapper;
    @Override
    public void insertMessage(Message message) {
        message.setOperator("test");
        messageMapper.insertSelective(message);
    }

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
