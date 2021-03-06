package com.cqut.dao.ServiceMessageType;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import  com.cqut.entity.ServiceMessageType.ServiceMessageType;

public interface ServiceMessageTypeDao {
	public int save(ServiceMessageType serviceMessageType);
	public int saveEntities(@Param("entities")ServiceMessageType[] serviceMessageTypes);
	
	public int updateByID(@Param("entity")ServiceMessageType serviceMessageType, @Param("id")String ID);
	public int updateByCondition(@Param("entity")ServiceMessageType serviceMessageType, @Param("condition")String condition);
	public int updatePropByID(@Param("prop")Set<Entry<String, Object>> prop,  @Param("id")String ID);
	public int updatePropByCondition(@Param("prop")Set<Entry<String, Object>> prop,  @Param("condition")String condition);
	
	public int deleteByID(@Param("ID")String ID);
	public int deleteByCondition(@Param("condition")String condition);
	public int deleteEntities(@Param("ids")String[] IDs);
	
	public ServiceMessageType getByID(@Param("ID")String ID);
	public List<ServiceMessageType> getByCondition(@Param("condition")String condition);
	public Map<String,Object> findByID(@Param("properties")String[] properties, @Param("id")String id);
	public List<Map<String,Object>> findByCondition(@Param("properties")String[] properties, @Param("condition")String condition);
	
	public int getCountByCondition(@Param("condition")String condition);
	
	
}
