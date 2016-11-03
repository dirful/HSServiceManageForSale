package com.cqut.dao.QuotedPrice;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import  com.cqut.entity.QuotedPrice.QuotedPrice;

public interface QuotedPriceDao {
	public int save(QuotedPrice quotedPrice);
	public int saveEntities(@Param("entities")QuotedPrice[] quotedPrices);
	
	public int updateByID(@Param("entity")QuotedPrice quotedPrice, @Param("id")String ID);
	public int updateByCondition(@Param("entity")QuotedPrice quotedPrice, @Param("condition")String condition);
	public int updatePropByID(@Param("prop")Set<Entry<String, Object>> prop,  @Param("id")String ID);
	public int updatePropByCondition(@Param("prop")Set<Entry<String, Object>> prop,  @Param("condition")String condition);
	
	public int deleteByID(@Param("ID")String ID);
	public int deleteByCondition(@Param("condition")String condition);
	public int deleteEntities(@Param("ids")String[] IDs);
	
	public QuotedPrice getByID(@Param("ID")String ID);
	public List<QuotedPrice> getByCondition(@Param("condition")String condition);
	public Map<String,Object> findByID(@Param("properties")String[] properties, @Param("id")String id);
	public List<Map<String,Object>> findByCondition(@Param("properties")String[] properties, @Param("condition")String condition);
	
	public int getCountByCondition(@Param("condition")String condition);
	
	
}
