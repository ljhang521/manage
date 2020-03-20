package cn.edu.upc.zy.service.impl;

import cn.edu.upc.zy.service.MessageServiceZY;
import cn.edu.upc.manage.dao.MessageMapper;
import cn.edu.upc.manage.model.Message;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service("messageServiceZY")
public class MessageServiceZYImpl implements MessageServiceZY {
    @Resource
    private MessageMapper messageMapper;
    @Override
    public void insertMessage(Message message) {
        message.setOperator("test");
        messageMapper.insertSelective(message);
    }
}
