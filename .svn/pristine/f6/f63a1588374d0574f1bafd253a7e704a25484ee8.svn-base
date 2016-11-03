package com.cqut.controller.WeChatAccess;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cqut.controller.Session.SessionController;
import com.cqut.service.employee.IEmployeeService;
import com.qq.weixin.mp.aes.AesException;
import com.qq.weixin.mp.aes.WXBizMsgCrypt;
import com.wx.po.AccessToken;

@Controller
@RequestMapping("/weChatAccess")
public class WeChatAccess {
	
	private static final String CORPID= "wxef90d7f0105db869"/*PropertiesTool.getSystemPram("CORPID")*/;
	private static final String CORPSECRET= "eyJGvwa9wBB0d0GPzAAyuITIfWeRxIyXhREE9Tr9LXOFbFSqJ3HTc2XSgN3-dDMK"/*PropertiesTool.getSystemPram("CORPSECRET")*/;

	//获取access token
	private static final String ERROR_URL="http://testwebsite.ngrok.natapp.cn/HSServiceManageForSale/webApp/determineLogin/error.html";
	private static final String TEST_URL="http://testwebsite.ngrok.natapp.cn/HSServiceManageForSale/webApp/test/test.html";
	private static final String ACCESS_TOKEN_URL = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=CORPID&corpsecret=CORPSECRET";
	private static final String REDIRECT_URI="http://testwebsite.ngrok.natapp.cn/HSServiceManageForSale/weChatAccess/oAuthByCode.do";
	private static final String OAUTH_URL="https://open.weixin.qq.com/connect/oauth2/authorize?appid=CORPID&redirect_uri=REDIRECT_URI&response_type=RESPONSE_TYPE&scope=SCOPE&state=STATE#wechat_redirect";
	private static final String OAUTHBYCODE_URL="https://qyapi.weixin.qq.com/cgi-bin/user/getuserinfo?access_token=ACCESS_TOKEN&code=CODE";
	
	@Resource(name = "employeeService")
	IEmployeeService employeeService;
	
	/**
	 * OAuth2.0身份验证
	 * @param url 身份验证后跳转的网址
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping("/oAuth")
	public static String oAuth(String url/*,HttpSession session*/) throws UnsupportedEncodingException{
		//String url="111";//"http://testwebsite.ngrok.natapp.cn/HSServiceManageForSale/webApp/test/test.html";
//		System.out.println("ID:"+session.getAttribute("ID"));
//		if(session.getAttribute("ID") != null && session.getAttribute("ID") != ""){
//			return "redirect:"+url;
//		}
//		System.out.println("url:"+url);
//		System.out.println("URL:"+OAUTH_URL.replace("CORPID", CORPID).replace("REDIRECT_URI", URLEncoder.encode(REDIRECT_URI, "utf-8")).replace("RESPONSE_TYPE", "code").replace("SCOPE", "snsapi_base").replace("STATE", URLEncoder.encode(url, "utf-8")));
		return "redirect:"+OAUTH_URL.replace("CORPID", CORPID).replace("REDIRECT_URI", URLEncoder.encode(REDIRECT_URI, "utf-8")).replace("RESPONSE_TYPE", "code").replace("SCOPE", "snsapi_base").replace("STATE", URLEncoder.encode(url, "utf-8"));
	}
	
	//根据code获取成员信息
	@RequestMapping("/oAuthByCode")
	public String oAuthByCode(String code,String state,HttpServletRequest request) throws ClientProtocolException, IOException{
//		String[] params = request.getQueryString().replace("&", "=").split("=");
//		String url=params[params.length-1];
//		System.out.println("code:"+code);
//		System.out.println("state:"+state);
		DefaultHttpClient client = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(OAUTHBYCODE_URL.replace("ACCESS_TOKEN", this.getAccessToken()).replace("CODE", code));
		JSONObject jsonObject = null;
		HttpResponse httpResponse = client.execute(httpGet);
		HttpEntity entity = httpResponse.getEntity();
		if(entity != null){
			jsonObject=JSONObject.fromObject(EntityUtils.toString(entity,"UTF-8"));
			if(jsonObject.containsKey("UserId")){
				//userid查询成功，初始化session
				System.out.println(jsonObject.get("UserId"));
				System.out.println(employeeService.getByID((String)jsonObject.get("UserId")));
				SessionController.initSession(employeeService.getByID((String)jsonObject.get("UserId")),request);
				return "redirect:"+state;
			}
			return "redirect:"+ERROR_URL;
		}
		return "redirect:"+ERROR_URL;
	}
	
	public String getAccessToken() throws ParseException, IOException{
		AccessToken token = new AccessToken();
		//公众号
//		String url = ACCESS_TOKEN_URL.replace("APPID", APPID).replace("APPSECRET", APPSECRET);
		//企业号
		String url = ACCESS_TOKEN_URL.replace("CORPID", CORPID).replace("CORPSECRET", CORPSECRET);
		JSONObject jsonObject = this.doGetStr(url);
		if(jsonObject!=null){
			token.setToken(jsonObject.getString("access_token"));
			token.setExpiresIn(jsonObject.getInt("expires_in"));
		}
		return jsonObject.getString("access_token");
	}
	
	public JSONObject doGetStr(String url) throws ParseException, IOException{
		DefaultHttpClient client = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(url);
		JSONObject jsonObject = null;
		HttpResponse httpResponse = client.execute(httpGet);
		HttpEntity entity = httpResponse.getEntity();
		if(entity != null){
			String result = EntityUtils.toString(entity,"UTF-8");
			jsonObject = JSONObject.fromObject(result);
		}
		return jsonObject;
	}
	
	//回调模式
	@RequestMapping("/chat")
	@ResponseBody
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置编码
		response.setContentType("text/html;charset=utf-8");
		// response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		// 企业号的基本信息，配置时填写
		String sToken = "4MpDSHt9627ni";
		String sCorpID = "wxef90d7f0105db869";
		String sEncodingAESKey = "5SRVajrkzzU3RyWE7neB8tJAqRzQOTFJ9ZuRW4kHxy0";
		// 微信加密签名 
        String sVerifyMsgSig = request.getParameter("msg_signature");
        // 时间戳
        String sVerifyTimeStamp = request.getParameter("timestamp");
        // 随机数
        String sVerifyNonce = request.getParameter("nonce");
        // 随机字符串
        String sVerifyEchoStr = request.getParameter("echostr");
        System.out.println("sVerifyMsgSig:"+sVerifyMsgSig);
        System.out.println("sVerifyTimeStamp:"+sVerifyTimeStamp);
        System.out.println("sVerifyNonce:"+sVerifyNonce);
        System.out.println("sVerifyEchoStr:"+sVerifyEchoStr);
        String sEchoStr; //需要返回的明文
        PrintWriter out = response.getWriter();  
        WXBizMsgCrypt wxcpt;
        try {
            wxcpt = new WXBizMsgCrypt(sToken, sEncodingAESKey, sCorpID);
            sEchoStr = wxcpt.VerifyURL(sVerifyMsgSig, sVerifyTimeStamp,sVerifyNonce, sVerifyEchoStr);
            // 验证URL成功，将sEchoStr返回
            out.print(sEchoStr);  
        } catch (AesException e1) {
            e1.printStackTrace();
        }
		/*try {
			WXBizMsgCrypt wxcpt = new WXBizMsgCrypt(sToken, sEncodingAESKey,
					sCorpID);
			// 解析出url上的参数值如下：
			// URLDecoder.decode(request.getParameter("echostr"),"utf-8");
			String sVerifyMsgSig = URLDecoder.decode(
					request.getParameter("msg_signature"), "utf-8");
			String sVerifyTimeStamp = URLDecoder.decode(
					request.getParameter("timestamp"), "utf-8");
			String sVerifyNonce = URLDecoder.decode(
					request.getParameter("nonce"), "utf-8");
			String sVerifyEchoStr = URLDecoder.decode(
					request.getParameter("echostr"), "utf-8");
			PrintWriter out = response.getWriter();
			String sEchoStr; // 需要返回的明文
			try {
				sEchoStr = wxcpt.VerifyURL(sVerifyMsgSig, sVerifyTimeStamp, sVerifyNonce, sVerifyEchoStr);
				System.out.println("verifyurl echostr: " + sEchoStr);
				//verifyurl echostr: 507092879368241085
				// 验证URL成功，将sEchoStr返回
				out.print(sEchoStr);
				out.close();
				out = null;
			} catch (Exception e) {
				// 验证URL失败，错误原因请查看异常
				e.printStackTrace();
			}
		} catch (AesException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
	}
}
