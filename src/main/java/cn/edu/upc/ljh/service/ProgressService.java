package cn.edu.upc.ljh.service;

import cn.edu.upc.ljh.model.Progress;

import java.util.List;

public interface ProgressService {
    List<Progress> selectByProjectId(int id);
    void insert(Progress progress);
    void delete(int id);
    void update(Progress progress);
}
