package cn.edu.upc.ln.service.impl;

import cn.edu.upc.ln.service.PriManageService;
import cn.edu.upc.manage.dao.PrivilegeManageMapper;
import cn.edu.upc.manage.dao.RightsMapper;
import cn.edu.upc.manage.model.PrivilegeManage;
import cn.edu.upc.manage.model.RightsSetLN;
import cn.edu.upc.manage.model.Rights;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("priManageService")
public class PriManageServiceImpl implements PriManageService {

    @Resource RightsMapper rightsMapper;
    public List<RightsSetLN> selectAllPrivilege(){
        return rightsMapper.selectAllRightsLN();
    }
    public Rights selectPrivilegeManage(long id){
        return rightsMapper.selectByPrimaryKeyLN(id);
    }
    public void insertNewPrivilege(Rights rights){
        rightsMapper.insert(rights);
    }
    public void updatePrivilege(Rights rights){
        rightsMapper.updateByPrimaryKeySelective(rights);
    }
    @Override
    public List<RightsSetLN> selectRightByRole(Integer roleId){
        return rightsMapper.selectRightByRole(roleId);
    }
}
