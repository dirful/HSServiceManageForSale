package com.cqut.service.ServiceMessageType;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.cqut.service.search.SearchService;
import  com.cqut.dao.ServiceMessageType.ServiceMessageTypeDao;

@Service
public class ServiceMessageTypeService extends SearchService implements IServiceMessageTypeService{
	
	@Resource(name="serviceMessageTypeDao")
	ServiceMessageTypeDao dao ;

	@Override
	public String getBaseEntityName() {
		return "serviceMessageType";
	}

	@Override
	public String getBasePrimaryKey() {
		return "serviceMessageType.ID";
	}
/*
 * wxl 显示所有的大类,小类(non-Javadoc)
 * @see com.cqut.service.ServiceMessageType.IServiceMessageTypeService#showAllMainType()
 */
	@Override
	public List<Map<String, Object>> showAllType() {
		
		String properties[]={
							 "type.ID",
							 "type.`NAME` AS typeName",
							 "type.PARENTID",
							 "type.`LEVEL` AS level"
		};
		String baseEntity = "type";
		String condition = "type.TYPE= '2' AND type.STATE = '1'";
		List<Map<String, Object>> list = this.originalSearchForeign(properties, baseEntity, null, null, condition, false);
		return list;
	}
///*
// * wxl 显示小类(non-Javadoc)
// * @see com.cqut.service.ServiceMessageType.IServiceMessageTypeService#showAllSecondaryType(java.lang.String)
// */
//	@Override
//	public List<Map<String, Object>> showAllSecondaryType(String parentID) {
//		String properties[]={"Type.`level`",
//							 "Type.name",
//							 "Type.code",
//							 "Type.parentID",
//							 "Type.ID"
//		};
//		String baseEntity = "Type";
//		String condition = "Type.parentID='"+parentID+"'and Type.state='1' and Type.type = '2'";
//		List<Map<String, Object>> list = this.originalSearchForeign(properties, baseEntity, null, null, condition, false);
//		return list;
//	}
/*
 * wxl 查询模板(non-Javadoc)
 * @see com.cqut.service.ServiceMessageType.IServiceMessageTypeService#showAllTemplate()
 */
	@Override
	public List<Map<String, Object>> showAllTemplate(String type) {
		String properties []={"templet.templetName",
							  "templet.ID"};
		String baseEntity = "templet";
		String condition = "templet.str0='"+type+"' and templet.state='1'";
		List<Map<String, Object>> list = this.originalSearchForeign(properties, baseEntity, null, null, condition, false); 
		return list;
	}
}
