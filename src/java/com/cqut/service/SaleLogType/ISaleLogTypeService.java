package com.cqut.service.SaleLogType;

import java.util.List;
import java.util.Map;

import com.cqut.entity.SaleLogType.SaleLogType;


public interface ISaleLogTypeService {

	List<SaleLogType> getSalelogByCondition(String condition);


	
}
