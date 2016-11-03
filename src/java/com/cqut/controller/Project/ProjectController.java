package com.cqut.controller.Project;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cqut.entity.Project.Project;
import com.cqut.service.Project.IProjectService;
import com.cqut.tool.json.JsonTool;
import com.cqut.tool.util.BeanUtil;

@Controller
@RequestMapping("/projectController")
public class ProjectController {

	@Resource(name = "projectService")
	IProjectService service;

	/************************* 前台 ***************************************************/
	/**
	 * 陈钰博 * 得到项目信息函数 *
	 */
	@RequestMapping("/getProjectsInfo")
	@ResponseBody
	public String getProjectsInfo() {
		return JsonTool.toJsonList(service.getProjectsInfo());
	}

	/**
	 * 陈钰博 
	 * 删除项目信息函数 *
	 */
	@RequestMapping("/deleteProjectInfo")
	@ResponseBody
	public String deleteProjectInfo(String ID) {
		return String.valueOf(service.deleteProjectInfo(ID));
	}

	/**
	 * 陈钰博 * 查询项目详细信息函数 *
	 */
	@RequestMapping("/searchProjectDetailInfo")
	@ResponseBody
	public String searchProjectDetailInfo(String ID) {
		return JsonTool.toJsonList(service.searchProjectDetailInfo(ID));
	}

	/**
	 * 陈钰博 * 查询项目图片函数 *
	 */
	@RequestMapping("/getPicFilePath")
	@ResponseBody
	public String getPicFilePath(String ID) {
		return JsonTool.toJsonList(service.getPicFilePath(ID));
	}

	/**
	 * 陈钰博 * 得到大类函数 *
	 */
	@RequestMapping("/getBigClassName")
	@ResponseBody
	public String getBigclassName() {
		return JsonTool.toJsonList(service.getBigClassName());
	}

	/**
	 * 陈钰博 * 得到小类函数 *
	 */
	@RequestMapping("/getSubclassName")
	@ResponseBody
	public String getSubclassName(String parentID) {
		return JsonTool.toJsonList(service.getSubclassName(parentID));
	}

	/**
	 * 陈钰博 * 得到模板函数 *
	 */
	@RequestMapping("/getTempletName")
	@ResponseBody
	public String getTempletName(String subclassID) {
		return JsonTool.toJsonList(service.getTempletName(subclassID));
	}

	/**
	 * 陈钰博 * 得到部门函数 *
	 */
	@RequestMapping("/getDepartment")
	@ResponseBody
	public String getDepartment() {
		return JsonTool.toJsonList(service.getDepartment());
	}

	/**
	 * 陈钰博 * 得到员工函数 *
	 */
	@RequestMapping("/getEmployee")
	@ResponseBody
	public String getEmployee(String departmentID) {
		return JsonTool.toJsonList(service.getEmployee(departmentID));
	}

	/**
	 * 陈钰博 * 保存项目信息函数
	 * 
	 * @throws UnsupportedEncodingException
	 *             *
	 */
	@RequestMapping("/saveProjectInfo")
	@ResponseBody
	public String saveProjectInfo(Project project, HttpSession sesssion) {
		String offerID = (String) sesssion.getAttribute("ID");
		String ID = BeanUtil.createId();// 生成ID
		String projectCode = getProjectCode();

		project.setID(ID);
		project.setProjectCode(projectCode);
		project.setOfferID(offerID);

		return String.valueOf(service.saveProjectInfo(project));
	}

	/************************* 后台 ***************************************************/
	/** 得到项目信息 */
	@RequestMapping("/getProjectListWithPaging")
	@ResponseBody
	public String getStudentListWithPaging(int rows, int page,
			String orderFiled, String sortMode, String condition) {
		return JsonTool.toJson(service.getProjectListWithPaging(rows, page,
				orderFiled, sortMode, condition));
	}

	/** 删除项目信息 */
	@RequestMapping("/deleteProjects")
	@ResponseBody
	public String deleteProjects(String[] IDs) {
		return service.deleteProjects(IDs) == 1 ? "true" : "false";
	}

	/** 修改项目信息 */
	@RequestMapping("/update")
	@ResponseBody
	public String update(String projectCode, String projectName,
			String companyName, String consumerWorkPlace, String contactsName,
			Date createTime, Date startTime, Date endTime, String leaderName,
			String templetName, String webSite, String projectType,
			String trade, String typeName, String offerName, String ID) {
		Project project = new Project();
		// project.setCompanyID(companyID);
		project.setConsumerWorkPlace(consumerWorkPlace);
		project.setContactsName(contactsName);
		project.setCreateTime(createTime);
		project.setEndTime(endTime);
		// project.setLeaderID(leaderID);
		// project.setPicID(picID);
		// project.setOfferID(offerID);
		// project.setProgress(progress);
		project.setProjectCode(projectCode);
		project.setProjectName(projectName);
		project.setProjectType(projectType);
		project.setStartTime(startTime);
		// project.setTempletID(templetID);
		project.setTrade(trade);
		// project.setTypeID(typeID);
		project.setWebSite(webSite);

		return service.update(project, ID) == 1 ? "true" : "false";
	}

	/** 随机生成编码函数 */
	public String getProjectCode() {
		String code = "";
		code += (char) (Math.random() * 26 + 'A');
		code += (char) (Math.random() * 26 + 'A');
		code += BeanUtil.createId();

		return code;
	}

}
