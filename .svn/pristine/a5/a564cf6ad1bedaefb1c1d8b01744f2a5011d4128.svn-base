package com.cqut.controller.WeChatAccess;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.cqut.entity.TextMessage.TextMessage;
import com.thoughtworks.xstream.XStream;

public class MessageUtill {
	public static final String MESSAGE_TEXT="text";
	public static final String MESSAGE_IMAGE="image";
	public static final String MESSAGE_VOICE="voice";
	public static final String MESSAGE_VIDEO="video";
	public static final String MESSAGE_LINK="link";
	public static final String MESSAGE_LOCATION="location";
	public static final String MESSAGE_EVENT="event";
	public static final String MESSAGE_SUBSRCIBE="subscribe";
	public static final String MESSAGE_UNSUBSRCIBE="unsubscribe";
	public static final String MESSAGE_CLICK="CLICK";
	public static final String MESSAGE_VIEW="VIEW";
	/**
	 * xml转为map集合
	 * 
	 * @param request
	 * @return
	 * @throws IOException
	 * @throws DocumentException
	 */
	public static Map<String, String> xmlToMap(HttpServletRequest request)
			throws IOException, DocumentException {
		Map<String, String> map = new HashMap<String, String>();
		SAXReader reader = new SAXReader();
		// 从requert中取出输入流
		InputStream ins = request.getInputStream();
		Document doc = reader.read(ins);
		// 获取xml根元素
		Element root = doc.getRootElement();
		// 获取节点名
		List<Element> list = root.elements();
		for (Element e : list) {
			map.put(e.getName(), e.getText());
		}
		ins.close();
		return map;
	}

	/**
	 * 将文本消息对象转化为xml
	 * 
	 * @param textMessage
	 *            消息对象
	 * @return 消息对象转为的XML
	 */
	public static String textMessageToXml(TextMessage textMessage) {
		XStream xStream = new XStream();
		// 将xml根节点替换为xml，否则根节点会是TextMessage的权限名
		xStream.alias("xml", textMessage.getClass());
		return xStream.toXML(textMessage);
	}
	
	public static String initText(String fromUserName,String toUserName,String content){
		TextMessage textMessage=new TextMessage();
		textMessage.setFromUserName(toUserName);
		textMessage.setToUserName(fromUserName);
		textMessage.setMsgType(MESSAGE_TEXT);
		textMessage.setCreateTime(String.valueOf(new Date().getTime()));
		textMessage.setContent(content);
		return textMessageToXml(textMessage);
	}
}
