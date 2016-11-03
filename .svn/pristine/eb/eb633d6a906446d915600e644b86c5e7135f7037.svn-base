package com.cqut.service.SaleLog;

import java.util.List;
import java.util.Map;

import com.cqut.entity.SaleLog.SaleLog;
import com.cqut.entity.SaleLogType.SaleLogType;
public interface ISaleLogService {
	int savaSaleLog(SaleLog data);
	List<Map<String, Object>> getSalelog(String condition);
	int delete(String ID);

	/*List<Map<String, Object>> getOfferorsID(String ID);*/
	List<Map<String, Object>> getdetail(String ID);
	List<Map<String, Object>> getsalelog(int rows, int page, String order,
			String sort, String condition,String startime,String stoptime);
	int getSaleLog(String condition);
	int savaSaleLogbehind(SaleLog data);
	int updataSaleLog(Map<String, Object> map, String ID);
    int deleteSaleLog(String[] ids) throws Exception;
	int updatastate(SaleLog data);
	SaleLog getState(String ID);
//	List<Map<String, Object>> time(int rows, int page, String order,
//			String sort, String condition, String fromStarTime,
//			String fromStopTime);
	List<Map<String, Object>> getSaleLogByOfferorsIDWithpaging(
			String offerorsID, String condition, int row, int page);

}
