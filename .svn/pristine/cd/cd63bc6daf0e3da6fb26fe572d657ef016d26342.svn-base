package com.wx.test;

import net.sf.json.JSONObject;

import com.wx.po.AccessToken;
import com.wx.util.MenuUtil;
import com.wx.util.WeixinUtil;
import com.cqut.tool.util.PropertiesTool;

public class WeixinTest {
	public static void main(String[] args) {
		try {
			AccessToken token = WeixinUtil.getAccessToken();
			System.out.println("=票据"+token.getToken());
			System.out.println("=有效时间"+token.getExpiresIn());
			
			/**
			 * 上传图片获得mediaId
			 */
			/*String path = "F:/20150626124800418.gif";
			String mediaId = WeixinUtil.upload(path, token.getToken(), "image");
			System.out.println(mediaId);*/
			
			/**
			 * 上传缩略图获得mediaId
			 */
			/*String path = "F:/koko.jpg";
			String mediaId = WeixinUtil.upload(path, token.getToken(), "thumb");
			System.out.println(mediaId);*/
			
			//String result = WeixinUtil.translate("my name is laobi");
			//String result = WeixinUtil.translateFull("");
			//System.out.println(result);
			/**
			 * 创建菜单案列
			 */
			/*String menu = JSONObject.fromObject(WeixinUtil.initMenu()).toString();
			int result = WeixinUtil.createMenu(token.getToken(), menu);
			if(result == 0){
				System.out.println("成功创建菜单");
			}else{
				System.out.println("错误码：" + result);
			}*/
			/**
			 * 创建自定义菜单
			 */
			String menu = JSONObject.fromObject(MenuUtil.initMenu()).toString();
			int result = WeixinUtil.createMenu(token.getToken(), menu);
			if(result == 0){
				System.out.println("成功创建菜单");
			}else{
				System.out.println("错误码：" + result);
			}
			/**
			 * 查询菜单
			 */
			/*JSONObject jsonObject = WeixinUtil.queryMenu(token.getToken());
			System.out.println(jsonObject);*/
			
			/**
			 * 删除菜单
			 */
			/*int result = WeixinUtil.deleteMenu(token.getToken());
			if(result == 0){
				System.out.println("成功删除菜单");
			}else{
				System.out.println("错误码：" + result);
			}*/
			/**
			 * 生成二维码
			 */
			/*String url = "http://www.baidu.com";
			WeixinUtil.getQRCodeByUrl(url);*/
			/**
			 * 创建群组
			 */
			/*JSONObject result = WeixinUtil.creatGroups(token.getToken(), "所有");
			System.out.println(result);*/

			/**
			 * 查询群组
			 */
			/*JSONObject jsonObject = WeixinUtil.queryGroups(token.getToken());
			System.out.println(jsonObject);*/

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
