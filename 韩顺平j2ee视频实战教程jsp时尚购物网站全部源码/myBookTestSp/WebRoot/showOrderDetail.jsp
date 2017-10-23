<%@ page language="java" import="java.util.*,com.sp.model.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
ArrayList al=(ArrayList)request.getAttribute("detail");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showOrderDetail.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/my.css">
	

  </head>
  
  <body topmargin="0"  background="images/myBack.jpg">
  <center>
  <table width="70%" border="1" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td align="center">
    <jsp:include flush="true" page="head.jsp"></jsp:include>
    </td>
  </tr>
  <tr>
    <td><table width="70%" border="1" align="center" cellpadding="0" cellspacing="0" class="comm">
      <tr>
        <td align="center">订单号</td>
        <td align="center">商品的名称</td>
        <td align="center">价格</td>
        <td align="center">数量</td>
      </tr>
      <%
  	for(int i=0;i<al.size();i++){
  	OrderDetailBean odb=(OrderDetailBean)al.get(i);
  	%>
  	<tr>
    <td align="center"><%=odb.getOrderId() %></td>
    <td align="center"><%=odb.getGoodsName() %></td>
    <td align="center">¥<%=odb.getPrice() %></td>
    <td align="center"><%=odb.getNums() %></td>
  </tr>
  	<%
  	
  	}
  
   %>
      <tr>
        <td colspan="4">订单的总价: ¥</td>
        </tr>
    </table></td>
  </tr>
  <tr>
    <td align="center">
    <jsp:include flush="true" page="foot.jsp"></jsp:include>
    </td>
  </tr>
</table>
</center>
  </body>
</html>
