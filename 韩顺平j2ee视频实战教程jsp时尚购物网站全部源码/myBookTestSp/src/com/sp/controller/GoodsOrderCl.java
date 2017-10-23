package com.sp.controller;
import com.sp.model.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GoodsOrderCl extends HttpServlet {

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
		
		//下订单,完成订单
		
		OrderBeanBo obb=new OrderBeanBo();
		
		//得到mycart
		MyCart mc=(MyCart)request.getSession().getAttribute("mycart");
		UserBean ub=(UserBean)request.getSession().getAttribute("loginUserinfo");
		obb.addOrder(ub.getUserid(), 0, mc.getAllPrice(),mc);
		
//		发送电子邮件
		SendMailToSomeone smts=new SendMailToSomeone();
	
		String mailbody="<table width=\"70%\" border=\"1\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" class=\"comm\">"+
		"<tr>"+
        "<td align=\"center\">订单号</td>"+
        "<td align=\"center\">商品的名称</td>"+
        "<td align=\"center\">价格</td>"+
        "<td align=\"center\">数量</td>"+
        "</tr>";
		
		ArrayList al=obb.getOrderDetailBean(obb.getOrderId());
	  	for(int i=0;i<al.size();i++){
	  	OrderDetailBean odb=(OrderDetailBean)al.get(i);
	  	
	  		
	  	mailbody+="<tr>"+
	    "<td align=\"center\">"+odb.getOrderId()+"</td>"+
	    "<td align=\"center\">"+odb.getGoodsName()+"</td>"+
	    "<td align=\"center\">"+odb.getPrice()+"元</td>"+
	    "<td align=\"center\">"+odb.getNums()+"</td>"+
	    "</tr>";
	  	
	  	}
  
	  	mailbody+="</table>";
	  	//发送的行为【这是真的把订单发送到客户注册的邮件中】
	  
	//	smts.send("你在时尚购物网有订单", mailbody, "hanshunping@tsinghua.org.cn","ping-han@sohu.com","xxxx","smtp.sohu.com");
	
		//将订单的详细信息得到
		OrderInfoBean oib=obb.getOrderInfoBean();
		request.setAttribute("orderinfobean", oib);
		request.getRequestDispatcher("shopping4.jsp").forward(request, response);
		
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
