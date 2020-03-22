package cn.edu.upc.xjs.service.impl;


import cn.edu.upc.manage.dao.GroupExMapper;
import cn.edu.upc.manage.model.GroupEx;
import cn.edu.upc.xjs.service.GroupExServiceXJS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("groupExService5")
public class GroupExServiceXJSImpl implements GroupExServiceXJS {
    @Autowired
    private GroupExMapper GroupExmapper;

    @Override
    public void insertGroupEx(GroupEx groupEx) {
        groupEx.setGroupName("null");
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
    public int deleteGroupEx(GroupEx group) {
        group.setDelFlag(group.getId());
        return GroupExmapper.updateDel(group);
    }
}
