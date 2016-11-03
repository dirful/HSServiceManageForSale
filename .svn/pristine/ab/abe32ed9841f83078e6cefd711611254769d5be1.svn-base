package com.cqut.service.SubmitAccount;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.cqut.service.search.SearchService;
import com.cqut.tool.util.BeanUtil;
import com.cqut.tool.util.EntityIDFactory;

import  com.cqut.dao.SubmitAccount.SubmitAccountDao;
import  com.cqut.entity.SubmitAccount.SubmitAccount;

@Service
public class SubmitAccountService extends SearchService implements ISubmitAccountService{
	
	@Resource(name="submitAccountDao")
	SubmitAccountDao dao ;

	@Override
	public String getBaseEntityName() {
		return "submitAccount";
	}

	@Override
	public String getBasePrimaryKey() {
		return "submitAccount.ID";
	}
	


/*
 * WXL 保存报价反馈信息
 */
@Override
public int saveQuoteFeedback(String ID, String userID, int type, String much) {
	SubmitAccount submitaccount = new SubmitAccount();
	submitaccount.setID(BeanUtil.createId());
	
	return 0;
}
}
