package cn.edu.upc.zy.service.impl;

import cn.edu.upc.manage.dao.*;
import cn.edu.upc.manage.model.*;
import cn.edu.upc.zy.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("messageService")
public class MessageServiceImpl implements MessageService {
    @Autowired
    ViewMessageStateMapper viewMessageStateMapper;
    @Resource
    @Autowired
    private MessageMapper messageMapper;
    @Autowired
    private ProjectMapper projectMapper;
    @Autowired
    private GroupExMapper groupExMapper;
    @Autowired
    private UserMapper userMapper;
    @Override
    public void insertMessage(Message message) {
        messageMapper.insertSelective(message);
    }

    @Override
    public List<ViewMessageState> getMessageList(ViewMessageState message){
        List<ViewMessageState> list = viewMessageStateMapper.getMessageList(message.getId());
        return list;
    }

    @Override
    public List<ViewMessageState> getMessageList(int id){
        List<ViewMessageState> list = viewMessageStateMapper.getMessageList(id);
        return list;
    }

    @Override
    public void updateReader(ViewMessageState message) {
        Message result = messageMapper.selectByPrimaryKey(message.getId());
        if (result != null){
            Message message1 = new Message();
            message1.setId(message.getId());
            message1.setReader(result.getReader()+ message.getUserId()+',');
            messageMapper.updateByPrimaryKeySelective(message1);
        }

    }
    @Override
    public List<Project> getProjectList(){
        return projectMapper.getProjectList();
    }
    @Override
    public List<GroupEx> getGroupList(){
        return  groupExMapper.selectByPrimaryKey();
    }
    @Override
    public List<User> getUserList(){
        return userMapper.getUserList();
    }
}
