package cn.edu.upc.ln.service;

import cn.edu.upc.manage.model.RolerManage;

import java.util.List;

public interface RolerManageService {
    public List<RolerManage> selectAllRoler();
    public void insertNewRoler(RolerManage rolerManage);
    public void updateRoler(RolerManage rolerManage);
    public RolerManage selectRolerManage(long id);
}
