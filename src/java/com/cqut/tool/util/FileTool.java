package com.cqut.tool.util;

public class FileTool {
	
	static String imgRoute = PropertiesTool.getSystemPram("imgRoute");
	static String fileRoute = PropertiesTool.getSystemPram("fileRoute");
	
	public static String  getImgRoute(String imgName){
		return imgRoute + imgName;
	}
	
	public static String getFileRoute(String fileName) {
		return   fileRoute + fileName;
	}
	
	/**
	 * 下面两个方法提交给使用
	 * @param imgName
	 * @param imgRoute
	 * @return
	 */
	public static String getImgRoute(String imgName,String imgRoute){
		return imgRoute + imgName;
	}
	
	public static String getFileRoute(String fileName, String fileRoute) {
		return   fileRoute + fileName;
	}
	
	
	static String filePath = PropertiesTool.getSystemPram("filePath");
	public static String getDownPath(String fileName) {
		return filePath +"\\" + fileName;
	}
	
}
