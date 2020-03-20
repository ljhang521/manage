package cn.edu.upc.ln.service;

import cn.edu.upc.manage.model.EmployeeSelect;
import cn.edu.upc.manage.model.EmployeeSelectInput;

import java.util.List;

public interface EmployeeManageService {
    public List <EmployeeSelect> selectAllEmployee();
    public EmployeeSelect selectEmployee(EmployeeSelectInput employeeSelectInput);
}
