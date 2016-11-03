package com.cqut.service.administrator;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import com.cqut.service.search.SearchService;
import com.cqut.tool.util.BeanUtil;
import com.cqut.tool.util.MD5;

import com.cqut.dao.administrator.AdministratorDao;
import com.cqut.entity.administrator.Administrator;

@Service
public class AdministratorService extends SearchService implements
		IAdministratorService {

	@Resource(name = "administratorDao")
	AdministratorDao dao;

	@Override
	public String getBaseEntityName() {
		return "administrator";
	}

	@Override
	public String getBasePrimaryKey() {
		return "administrator.ID";
	}

	@Override
	public String login(Administrator administrator, HttpServletRequest request) {
		String loginName = administrator.getLOGINNAME();
		String password = MD5.GetMD5Code(administrator.getPASSWORD());
		if (loginName == null || "".equals(loginName) || password == null
				|| "".equals(password)) {
			return "-1";
		}
		List<Administrator> administrators = dao.getByCondition("loginname ='"
				+ loginName + "'");

		for (Administrator u : administrators) {
			if (password.equals(u.getPASSWORD()) && "1".equals(u.getSTATE())) {
				this.bindData(u, request);
				return "1";
			}
		}
		return "-1";
	}

	private void bindData(Administrator administrator,
			HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("ID", administrator.getID());
		session.setAttribute("LOGINNAME", administrator.getLOGINNAME());
		session.setAttribute("NAME", administrator.getNAME());
		session.setAttribute("PERMISSIONID", administrator.getPERMISSIONID());
		session.setAttribute("ICON", administrator.getICON());
	}

	@Override
	public void logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Enumeration<String> attributes = session.getAttributeNames();
		while (attributes.hasMoreElements()) {
			String attrName = attributes.nextElement().toString();
			session.removeAttribute(attrName);
		}
		session.invalidate();
	}

	@Override
	public List<Map<String, Object>> getAdminWithPageByCondtion(
			String condition, int rows, int page) {
		if (condition == null || condition.equals("")) {
			condition = "administrator.PermissionID = Permission.ID";
		} else {
			condition += "AND administrator.PermissionID = Permission.ID";
		}
		return this.originalSearchWithpaging(new String[] { "administrator.ID",
				"administrator.NAME AS NAME", "administrator.LOGINNAME","administrator.PERMISSIONID","administrator.STATE",
				"DATE_FORMAT(administrator.CREATTIME,'%Y-%m-%d %H:%m:%s') AS CREATTIME", "Permission.NAME AS pNAME" },
				getBaseEntityName(), ",Permission", null, condition, false,
				null, getBasePrimaryKey(), "ASC", rows, page);
	}

	@Override
	public int getAdminCountWithPageBycondition(String condition) {
		if (condition == null || condition.equals("")) {
			condition = "administrator.PermissionID = Permission.ID";
		} else {
			condition += "AND administrator.PermissionID = Permission.ID";
		}
		return this.originalGetForeignCount("administrator.ID",
				getBaseEntityName(), ",Permission", null, condition, false);
	}

	@Override
	public int saveAdmin(Administrator a) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		a.setID(BeanUtil.createId());
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=format.format(date);
		try {
			a.setCREATTIME(sdf.parse(time));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dao.save(a);
	}

	@Override
	public int updataAdmin(Administrator a) {
		Administrator as=dao.getByID(a.getID());
		a.setCREATTIME(as.getCREATTIME());
		a.setPASSWORD(as.getPASSWORD());
		return dao.updateByID(a, a.getID());
	}

	@Override
	public int deleteAdmin(String ID) {
		return dao.deleteByID(ID);
	}
	
	@Override
	public Administrator getAdministratorByID(String ID){
		return dao.getByID(ID);
	}
	
	@Override
	public int changePassWord(String ID, String pw){
		Administrator a = dao.getByID(ID);
		a.setPASSWORD(MD5.GetMD5Code(pw));
		return dao.updateByID(a, ID);
	}
}
