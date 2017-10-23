<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <title>My JSP 'login.jsp' starting page</title>
  </head>
  
  <body>
   <h1>用户登录</h1>
   <form action="/messageboard/login.do?flag=login" method="post">
   u:<input type="text" name="name" /><br/>
   p:<input type="password" name="passwd"/><br/>
   <input type="submit" value="login" />
   </form>
  </body>
</html>
