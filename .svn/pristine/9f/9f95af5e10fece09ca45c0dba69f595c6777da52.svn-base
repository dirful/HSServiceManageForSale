package com.cqut.tool.util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BeanUtil {
	private static String preId = "";
	private static final SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
	/**
	 * @author wangyuanqin
	 * @param ParentCode 父节点code
	 * @param lastCode 上一个节点code
	 * @return 当前节点code
	 */
	public static synchronized String creatId(String ParentCode,String lastCode){
		/**
		 * if(ParentCode.equals("")||ParentCode==null){
		 * ParentCode="";
		 * }
		 * */
		
		if(lastCode == null || lastCode.equals("")  ){
			lastCode = ParentCode + "0000";
		}
		int currentFourNumber = Integer.parseInt(lastCode.substring(ParentCode.length(), lastCode.length())) + 1;
		DecimalFormat df = new DecimalFormat( "0000" );
		String currentCode =  ParentCode + df.format(currentFourNumber);
		return currentCode;
	}
	public static synchronized String createId(){
		String id = format.format(Calendar.getInstance().getTime());
		while(id.equals(preId)){
			id = format.format(Calendar.getInstance().getTime());
		}
		preId = id;
		return id;
	}
}
