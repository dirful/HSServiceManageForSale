package com.wx.util;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import net.sf.json.JSONObject;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.cqut.tool.QRCode.MatrixToImageWriter;
import com.cqut.tool.util.BeanUtil;
import com.cqut.tool.util.PropertiesTool;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.wx.menu.Button;
import com.wx.menu.ClickButton;
import com.wx.menu.Menu;
import com.wx.menu.ViewButton;
import com.wx.po.AccessToken;
import com.wx.trans.Data;
import com.wx.trans.Parts;
import com.wx.trans.Symbols;
import com.wx.trans.TransResult;

/**
 * 微信工具类
 * @author Stephen
 *
 */
public class WeixinUtil {
	
	//公众号相关
	//private static final String APPID = PropertiesTool.getSystemPram("APPID");
	//private static final String APPSECRET = PropertiesTool.getSystemPram("APPSECRET");
	//企业号相关
	private static final String CORPID= "wxef90d7f0105db869"/*PropertiesTool.getSystemPram("CORPID")*/;
	private static final String CORPSECRET= "eyJGvwa9wBB0d0GPzAAyuITIfWeRxIyXhREE9Tr9LXOFbFSqJ3HTc2XSgN3-dDMK"/*PropertiesTool.getSystemPram("CORPSECRET")*/;
	
	//企业号相关
	//获取access token
	private static final String ACCESS_TOKEN_URL = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=CORPID&corpsecret=CORPSECRET";
	//自定义菜单创建接口
	private static final String CREATE_MENU_URL = "https://qyapi.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN&agentid=AGENTID";
	//OAUTH2.0验证网址
	private static final String OAUTH_URL="https://open.weixin.qq.com/connect/oauth2/authorize?appid=CORPID&redirect_uri=REDIRECT_URI&response_type=RESPONSE_TYPE&scope=SCOPE&state=STATE#wechat_redirect";
	
	//公众号相关
	//获取access token
	//private static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	//新增临时素材
	private static final String UPLOAD_URL = "https://api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE";
	//自定义菜单创建接口
	//private static final String CREATE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
	//自定义菜单查询接口
	private static final String QUERY_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";
	//自定义菜单删除接口
	private static final String DELETE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";
	//新增图文素材
	private static final String ADD_NEWSMESSAGE_URL = "https://api.weixin.qq.com/cgi-bin/media/uploadnews?access_token=ACCESS_TOKEN";
	//创建分组
	private static final String CREATE_GROUPS_URL = "https://api.weixin.qq.com/cgi-bin/groups/create?access_token=ACCESS_TOKEN";
	//查询分组
	private static final String QUERY_GROUPS_URL = "https://api.weixin.qq.com/cgi-bin/groups/get?access_token=ACCESS_TOKEN";
	//群发接口
	private static final String MASS_MESSAGE_URL = "https://api.weixin.qq.com/cgi-bin/message/mass/sendall?access_token=ACCESS_TOKEN";
	//群发预览接口
	private static final String MASS_PREVIEW_URL = "https://api.weixin.qq.com/cgi-bin/message/mass/preview?access_token=ACCESS_TOKEN";
	/**
	 * get请求
	 * @param url
	 * @return
	 * @throws ParseException
	 * @throws IOException
	 */
	public static JSONObject doGetStr(String url) throws ParseException, IOException{
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
	
	/**
	 * POST请求
	 * @param url
	 * @param outStr
	 * @return
	 * @throws ParseException
	 * @throws IOException
	 */
	public static JSONObject doPostStr(String url,String outStr) throws ParseException, IOException{
		DefaultHttpClient client = new DefaultHttpClient();
		HttpPost httpost = new HttpPost(url);
		JSONObject jsonObject = null;
		httpost.setEntity(new StringEntity(outStr,"UTF-8"));
		HttpResponse response = client.execute(httpost);
		String result = EntityUtils.toString(response.getEntity(),"UTF-8");
		jsonObject = JSONObject.fromObject(result);
		return jsonObject;
	}

	public static JSONObject doPostStrASCII(String url,String outStr) throws ParseException, IOException{
		DefaultHttpClient client = new DefaultHttpClient();
		HttpPost httpost = new HttpPost(url);
		JSONObject jsonObject = null;
		httpost.setEntity(new StringEntity(outStr,"ASCII"));
		HttpResponse response = client.execute(httpost);
		String result = EntityUtils.toString(response.getEntity(),"ASCII");
		jsonObject = JSONObject.fromObject(result);
		return jsonObject;
	}

	/**
	 * 文件上传
	 * @param filePath
	 * @param accessToken
	 * @param type
	 * @return
	 * @throws IOException
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchProviderException
	 * @throws KeyManagementException
	 */
	public static String upload(String filePath, String accessToken,String type) throws IOException, NoSuchAlgorithmException, NoSuchProviderException, KeyManagementException {
		File file = new File(filePath);
		if (!file.exists() || !file.isFile()) {
			throw new IOException("文件不存在");
		}

		String url = UPLOAD_URL.replace("ACCESS_TOKEN", accessToken).replace("TYPE",type);
		
		URL urlObj = new URL(url);
		//连接
		HttpURLConnection con = (HttpURLConnection) urlObj.openConnection();

		con.setRequestMethod("POST"); 
		con.setDoInput(true);
		con.setDoOutput(true);
		con.setUseCaches(false); 

		//设置请求头信息
		con.setRequestProperty("Connection", "Keep-Alive");
		con.setRequestProperty("Charset", "UTF-8");

		//设置边界
		String BOUNDARY = "----------" + System.currentTimeMillis();
		con.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + BOUNDARY);

		StringBuilder sb = new StringBuilder();
		sb.append("--");
		sb.append(BOUNDARY);
		sb.append("\r\n");
		sb.append("Content-Disposition: form-data;name=\"file\";filename=\"" + file.getName() + "\"\r\n");
		sb.append("Content-Type:application/octet-stream\r\n\r\n");

		byte[] head = sb.toString().getBytes("utf-8");

		//获得输出流
		OutputStream out = new DataOutputStream(con.getOutputStream());
		//输出表头
		out.write(head);

		//文件正文部分
		//把文件已流文件的方式 推入到url中
		DataInputStream in = new DataInputStream(new FileInputStream(file));
		int bytes = 0;
		byte[] bufferOut = new byte[1024];
		while ((bytes = in.read(bufferOut)) != -1) {
			out.write(bufferOut, 0, bytes);
		}
		in.close();

		//结尾部分
		byte[] foot = ("\r\n--" + BOUNDARY + "--\r\n").getBytes("utf-8");//定义最后数据分隔线

		out.write(foot);

		out.flush();
		out.close();

		StringBuffer buffer = new StringBuffer();
		BufferedReader reader = null;
		String result = null;
		try {
			//定义BufferedReader输入流来读取URL的响应
			reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String line = null;
			while ((line = reader.readLine()) != null) {
				buffer.append(line);
			}
			if (result == null) {
				result = buffer.toString();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				reader.close();
			}
		}

		JSONObject jsonObj = JSONObject.fromObject(result);
		System.out.println(jsonObj);
		String typeName = "media_id";
		if(!"image".equals(type)){
			typeName = type + "_media_id";
		}
		String mediaId = jsonObj.getString(typeName);
		return mediaId;
	}
	
	/**
	 * 从微信获取accessToken
	 * @return
	 * @throws ParseException
	 * @throws IOException
	 */
	public static AccessToken getAccessToken() throws ParseException, IOException{
		AccessToken token = new AccessToken();
		//公众号
//		String url = ACCESS_TOKEN_URL.replace("APPID", APPID).replace("APPSECRET", APPSECRET);
		//企业号
		String url = ACCESS_TOKEN_URL.replace("CORPID", CORPID).replace("CORPSECRET", CORPSECRET);
		JSONObject jsonObject = doGetStr(url);
		//System.out.println(jsonObject.toString());
		if(jsonObject!=null){
			token.setToken(jsonObject.getString("access_token"));
			token.setExpiresIn(jsonObject.getInt("expires_in"));
		}
		return token;
	}

	/**
	 * 从本地获取accessToken
	 * @return
	 * @throws ParseException
	 * @throws IOException
	 */
	public static AccessToken getAccessTokenByLocal() throws ParseException, IOException{
		AccessToken token = new AccessToken();
		try {
			//获取accessToken存放路径
			String AccessTokenPath = PropertiesTool.getSystemPram("AccessTokenPath");
			FileInputStream fis = new FileInputStream(AccessTokenPath + "AccessToken.out");
			ObjectInputStream ois = new ObjectInputStream(fis);		
			token = (AccessToken)ois.readObject();
			System.out.println("反序列化成功----");		
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return token;
	}
	
	public static int createMenu(String token,String menu) throws ParseException, IOException{
		int result = 0;
		//公众号
		//String url = CREATE_MENU_URL.replace("ACCESS_TOKEN", token);
		//企业号
		String url = CREATE_MENU_URL.replace("ACCESS_TOKEN", token).replace("AGENTID", "0");
		JSONObject jsonObject = doPostStr(url, menu);
		if(jsonObject != null){
			System.out.println(jsonObject.toString());
			result = jsonObject.getInt("errcode");
			System.out.println("错误原因："+jsonObject.getString("errmsg"));
		}
		return result;
	}
	
	public static JSONObject queryMenu(String token) throws ParseException, IOException{
		String url = QUERY_MENU_URL.replace("ACCESS_TOKEN", token);
		JSONObject jsonObject = doGetStr(url);
		return jsonObject;
	}
	
	public static int deleteMenu(String token) throws ParseException, IOException{
		String url = DELETE_MENU_URL.replace("ACCESS_TOKEN", token);
		JSONObject jsonObject = doGetStr(url);
		int result = 0;
		if(jsonObject != null){
			result = jsonObject.getInt("errcode");
		}
		return result;
	}
	
	/**
	 * 生成二维码
	 * @return Name
	 * @throws ParseException
	 * @throws IOException
	 */
	public static String getQRCodeByUrl(String url){
		//生成二维码的名字
		String QRCodeName = BeanUtil.createId() + ".jpg";
		//从配置文件读取二维码存放路径
		String QRCodePath = PropertiesTool.getSystemPram("QRCodePath");

		String path = QRCodePath +  QRCodeName;
		int width = 300;
		int height = 300;
		//二维码的图片格式
		String format = "jpg";
		@SuppressWarnings("rawtypes")
		Hashtable hints = new Hashtable();
		//内容所使用编码
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		@SuppressWarnings("unchecked")
		BitMatrix bitMatrix;
		try {
			bitMatrix = new MultiFormatWriter().encode(url,
					BarcodeFormat.QR_CODE, width, height, hints);
		
			//生成二维码
			File outputFile = new File(path);
			try {
				MatrixToImageWriter.writeToFile(bitMatrix, format, outputFile);
				System.out.println(url+"\n"+"二维码生成成功");
				StringBuffer sb = new StringBuffer();
				//sb.append(PropertiesTool.getSystemPram("imgRoute"));
				sb.append(QRCodeName);
				return sb.toString();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("生成二维码出错");
				return "";
			}
		} catch (WriterException e) {
			e.printStackTrace();
			System.out.println("生成二维码出错");
			return "";
		}
		
	}
	/**
	 * 新增图文素材
	 * @param token
	 * @param menu
	 * @return
	 * @throws ParseException
	 * @throws IOException
	 */
	public static JSONObject addNewsMessage(String token, String menu) throws ParseException, IOException{
		String url = ADD_NEWSMESSAGE_URL.replace("ACCESS_TOKEN", token);
		JSONObject jsonObject = doPostStr(url, menu);
		return jsonObject;
	}
	/**
	 * 新建群组
	 * @param token
	 * @param groupsName
	 * @return
	 * @throws ParseException
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public static JSONObject creatGroups(String token, String groupsName) throws ParseException, IOException{
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> names = new HashMap<String, Object>();
		names.put("name", groupsName);
		map.put("group", names);
		Map<String, Object> result = new HashMap<String, Object>();
		String url = CREATE_GROUPS_URL.replace("ACCESS_TOKEN", token);
		JSONObject jsonObject = doPostStr(url, JSONObject.fromObject(map).toString());
		return jsonObject;
	}

	public static JSONObject queryGroups(String token) throws ParseException, IOException{
		String url = QUERY_GROUPS_URL.replace("ACCESS_TOKEN", token);
		JSONObject jsonObject = doGetStr(url);
		return jsonObject;
	}
	
	/**
	 * 群发接口
	 * @param token
	 * @param massMessage
	 * @return
	 * @throws ParseException
	 * @throws IOException
	 */
	public static int massMessage(String token, String massMessage) throws ParseException, IOException{
		String url = MASS_MESSAGE_URL.replace("ACCESS_TOKEN", token);
		JSONObject jsonObject = doPostStr(url, massMessage);
		System.out.println(jsonObject.toString());
		return jsonObject.getInt("errcode");
	}
	
	/**
	 * 群发预览
	 * @param token
	 * @param massMessage
	 * @return
	 * @throws ParseException
	 * @throws IOException
	 */
	public static JSONObject massPreview(String token, String massMessage) throws ParseException, IOException{
		String url = MASS_PREVIEW_URL.replace("ACCESS_TOKEN", token);
		JSONObject jsonObject = doPostStr(url, massMessage);
		System.out.println(jsonObject.toString());
		return jsonObject;
	}
}
