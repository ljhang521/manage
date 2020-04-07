package cn.edu.upc.xjs.service.impl;


import cn.edu.upc.manage.dao.GroupExMapper;
import cn.edu.upc.manage.dao.GroupUserMapper;
import cn.edu.upc.manage.model.GroupEx;
import cn.edu.upc.manage.model.GroupUser;
import cn.edu.upc.manage.model.ViewGroupUser;
import cn.edu.upc.manage.model.ViewGroupUser2;
import cn.edu.upc.xjs.service.GroupExServiceXJS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("groupExService5")
public class GroupExServiceXJSImpl implements GroupExServiceXJS {
    @Autowired
    private GroupExMapper GroupExmapper;
    @Autowired
    private GroupUserMapper GroupUsermapper;
    @Autowired
    cn.edu.upc.manage.dao.ViewGroupUser2Mapper ViewGroupUser2Mapper;
    @Override
    public void insertGroupEx(GroupEx groupEx) {
        GroupExmapper.insertSelective(groupEx);
    }

    @Override
    public void changeGroupEx(GroupEx changeName) {
        GroupExmapper.updateByPrimaryKeySelect(changeName);
    }

    @Override
    public List<GroupEx> selectGroupEx() {
        return GroupExmapper.selectByPrimaryKey();
    }
    @Override
    public List<GroupEx> getGroup(Integer projectId) {
        return GroupExmapper.getGroup(projectId);
    }

    @Override
    public int deleteGroupEx(GroupEx group) {
        group.setDelFlag(group.getId());
        return GroupExmapper.updateDel(group);
    }
    @Override
    public int deleteGroupUser(GroupUser groupUser) {
        groupUser.setDelFlag(groupUser.getId());
        Date date = new Date();
        groupUser.setOperator("");
        groupUser.setOperatorIp("");
        groupUser.setOperatorTime(date);
        return GroupUsermapper.groupDel(groupUser);
    }
    public  List<ViewGroupUser2> getGroupUsers(ViewGroupUser2 record){
        return ViewGroupUser2Mapper.getGroupUsers(record);
    }

}
