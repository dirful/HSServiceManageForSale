package com.cqut.service.type;

import java.util.List;
import java.util.Map;

import com.cqut.entity.SaleLog.SaleLog;
import com.cqut.entity.type.Type;


public interface ITypeService {

	List<Type> getSalelogByCondition(String condition);
	List<Map<String, Object>> getnext(int rows, int page, String order,
			String sort, String condition);//换级
	int gettype(String condition);
	int updatastate(Type data);//改变状态
	Type getState(String ID);
	int updataType(Map<String, Object> map, String ID);
    int deleteType(String[] ids) throws Exception;
	List<Map<String, Object>> getType(String ID);
}
