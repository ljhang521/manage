package cn.edu.upc.xjs.Service;


import cn.edu.upc.manage.dao.MessageMapper;
import cn.edu.upc.manage.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("messageService5")
   public class MessageServiceXJSImpl implements MessageServiceXJS {
        @Autowired
        private MessageMapper messageMapper;

        @Override
        public void insertMessage(Message message) {

            messageMapper.insertSelective(message);
        }
    }
