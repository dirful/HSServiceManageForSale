package com.cqut.service.Templet;


import java.io.Console;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.cqut.service.search.SearchService;
import com.cqut.tool.util.BeanUtil;
import com.cqut.tool.util.EntityIDFactory;

import  com.cqut.dao.Templet.TempletDao;
import  com.cqut.entity.Templet.Templet;

@Service
public class TempletService extends SearchService implements ITempletService{
	
	@Resource(name="templetDao")
	TempletDao dao ;

	@Override
	public String getBaseEntityName() {
		return "templet";
	}

	@Override
	public String getBasePrimaryKey() {
		return "templet.ID";
	}
	//获得模板str0
	@Override
	public 	List<Map<String, Object>> getstr(String conditions){
	  String condition="templet.str0 = "+conditions+"";
	
		String [] properties ={
				" templet.str0 ",
				" templet.templetName ",
				" templet.ID "
};
		String baseEntity = " templet ";
		String joinEntity="LEFT JOIN type as child ON child.ID=templet.str1";
		List<Map<String, Object>> list = this.originalSearchForeign(properties, baseEntity, joinEntity, null, condition, false);	

         return list;
	}


	/**后台得到项目信息采集模板   cyb */
	@Override
	public Map<String, Object> getProjectInfoTempletListWithPaging(int rows, int page, String orderFiled, String sortMode, String condition){
		if(condition==null){
			 condition  = " 1=1 AND templet.type=4 AND templet.state=1";
		}
		String []properties=new String[]{
				"templet.ID",
				"templet.templetCode AS TEMPLETCODE",
				"templet.templetName AS TEMPLETNAME",
				"date_format(templet.createTime,'%Y-%c-%d %h:%i:%s') AS CREATETIME",//将date类型日期转换成字符串
				"employee.employeeName AS CREATEMAN",
				"templet.description AS DESCRIPTION",
				"project.remarks AS REMARKS",
		};
		
		String baseEntity="templet";
		String joinEntity="LEFT JOIN project ON project.templetID=templet.ID "+
							"LEFT JOIN employee ON employee.ID=project.offerID";
							
		List<Map<String, Object>> list = this.originalSearchWithpaging(properties, baseEntity, joinEntity, null, condition, false, null, orderFiled, sortMode, rows, page);
		int count = this.getForeignCount(null, condition, false);
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("total", count);
		map.put("rows", list);
		
		return map;	
	}
	

	/*
	 * wxl 查询服务消息模板(non-Javadoc)
	 * @see com.cqut.service.Templet.ITempletService#getServiceMessageTenplet(java.lang.String)
	 */
		@Override
		public List<Map<String, Object>> getServiceMessageTemplet(int rows, int page, String order, String sort, String condition) {
			String properties []={"templet.ID",
								  "templet.templetCode AS TECODE",
								  "templet.templetName AS TENAME",
							 	  "DATE_FORMAT(templet.createTime,'%Y-%m-%d %H:%i:%s') AS CREATETIME",
								  "templet.description as DESCRIPTION"
								};
			String baseEntity = "templet";
			List<Map<String, Object>> list =this.originalSearchWithpaging(properties, baseEntity, " ", null, condition, false, null, getBasePrimaryKey(), sort, rows,page);
			return list;
		}
	/*
	 * wxl 删除服务消息模板(non-Javadoc)
	 * @see com.cqut.service.Templet.ITempletService#deleteServiceTemplet(java.lang.String)
	 */
		@Override
		public int deleteServiceTemplet(String ID) {
			return dao.deleteByID(ID);
		}

	/**后台删除项目信息采集模板   cyb */
	@Override
	public int deleteTemplets(String[] IDs){
		return dao.deleteEntities(IDs);
	}
	
//	/**后台修改项目信息采集模板   cyb */
//	@Override
//	public int updatePropTempletByID(Templet templet,String ID){
//		
//		Map<String, Object> prop = new HashMap<String, Object>();
//	    prop.put("templetCode", templet.getTempletCode());
//	    prop.put("templetName", templet.getTempletName());
//	    prop.put("description", templet.getDescription());
//	 //   prop.put("createTime", templet.getCreateTime());
//	    
//		return  dao.updatePropByID(prop.entrySet(),  ID);
//	}
		
}
