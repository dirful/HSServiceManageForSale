package com.cqut.tool.util;

public class ImgTool {
	
	static String imgPath = PropertiesTool.getSystemPram("imgPath");
	
	public static String  getImgPath(String imgName){
		return imgPath + imgName;
	}

}
