package cn.edu.upc.zy.service.impl;

import cn.edu.upc.manage.dao.MessageMapper;
import cn.edu.upc.manage.dao.ViewMessageStateMapper;
import cn.edu.upc.manage.model.Message;
import cn.edu.upc.manage.model.ViewMessageState;
import cn.edu.upc.zy.service.MessageService;
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
    public List<ViewMessageState> getMessageList(ViewMessageState message){
        List<ViewMessageState> list = viewMessageStateMapper.getMessageList(message.getId());
        return list;
    }

    @Override
    public void updateReader(ViewMessageState message) {
        Message result = messageMapper.selectByPrimaryKey(message.getId());
        if (result != null){
            Message message1 = new Message();
           message1.setId(message1.getId());
         message1.setReader(result.getReader()+ message.getUserId()+',');
            messageMapper.updateByPrimaryKeySelective(message1);
        }

    }
}
