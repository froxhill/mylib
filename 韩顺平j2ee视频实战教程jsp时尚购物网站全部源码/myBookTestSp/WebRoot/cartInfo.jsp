<%@ page language="java" import="java.util.*,com.sp.model.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//得到request的商品
ArrayList al=(ArrayList)request.getAttribute("mycartGoods");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'cartInfo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/my.css">
	

  </head>
  
  <body topmargin="0"  background="images/myBack.jpg">
  	<table width="80%" border="1" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="41" align="center">
    <jsp:include flush="true" page="head.jsp"></jsp:include>
    </td>
  </tr>
  <tr>
    <td height="67" align="center">
    <table width="100%" border="1" cellspacing="0" cellpadding="0">
  <tr>
    <td align="center"><img src="images/cartnavi-1.gif" width="599" height="49" /></td>
  </tr>
  <tr>
    <td align="center">
    <form action="???">
	<table width="100%"  border="1" cellpadding="0" cellspacing="0" class="com">
      <tr>
        <td  width="20%" align="center">编号</td>
        <td width="27%" align="center">名称</td>
        <td width="26%" align="center">单价</td>
        <td colspan="3">数量</td>
      </tr>
	 	<tr><td colspan="6" bgcolor="#CCCCCC" height="5"></td></tr>
      
      <%
      
      
      	for(int i=0;i<al.size();i++){
      		
      		//取出GoodsBean
      		GoodsBean gb=(GoodsBean)al.get(i);
      		%>
      		<tr>
	        <td align="center">1</td>
	        <td align="center"><a href="view.jsp?isbn=711121382"><%=gb.getGoodsName() %></a></td>
	        <td align="center">￥<%=gb.getGoodsPrice() %> </td>
	        <td width="10%"><input name="textfield" type="text" size="6" value="1" /></td>
	        <td width="10%" align="center"><a href="#">删除</a></td>
	        <td width="7%" align="center"><a href="#">查看</a></td>
     		</tr>
	  		<tr><td colspan="6" bgcolor="#CCCCCC" height="5"></td></tr>
      		<%
      	}
      
       %>
      
      <tr>
        <td>&nbsp;</td>
        <td align="center"><input type="submit" name="Submit" value="删除全部书籍" /></td>
        <td align="center"><input name="Submit2" type="submit" value="修 改 数 量" /></td>
        <td colspan="3">&nbsp;</td>
      </tr>
    </table>
	</form>
	</td>
  </tr>
  <tr>
    <td><table width="100%" border="1" cellspacing="0" cellpadding="0" class="com">
      <tr>
        <td width="49%" class="comm">您共选择了价值<span class="STYLE1">￥108.0</span>的商品,点<a href="index.jsp"> 此处 </a>继续购物。</td>
        <td width="51%" align="right"><a href="ComShopping" ><img border="0" src="images/cartnext.gif" width="87" height="19" /></a></td>
      </tr>
    </table></td>
  </tr>
</table>
    </td>
  </tr>
  <tr>
    <td height="56" align="center">
    <jsp:include flush="true" page="foot.jsp"></jsp:include>
    </td>
  </tr>
</table>
  </body>
</html>
