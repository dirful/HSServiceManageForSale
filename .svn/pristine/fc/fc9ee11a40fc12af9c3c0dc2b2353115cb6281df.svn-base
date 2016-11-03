package com.cqut.tool.util;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/*
 * 对象转换为Map格式
 */

public class ObjAnalysis {
 
	
		 public  Map ConvertObjToMap(Object obj){
		  Map<String,Object> reMap = new HashMap<String,Object>();
		  if (obj == null) 
		   return null;
		  Field[] fields = obj.getClass().getDeclaredFields();
		  try {
		   for(int i=0;i<fields.length;i++){
		    try {
		     Field f = obj.getClass().getDeclaredField(fields[i].getName());
		     f.setAccessible(true);
		           Object o = f.get(obj);
		           if(o==null){
		        	  o="";
		           }
		           if(o instanceof Date){
		        	 o=  SysDateFormat.formatDateTime((Date)o);
		           }
		           
		           reMap.put(fields[i].getName(), o);
		    } catch (NoSuchFieldException e) {
		     // TODO Auto-generated catch block
		     e.printStackTrace();
		    } catch (IllegalArgumentException e) {
		     // TODO Auto-generated catch block
		     e.printStackTrace();
		    } catch (IllegalAccessException e) {
		     // TODO Auto-generated catch block
		     e.printStackTrace();
		    }
		   }
		  } catch (SecurityException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		  } 
		  return reMap;
		 }
}