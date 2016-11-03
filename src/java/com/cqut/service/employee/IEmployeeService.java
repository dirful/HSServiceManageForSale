package com.cqut.service.employee;

import java.util.List;
import java.util.Map;

import com.cqut.entity.employee.Employee;


public interface IEmployeeService {
	public List<Map<String, Object>> getEmployeeByID(String ID);
	public int updateEmployeenameByID(String ID ,String employeename);
	public int updateWeChatByID(String ID ,String wechat);
	public int updateAddressByID(String ID ,String address);
	public int updatePropByID(String ID, String PICID);
	Employee getByID(String ID);
	public List<Map<String, Object>> getEmployee();
}
