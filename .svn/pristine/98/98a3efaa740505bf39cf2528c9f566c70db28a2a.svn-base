package com.cqut.service.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cqut.dao.search.SearchDao;
import com.cqut.tool.complexSearch.KeyHandler;

@Service("searchService")
public abstract class SearchService implements ISearchService {
	
	@Resource(name="searchDao")
	SearchDao dao;
	
	public List<Map<String, Object>> originalSearchForeign(String[] properties,
			String baseEntity,String joinEntity, String[] foreignEntitys,String condition, boolean isForeignKey) {
		List<Map<String,Object>> result;
		
		if(!isForeignKey){	//使用外键
			result = dao.searchForeign(properties,baseEntity,joinEntity, foreignEntitys, null, condition);
		} else {
			List<String> keySql = getForeignKeySql(baseEntity, foreignEntitys);
			if(keySql.size() == 0) {
				result = dao.searchForeign(properties, baseEntity,joinEntity,foreignEntitys, null, condition);
			} else {
				result = dao.searchForeign(properties, baseEntity,joinEntity,foreignEntitys, keySql, condition);
			}
		}
		return result;
	}
	
	public int originalGetForeignCount(String primaryKey,String baseEntity,String joinEntity,  String[] foreignEntity, String condition, boolean isForeignKey) {
		if(!isForeignKey){
			return dao.getForeignCount(primaryKey, baseEntity,joinEntity, foreignEntity, null,condition);
		} else {
			List<String> keySql = getForeignKeySql(baseEntity, foreignEntity);
			if(keySql.size() == 0){
				return dao.getForeignCount(primaryKey, baseEntity,joinEntity, foreignEntity, null,condition);
			} else {
				return dao.getForeignCount(primaryKey, baseEntity,joinEntity, foreignEntity, keySql,condition);
			}
		}
	}
	
	public List<Map<String,Object>> originalSearchWithpaging(String[] properties,
			String baseEntity, String joinEntity, String[] foreignEntitys,String condition,
			boolean isForeignKey,String groupField, String orderField,String sortMode,
			int pageNum, int pageIndex) {

		int startIndex = pageNum * (pageIndex - 1) ;
		List<Map<String,Object>> result;
	
		if(orderField == null) 
			orderField = getBasePrimaryKey();
		
		if(sortMode == null)
			sortMode = "desc";
		
		if(!isForeignKey){
			result = dao.searchWithpagingInMysql(properties, baseEntity,joinEntity,  foreignEntitys, null, 
						condition, groupField, orderField,sortMode, startIndex, pageNum);
		} else {
			List<String> keySql = getForeignKeySql(baseEntity, foreignEntitys);
			if(keySql == null) {
				result = dao.searchWithpagingInMysql(properties, baseEntity,joinEntity,  foreignEntitys, null, 
							condition, groupField, orderField, sortMode,startIndex, pageNum);
			} else {
				result = dao.searchWithpagingInMysql(properties, baseEntity, joinEntity, foreignEntitys, keySql, 
						condition, groupField, orderField,sortMode, startIndex, pageNum);
			}
		}
		
		/*if(!isForeignKey){
			result = dao.searchWithpagingInOracle(properties, baseEntity,joinEntity,  foreignEntitys, null, 
						condition, groupField, orderField,sortMode, startIndex, endIndex);
		} else {
			List<String> keySql = getForeignKeySql(baseEntity, foreignEntitys);
			if(keySql == null) {
				result = dao.searchWithpagingInOracle(properties, baseEntity, joinEntity, foreignEntitys, null, 
							condition, groupField, orderField, sortMode,startIndex, endIndex);
			} else {
				result = dao.searchWithpagingInOracle(properties, baseEntity,joinEntity,  foreignEntitys, keySql, 
						condition, groupField, orderField,sortMode, startIndex, endIndex);
			}
		}*/
		return result;
	}
	
	
	/**
	 * 搜索外键配置，并组成sql语句
	 *
	 */
	private List<String> getForeignKeySql(String baseEntity, String[] foreignEntitys){
		if(foreignEntitys.length > 0){
			String simpleName = baseEntity;
			List<String> keys = new ArrayList<String>();
			
			int length = foreignEntitys.length;
			for(int i = 0; i < length; i++){
				String foreign = foreignEntitys[i];

				if(foreign.contains("-")){
					foreignEntitys[i] = foreign.replaceAll("-", ",");	//
					
					String[] splitForeign = foreign.split("-");
					
					//
					String keySql = KeyHandler.getForeignKey(simpleName, splitForeign[0]);
					if(keySql != null)
						keys.add(keySql);
					
					
					for(int j = 1; j < splitForeign.length; j++) {
						String otherKeySql = KeyHandler.getForeignKey(splitForeign[j-1], splitForeign[j]);
						if(otherKeySql != null)
							keys.add(otherKeySql);
					}
				}
				else{
					//如果left join 情况
					if(foreign.contains("join")) {
						String[] foreignSplit = foreign.trim().split(" ");
						foreign = foreignSplit[0];
						System.out.println("得到join 中的主体是.. " + foreign);
					}
					
					String keySql = KeyHandler.getForeignKey(simpleName, foreign);
					if(keySql != null)
						keys.add(keySql);
				}
			}
			return keys;
		}
		return null;
	}
	
	public abstract String getBaseEntityName();
	public abstract String getBasePrimaryKey();
	
	//提供的接口
	@Override
	public List<Map<String, Object>> searchForeign(String[] properties,
			String[] foreignEntitys,String condition,boolean isForeignKey){
		return this.originalSearchForeign(properties, getBaseEntityName(), null, foreignEntitys, condition, isForeignKey);
	}
	
	@Override
	public List<Map<String, Object>> searchForeignWithJoin(String[] properties,
			String joinEntity, String[] foreignEntitys,String condition,boolean isForeignKey) {
		return this.originalSearchForeign(properties, getBaseEntityName(), joinEntity, foreignEntitys, condition, isForeignKey);
	}
	
	
	@Override
	public int getForeignCount(String[] foreignEntitys,String condition,boolean isForeignKey) {
		return this.originalGetForeignCount(getBasePrimaryKey(), getBaseEntityName(), null, 
				foreignEntitys, condition, isForeignKey);
	}
	
	@Override
	public int getForeignCountWithJoin(String joinEntity,String[] foreignEntitys,String condition,boolean isForeignKey) {
		return this.originalGetForeignCount(getBasePrimaryKey(),  getBaseEntityName(), joinEntity,
				foreignEntitys, condition, isForeignKey);
	}
	
	@Override
	public int getForeignCountInFull(String primaryKey,String joinEntity,String[] foreignEntitys,String condition,boolean isForeignKey){
		return this.originalGetForeignCount(primaryKey, getBaseEntityName(), 
				joinEntity, foreignEntitys, condition, isForeignKey);
	}

	
	@Override
	public List<Map<String, Object>> searchPaging(String[] properties,
			String[] foreignEntitys, String condition,boolean isForeignKey, int pageNum, int pageIndex){
		return this.originalSearchWithpaging(properties, getBaseEntityName(), null, 
				foreignEntitys, condition, isForeignKey, null, null, null, pageNum, pageIndex);
	}
	
	@Override
	public List<Map<String, Object>> searchPagingWithJoin(String[] properties,String joinEntity,
			String[] foreignEntitys, String condition,boolean isForeignKey, int pageNum, int pageIndex) {
		return this.originalSearchWithpaging(properties, getBaseEntityName(), joinEntity, foreignEntitys, 
				condition, isForeignKey, null, null, null, pageNum, pageIndex);
	}
	
	@Override
	public List<Map<String, Object>> searchPagingInFull(String[] properties,String joinEntity,
			String[] foreignEntitys, String condition, boolean isForeignKey,
			String groupField, String orderField, String sortMode,int pageNum, int pageIndex){
		return this.originalSearchWithpaging(properties, getBaseEntityName(),
				joinEntity, foreignEntitys, condition, isForeignKey, groupField, orderField, sortMode, pageNum, pageIndex);
	}
	
	@Override
	public List<Map<String, Object>> searchPagingOnParameter(PagingParameter parameter){
		return this.originalSearchWithpaging(parameter.getProperties(),
				getBaseEntityName(), parameter.getJoinEntity(), parameter.getForeignEntitys(),
				parameter.getCondition(), parameter.isForeignKey(), parameter.getGroupField(),
				parameter.getOrderField(), parameter.getSortMode(), parameter.getPageNum(), parameter.getPageIndex());
	}
}
