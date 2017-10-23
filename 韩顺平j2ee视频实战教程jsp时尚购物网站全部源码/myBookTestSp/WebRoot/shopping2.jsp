<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'shopping2.jsp' starting page</title>
     
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/my.css">
	

  </head>
  
  <body topmargin="0" background="images/myBack.jpg">
    <table width="80%" border="1" align="center" cellpadding="0" cellspacing="0" >
  <tr>
    <td align="center">
    <jsp:include flush="true" page="head.jsp"></jsp:include>
    </td>
  </tr>
  <tr>
    <td>
    <form action="UserLogin" method="post">
    <table width="100%" border="1" cellspacing="0" cellpadding="0" class="comm">
      <tr>
        <td align="center">
        <img src="images/cartnavi-2.gif">
        </td>
      </tr>
      <tr>
        <td align="center"><table  width="40%" border="1" cellpadding="0" cellspacing="0" bordercolor="#339900" class="comm">
          <tr>
            <td colspan="2" align="center">
            <img   src="images/dl.gif">
            </td>
          </tr>
          <tr>
            <td width="49%" align="right">用户名:</td>
            <td width="51%" align="left"><input name="textfield" type="text" class="comm" /></td>
          </tr>
          <tr>
            <td align="right">密码:</td>
            <td align="left"><input name="textfield2" type="text" class="comm" /></td>
          </tr>
          <tr>
            <td align="right"><input type="submit" name="Submit" value="用户登录" /></td>
            <td align="left"><input type="button" name="Submit2" value="用户注册" /></td>
          </tr>
        </table> 
        </form>
        </td>
      </tr>
      <tr>
        <td width="50%" align="right"><img src="images/cartnext.gif" width="87" height="19" /></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td align="center">
    <jsp:include flush="true" page="foot.jsp"></jsp:include>
    </td>
  </tr>
</table>
  </body>
</html>
