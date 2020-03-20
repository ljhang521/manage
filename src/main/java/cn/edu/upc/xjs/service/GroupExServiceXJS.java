package cn.edu.upc.xjs.service;


import cn.edu.upc.manage.model.GroupEx;

import java.util.List;

public interface GroupExServiceXJS {
    /*插入小组内容*/
    public void insertGroupEx(GroupEx groupEx);
    /*修改小组内容*/
        void changeGroupEx(GroupEx changeName);
    /*显示小组内容*/
        List<GroupEx> selectGroupEx();
    /*根据id值删除小组，实际是为del_flag赋值为id值*/
        int deleteGroupEx(GroupEx group);
}
