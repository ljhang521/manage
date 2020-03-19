package cn.edu.upc.xjs.Service;


import cn.edu.upc.manage.dao.GroupExMapper;
import cn.edu.upc.manage.model.GroupEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("groupExService5")
public class GroupExServiceImplXJ implements GroupExServiceXJ {
    @Autowired
    private GroupExMapper GroupExmapper;
    @Override
    public void insertGroupEx(GroupEx groupEx){
        GroupExmapper.insertSelective(groupEx);
    }
    public void changeGroupEx(GroupEx changeName) {
        GroupExmapper.updateByPrimaryKeySelect(changeName);
    }
     public List<GroupEx> selectGroupEx(){
       return GroupExmapper.selectByPrimaryKey();
     }
    @Override
     public int deleteGroupEx(GroupEx group){

        group.setDelFlag(group.getId());
        return GroupExmapper.updateDel(group);
     }
}
