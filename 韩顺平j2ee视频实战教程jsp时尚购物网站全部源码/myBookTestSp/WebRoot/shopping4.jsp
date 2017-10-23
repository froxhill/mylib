<%@ page language="java" import="java.util.*,com.sp.model.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
OrderInfoBean oib=(OrderInfoBean)request.getAttribute("orderinfobean");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'shopping4.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/my.css">
	

  </head>
  
  <body topmargin="0"  background="images/myBack.jpg" >
    <table width="80%" border="1" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td align="center">
    <jsp:include flush="true" page="head.jsp"></jsp:include>
    </td>
  </tr>
  <tr>
    <td height="129" align="center"><table width="100%" height="100%" border="1" cellpadding="0" cellspacing="0" class="comm">
      <tr>
        <td colspan="9" align="center"><img src="images/cartnavi-4.gif" width="599" height="49" /></td>
      </tr>
      <tr>
        <td colspan="9" align="center">订单详细信息</td>
      </tr>
      <tr>
        <td width="9%" height="16" align="center">订单号</td>
        <td width="11%" align="center">收货人</td>
        <td width="14%">收货地址</td>
        <td width="8%">邮编</td>
        <td width="11%">电话</td>
        <td width="9%">总价</td>
        <td width="11%">用户名</td>
        <td width="20%">电子邮件</td>
        <td width="7%">&nbsp;</td>
      </tr>
      <tr>
        <td align="center"><%=oib.getOrdersId() %></td>
        <td align="center"><%=oib.getTruename() %></td>
        <td><%=oib.getAddress() %></td>
        <td><%=oib.getPostcode() %></td>
        <td><%=oib.getPhone() %></td>
        <td>¥<%=oib.getTotalPrice() %></td>
        <td><%=oib.getUsername() %></td>
        <td><%=oib.getEmail() %></td>
        <td><a href="ShowOrderDetail?orderId=<%=oib.getOrdersId() %>">查看详情</a></td>
      </tr>
      <tr>
        <td colspan="9" align="center"><br/>您的订单已经完成，服务器将在稍后时候向您的电子邮箱发送确认信息，并确认订单信息。</td>
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
