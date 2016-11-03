package com.cqut.service.search;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Map;



public class SearchResult {
	public Map<String,Object> map;
	
	public SearchResult(Map<String,Object> map) {
		this.map = map;
	}

	public Object getValue(String key,ResultType type){
		key = key.toUpperCase();
		Object val = map.get(key);
		if(val == null) 
			return null;
		switch(type){
			case Double:
				return ((BigDecimal)val).doubleValue();
			case Boolean:
				return ((BigDecimal)val).intValue() == 1 ? true :false;
			case String:
				return ((String)val);
			case Date:
				return ((Timestamp)val);
			case Int:
				return ((BigDecimal)val).intValue();
			case Long:
				return ((BigDecimal)val).longValue();
			default:
				return null;
		}
		
	}
}
