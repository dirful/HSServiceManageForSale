package com.cqut.service.ServiceMessage;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;


public interface IServiceMessageService {
	public List<Map<String, Object>> showAllProject()throws ParseException;
	public List<Map<String, Object>> getLinkmanByProjectID(String ProjectID);

	int addNewServiceMessage(double TheTotalOffer,
			String pictureID, String ProjectName, String ReceiverID,
			String TemplateName, String Title, String OfferorsID, String contactsName)
			throws ParseException;
	
	public List<Map<String, Object>> ISendServiceMessage(String OfferorsID, int row, int page);
	public List<Map<String, Object>> IReceiveServiceMessage(String ReceiverID, int row, int page);
	public List<Map<String, Object>> chooseReceiver();
}
