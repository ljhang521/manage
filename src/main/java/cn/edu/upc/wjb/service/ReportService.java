package cn.edu.upc.wjb.service;


import cn.edu.upc.manage.model.Report;

import java.util.List;

public interface ReportService {
    List<Report> getListByParam(int pid, int gid, int eid);
    void  insertReport(Report report);
}
