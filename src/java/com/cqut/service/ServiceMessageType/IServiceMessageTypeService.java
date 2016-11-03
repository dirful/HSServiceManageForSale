package com.cqut.service.ServiceMessageType;

import java.util.List;
import java.util.Map;


public interface IServiceMessageTypeService {
	public List<Map<String, Object>> showAllType();
	public List<Map<String, Object>> showAllTemplate(String type);
}
