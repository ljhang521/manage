package cn.edu.upc.ln.service.impl;

import cn.edu.upc.ln.service.PriManageService;
import cn.edu.upc.manage.dao.PrivilegeManageMapper;
import cn.edu.upc.manage.model.PrivilegeManage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("priManageService")
public class PriManageServiceImpl implements PriManageService {

    @Resource PrivilegeManageMapper privilegeManageMapper;
    public List<PrivilegeManage> selectAllPrivilege(){
        return privilegeManageMapper.selectAll();
    }
    public PrivilegeManage selectPrivilegeManage(long id){
        return privilegeManageMapper.selectByPrimaryKey(id);
    }
    public void insertNewPrivilege(PrivilegeManage privilegeManage){
        privilegeManageMapper.insert(privilegeManage);
    }
    public void updatePrivilege(PrivilegeManage privilegeManage){
        privilegeManageMapper.updateByPrimaryKeySelective(privilegeManage);
    }
    public void deletePrivilege(long id){
        privilegeManageMapper.deleteById(id);
    }
}
