<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" contentType="text/html;charset=GB2312"%> 
<html>
<body>
<% 
try{
request.setCharacterEncoding("utf-8"); 
String mywords=request.getParameter("message");
String t="";
if(application.getAttribute("words")==null && mywords!=null){
t= (String)request.getRemoteAddr() + ":" + mywords + "<br/>";
application.setAttribute("words",(Object)t);
out.println(t);
}
else if(mywords!=null){
t=(String)application.getAttribute("words");
t += (String)request.getRemoteAddr() + ":" + mywords + "<br/>";
application.setAttribute("words",(Object)t);
out.println(t);
}
}
catch(Exception e){
}
%>
<form method="post" action="index.jsp" > 
<input name="message" type="text" size=50 >
<input type="submit" value="发送消息" > 
</form> 
</body></html>