package cn.edu.upc.ljh.service.impl;

import cn.edu.upc.manage.dao.MessageMapper;
import cn.edu.upc.manage.model.Message;
import cn.edu.upc.ljh.service.MessageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("messageService")
public class MessageServiceImpl implements MessageService {
    @Resource
    private MessageMapper messageMapper;
    @Override
    public void insertMessage(Message message) {
        message.setOperator("test");
        messageMapper.insertSelective(message);
    }
}
