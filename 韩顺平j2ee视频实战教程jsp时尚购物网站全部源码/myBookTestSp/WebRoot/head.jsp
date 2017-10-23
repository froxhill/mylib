<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="8" colspan="3" bgcolor="#FFCCCC"></td>
        </tr>
      <tr>
        <td width="24%" height="78"><img src="images/logo.gif" width="128" height="49" /></td>
        <td width="53%" align="center"><img src="images/test.gif" width="450" height="80" /></td>
        <td width="23%" align="center" class="com"><p><img src="images/account.gif" width="19" height="14" /><a href="register.jsp">【我的账号】</a></p>
          <p><img src="images/cart.gif" width="20" height="15" /><a href="">【我的购物】</a></p></td>
      </tr>
      <tr>
        <td height="8" colspan="3" bgcolor="#FFCCCC"></td>
        </tr>
      <tr>
        <td colspan="3"><table width="100%" border="0" cellpadding="0">
          <tr>
            <td>&nbsp;</td>
            <td width="15%" class="navi"><a href="index.jsp">首页</a></td>
            <td>&nbsp;</td>
            <td width="15%" class="navi">香港电影</td>
            <td>&nbsp;</td>
            <td width="15%" class="navi">大陆电影</td>
            <td>&nbsp;</td>
            <td width="15%" class="navi">关于我们</td>
            <td>&nbsp;</td>
          </tr>
        </table></td>
        </tr>
    </table>
