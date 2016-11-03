<%@ page contentType="text/html; charset=utf-8" language="java" 
pageEncoding="utf-8"%>
<html>
<head>
<title></title>
</head>

<body>
<form action="/HSServiceManageForSale/webApp/book/chatroom/method.jsp?action=sendMsg" method="post" name="form1">
<%=session.getAttribute("username")%>:
<input name="msg" type="text" id="msg" size="60">
  <input type="submit" name="Submit" value="发 言">
</form>
</body>
</html>
