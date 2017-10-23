<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<table width="100%" border="1" cellpadding="0" cellspacing="0" class="com">
  <tr>
    <td colspan="2">&nbsp;</td>
  </tr>
  <tr>
    <td width="20%" height="190" rowspan="8"><img src="images/01.jpg" width="136" height="169" /></td>
    <td width="80%" align="center">Java 编程思想</td>
  </tr>
  <tr>
    <td>价格：¥108.0</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>ISBN: 711121382</td>
  </tr>
  <tr>
    <td>类型：计算机</td>
  </tr>
  <tr>
    <td>出版商：机械工业出版社</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td height="76" valign="bottom"><p>简介：本书赢得了全球程序员的广泛赞誉，即使是最晦涩的概念，在Bruce   Eckel的文字亲和力和小而直接的编程示例面前也会化解于无形。从Java的基础语法到最高级特性（深入的面向对象概念、多线程、自动项目构建、单元测试和调试等），本书都能逐步指导你轻松掌握。</p></td>
  </tr>
  <tr>
    <td colspan="2"><label>
      <input type="submit" class="com"  name="Submit" value="购买" />
      <input type="submit" class="com" name="Submit2" value="返回购物大厅" />
    </label></td>
  </tr>
  <tr>
    <td colspan="2">&nbsp;</td>
  </tr>
</table>
