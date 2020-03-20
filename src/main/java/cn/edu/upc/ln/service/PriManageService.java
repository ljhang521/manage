package cn.edu.upc.ln.service;

import cn.edu.upc.manage.model.PrivilegeManage;

import java.util.List;

public interface PriManageService {
    public List<PrivilegeManage> selectAllPrivilege();
    public void insertNewPrivilege(PrivilegeManage privilegeManage);
    public void updatePrivilege(PrivilegeManage privilegeManage);
    public void deletePrivilege(long id);
    public PrivilegeManage selectPrivilegeManage(long id);
}
