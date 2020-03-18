package cn.edu.upc.wjb.service.impl;

import cn.edu.upc.manage.dao.ReportMapper;
import cn.edu.upc.manage.model.Report;
import cn.edu.upc.wjb.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    ReportMapper reportMapper;

    @Override
    public List<Report> getListByParam(int pid, int gid, int eid) {
        if (pid >0 || gid >0 || eid >0) {
            if (gid >0 && pid==0) {
                return null;
            } else if ((eid >0 && gid == 0) || (eid >0 && pid == 0)) {
                return null;
            }
            List<Report> list = reportMapper.selectReportListByParam(pid, gid, eid);
            return list;
        }
        else{
            return null;
        }
    }

    @Override
    public void insertReport(Report report) {
        reportMapper.insertSelective(report);

    }
}
