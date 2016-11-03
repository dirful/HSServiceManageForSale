package com.cqut.service.CheckProcess;

import java.util.List;
import java.util.Map;

import com.cqut.entity.CheckProcess.CheckProcess;
import com.cqut.entity.ProcessDescription.ProcessDescription;


public interface ICheckProcessService {

	List<Map<String, Object>> getCheckProcess(String condition);

	int savacheckProcess(CheckProcess data);

	List<CheckProcess> getCheckProcessByCondition(String condition);

}
