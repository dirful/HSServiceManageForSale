package com.cqut.service.QuotedPrice;

import java.util.List;
import java.util.Map;

import com.cqut.entity.CheckProcess.CheckProcess;
import com.cqut.entity.Process.Process;
import com.cqut.entity.ProcessDescription.ProcessDescription;
import com.cqut.entity.QuotedPrice.QuotedPrice;
import com.cqut.entity.QuotedPriceDtaile.QuotedPriceDtaile;


public interface IQuotedPriceService {

	List<Map<String, Object>> getNewQuotedPriceInfo(String condition);

	List<Map<String, Object>> getTemplet(String condition);

	int saveNewQuotedPriceInfo(QuotedPrice param);

	int deletQuotedPriceInfo(String condition);
	
	QuotedPrice getQuotedPriceByID(String ID);

	int updateByID(QuotedPrice quotedPrice);

	List<Map<String, Object>> getQuotedPriceByOfferorsIDWithpaging(
			String offerorsID, String condition, int row, int page);

	List<Map<String, Object>> getQuotedPriceByConditonWithpaging(
			String condition, int row, int page);

	List<Map<String, Object>> getEmployeeInfo(String ID, String time,
			String type);

	int saveNewQuotedPriceDtaileInfo(QuotedPriceDtaile param);


	List<Map<String, Object>> getBackEmployeeInfo(int rows, int page,
			String order, String sort, String condition);

	boolean deleteBackEmployeeInfo(String ID);

	int countBackEmployeeInfo(String condition);

	List<Map<String, Object>> quoDetailsList(String condition);

	int saveNewProcessDescription(ProcessDescription param);

	List<Map<String, Object>> getProject();

	List<Map<String, Object>> getQuotedPriceInfo(String condition, int page,
			int row);

	int getQuotedPriceInfoCount(String condition);

	List<Map<String, Object>> quoDetailsListBack(String ID);

	boolean deleteTemplet(String ID);

	List<Map<String, Object>> getTemplet(int rows, int page, String order,
			String sort, String condition);

	int countTemplet(String condition);

	List<Map<String, Object>> getEmployee(String ID);

	int saveNewProcess(Process newProcess);

	int saveNewCheckProcess(CheckProcess newCheckProcess);

	List<Process> getQuotedPriceProcessByID(String condition);

	List<Map<String, Object>> getQuotedPriceByConditon(String condition);

	List<Map<String, Object>> getMySaleLogByConditonWithpaging(
			String condition, int row, int page);

	List<Map<String, Object>> getMySaleLogByConditon(String condition);
}
