package cn.edu.upc.ln.service.impl;

import cn.edu.upc.ln.service.RolerManageService;
import cn.edu.upc.manage.dao.RolerManageMapper;
import cn.edu.upc.manage.model.RolerManage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("RolerManageService")
public class RolerManageServiceImpl implements RolerManageService {
    @Resource
    RolerManageMapper rolerManageMapper;
    public List<RolerManage> selectAllRoler(){
        return rolerManageMapper.selectAll();
    }
    public void insertNewRoler(RolerManage rolerManage){
        rolerManageMapper.insert(rolerManage);
    }
    public void updateRoler(RolerManage rolerManage) {
        rolerManageMapper.updateByPrimaryKeySelective(rolerManage);
    }
    public RolerManage selectRolerManage(long id) {
        return rolerManageMapper.selectByPrimaryKey(id);
    }

}
