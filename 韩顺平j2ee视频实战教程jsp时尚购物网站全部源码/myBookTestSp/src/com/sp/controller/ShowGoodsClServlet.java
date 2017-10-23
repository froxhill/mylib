package com.sp.controller;

import com.sp.model.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowGoodsClServlet extends HttpServlet {

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

		
		//接收type类型
		String type=request.getParameter("type");
		
		if(type.equals("fenye")){
			
			//接受pageNow,放入request
			String pageNow=request.getParameter("pageNow");
			
			System.out.println("pageNow==="+pageNow);
			request.setAttribute("now",pageNow );
			
			request.getRequestDispatcher("index.jsp").forward(request, response);
		
		}else if(type.equals("showDetail")){
			
			System.out.println("显示货物的具体信息");
			
			//接收货物的id
			String bookId=request.getParameter("goodsId");
			
			//创建一个GoodsBeanBo,去查询具体的
			GoodsBeanBo gbb=new GoodsBeanBo();
			
			request.setAttribute("goodsInfo", gbb.getGoodsBeanById(bookId));
			
			request.getRequestDispatcher("showDetail.jsp").forward(request, response);
			
			
			
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
