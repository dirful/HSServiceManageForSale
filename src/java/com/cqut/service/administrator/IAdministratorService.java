package com.cqut.service.administrator;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.cqut.entity.administrator.Administrator;


public interface IAdministratorService {

	String login(Administrator administrator, HttpServletRequest request);

	void logout(HttpServletRequest request);

	List<Map<String, Object>> getAdminWithPageByCondtion(String condition,
			int rows, int page);

	int getAdminCountWithPageBycondition(String condition);

	int saveAdmin(Administrator a);

	int updataAdmin(Administrator a);

	int deleteAdmin(String ID);

	Administrator getAdministratorByID(String ID);

	int changePassWord(String ID, String pw);
}
