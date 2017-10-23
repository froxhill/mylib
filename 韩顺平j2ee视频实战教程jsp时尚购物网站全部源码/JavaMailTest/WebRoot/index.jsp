<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/my.css">
	
  </head>
  
  <body>
   <center>
   <table width="80%" border="1" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="126" colspan="2" align="center">head.jsp</td>
  </tr>
  <tr>
    <td width="21%" height="84" align="center">
    <jsp:include flush="true" page="left.jsp"></jsp:include>
    </td>
    <td width="78%" valign="top" align="center">
    <jsp:include flush="true" page="right.jsp"></jsp:include>
    </td>
  </tr>
  <tr>
    <td height="103" colspan="2" align="center">tail.jsp</td>
  </tr>
</table>
   </center>
  </body>
</html>
