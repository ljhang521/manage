package cn.edu.upc.xjs.Service;


import cn.edu.upc.manage.model.GroupEx;

import java.util.List;

public interface GroupExServiceXJ {
    public void insertGroupEx(GroupEx groupEx);
        void changeGroupEx(GroupEx changeName);
        List<GroupEx> selectGroupEx();
        int deleteGroupEx(GroupEx group);
}
