package com.cqut.tool.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.sql.SQLException;

/**
* 项目名称：CisdiRswpPortal
* 类名称：ClobTool
* 类描述：   
* 创建人：xhay
* 创建时间：2014-7-4 上午9:40:00
* 修改人：xhay
* 修改时间：2014-7-4 上午9:40:00
* 修改备注：   
* @version 1.0
* 软件工程创新实验室  
*/ 
public class ClobTool {

	/** 
	* @Title: ClobToString 
	* @Description: TODO(把Clob对象转换成String) 
	* @param @param clob
	* @param @return    描述 
	* @return String    返回类型 
	*/ 
	public static synchronized String ClobToString(Clob clob) {
		if(clob == null){
			return "";
		}
		String reString = "";
		Reader is = null;
		try {
			is = clob.getCharacterStream();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 得到流
		BufferedReader br = new BufferedReader(is);
		String s = null;
		try {
			s = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		StringBuffer sb = new StringBuffer();
		while (s != null) {
			//执行循环将字符串全部取出付值给StringBuffer由StringBuffer转成STRING
			sb.append(s);
			try {
				s = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		reString = sb.toString();
		return reString;
	}

	/** 
	* @Title: stringToClob 
	* @Description: TODO(String转换成Clob) 
	* @param @param str
	* @param @return    描述 
	* @return Clob    返回类型 
	*/ 
	public static synchronized Clob stringToClob(String str) {
		if (null == str)
			return null;
		else {
			try {
				java.sql.Clob c = new javax.sql.rowset.serial.SerialClob(str
						.toCharArray());
				return c;
			} catch (Exception e) {
				return null;
			}
		}
	}
}
