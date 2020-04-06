package cn.edu.upc.ln.service;

import cn.edu.upc.manage.model.PrivilegeManage;
import cn.edu.upc.manage.model.RightsSetLN;
import cn.edu.upc.manage.model.Rights;

import java.util.List;

public interface PriManageService {
    public List<RightsSetLN> selectAllPrivilege();
    public void insertNewPrivilege(Rights rights);
    public Rights selectPrivilegeManage(long id);
    public void updatePrivilege(Rights privilegeManage);
}
