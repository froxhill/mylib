package com.sp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sp.model.*;
public class UserLogin extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		//接收用户名和密码
		String u=MyTools.changeToGB2312(request.getParameter("textfield"));
		String p=request.getParameter("textfield2");
		
		
		
		
		
		
		UserBeanBo ubb=new UserBeanBo();
		
		if(ubb.checkUser(u, p)){
			//创建一个userbean,并放入到session
			UserBean ub=ubb.getUserBean(u);			
			request.getSession().setAttribute("loginUserinfo", ub);
			//把要显示的购物车商品内容放入request
			MyCart mc=(MyCart)request.getSession().getAttribute("mycart");
			request.setAttribute("mycartInfo", mc.showAllMyCart());
			request.getRequestDispatcher("shopping3.jsp").forward(request, response);
		}else{
			
			//返回页面
			request.getRequestDispatcher("shopping2.jsp").forward(request, response);
		}
		
		
		
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
