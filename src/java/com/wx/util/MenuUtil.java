package com.wx.util;

import com.cqut.tool.util.PropertiesTool;
import com.wx.menu.Button;
import com.wx.menu.ViewButton;
import com.wx.menu.Menu;
import com.wx.menu.ViewButton;

public class MenuUtil {

//	private static final String APPID = PropertiesTool.getSystemPram("APPID");
//	private static final String APPSECRET = PropertiesTool.getSystemPram("APPSECRET");
//
//	private static final String LOGIN_URL = PropertiesTool.getBaseUrl("LOGIN_URL");
//	private static final String REGISTER_URL = PropertiesTool.getBaseUrl("REGISTER_URL");
//	private static final String MY_MEETING_URL = PropertiesTool.getBaseUrl("MY_MEETING_URL");
//	private static final String MEETING_RESULT_URL = PropertiesTool.getBaseUrl("MEETING_RESULT_URL");
	private static final String CORPID= "wxef90d7f0105db869"/*PropertiesTool.getSystemPram("CORPID")*/;
	
	private static final String oatuh_URL="http://testwebsite.ngrok.natapp.cn/HSServiceManageForSale/weChatAccess/oAuth.do?url=";
	private static final String REDIRECT_URI="http://testwebsite.ngrok.natapp.cn/HSServiceManageForSale/webApp/test/test.html";
	private static final String OAUTH_URL="https://open.weixin.qq.com/connect/oauth2/authorize?appid=CORPID&redirect_uri=REDIRECT_URI&response_type=RESPONSE_TYPE&scope=SCOPE&state=STATE#wechat_redirect";

	
	private static final String GETCODE_URL = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=snsapi_base&state=1#wechat_redirect";
	/**
	 * 自定义菜单1（15/06/17）
	 * @return
	 */
	public static Menu initMenu(){
		Menu menu = new Menu();

		ViewButton button12 = new ViewButton();
		button12.setName("新项目");
		button12.setType("view");
		button12.setUrl(oatuh_URL+"http://testwebsite.ngrok.natapp.cn/HSServiceManageForSale/webApp/ProjectInformationManagement/html/NewProjectInformation.html");

		ViewButton button13 = new ViewButton();
		button13.setName("新日志");
		button13.setType("view");
		button13.setUrl(oatuh_URL+"http://testwebsite.ngrok.natapp.cn/HSServiceManageForSale/webApp/ProjectSubjectManagement/Newadd.html");

		ViewButton button14 = new ViewButton();
		button14.setName("新报价");
		button14.setType("view");
		button14.setUrl(oatuh_URL+"http://testwebsite.ngrok.natapp.cn/HSServiceManageForSale/webApp/newQuoInfoMana/newQuoInfoMana.html");
		
		ViewButton button15 = new ViewButton();
		button15.setName("新消息");
		button15.setType("view");
		button15.setUrl(oatuh_URL+"http://testwebsite.ngrok.natapp.cn/HSServiceManageForSale/webApp/ServiceMessageManagement/html/added.html");

		ViewButton button21 = new ViewButton();
		button21.setName("我项目");
		button21.setType("view");
		button21.setUrl(oatuh_URL+"http://testwebsite.ngrok.natapp.cn/HSServiceManageForSale/webApp/ProjectInformationManagement/html/ProjectInformationCollectionAndManagement.html");
		
		ViewButton button22 = new ViewButton();
		button22.setName("我日志");
		button22.setType("view");
		button22.setUrl(oatuh_URL+"http://testwebsite.ngrok.natapp.cn/HSServiceManageForSale/webApp/ProjectSubjectManagement/ProjectSubjectManagementSaleLog.html");
		
		ViewButton button23 = new ViewButton();
		button23.setName("我报价");
		button23.setType("view");
		button23.setUrl(oatuh_URL+"http://testwebsite.ngrok.natapp.cn/HSServiceManageForSale/webApp/quoInfoMana/quoInfoMana.html");
		
		ViewButton button24 = new ViewButton();
		button24.setName("我消息");
		button24.setType("view");
		button24.setUrl(oatuh_URL+"http://testwebsite.ngrok.natapp.cn/HSServiceManageForSale/webApp/ServiceMessageManagement/html/ServiceMessageManagement.html");
		
		ViewButton button31 = new ViewButton();
		button31.setName("个人信息");
		button31.setType("view");
		button31.setUrl(oatuh_URL+"http://testwebsite.ngrok.natapp.cn/HSServiceManageForSale/webApp/personalCenter/personalCenter.html");

		ViewButton button32 = new ViewButton();
		button32.setName("报价统计");
		button32.setType("view");
		button32.setUrl(oatuh_URL+"http://testwebsite.ngrok.natapp.cn/HSServiceManageForSale/webApp/determineLogin/empty.html");

		ViewButton button33 = new ViewButton();
		button33.setName("销售统计");
		button33.setType("view");
		button33.setUrl(oatuh_URL+"http://testwebsite.ngrok.natapp.cn/HSServiceManageForSale/webApp/determineLogin/empty.html");
		
		ViewButton button34 = new ViewButton();
		button34.setName("审核相关");
		button34.setType("view");
		button34.setUrl(oatuh_URL+"http://testwebsite.ngrok.natapp.cn/HSServiceManageForSale/webApp/audit/html/audit.html");

		Button button1 = new Button();
		button1.setName("新提交");
		button1.setSub_button(new Button[]{button12,button13,button14,button15});		

		Button button2 = new Button();
		button2.setName("我发起的");
		button2.setSub_button(new Button[]{button21,button22,button23,button24});		

		Button button3 = new Button();
		button3.setName("我参与的");
		button3.setSub_button(new Button[]{button31,button32,button33,button34});		

		menu.setButton(new Button[]{button2,button1,button3});
		
		return menu;
	}

	
}
