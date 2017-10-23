package com.sp.controller;

import com.sp.model.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShoppingClServlet extends HttpServlet {

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

		//得到bookId,将要购买的货物添加到购物车
		String goodsId=request.getParameter("goodsIdSp");
		
		//从session中取出购物
		MyCart mc=(MyCart)request.getSession().getAttribute("mycart");
		
		if(mc==null){
			
			//说明没有登录过,这时就可以创建一个购物车，并放入session
			mc=new MyCart();
			request.getSession().setAttribute("mycart", mc);
		}
		
		//向购物车中添加选中的货物
		mc.addGoods(goodsId, "1");
		
		//取出货物，准备显示
		request.setAttribute("mycartGoods", mc.showAllMyCart());
		
		request.getRequestDispatcher("cartInfo.jsp").forward(request, response);
		
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
