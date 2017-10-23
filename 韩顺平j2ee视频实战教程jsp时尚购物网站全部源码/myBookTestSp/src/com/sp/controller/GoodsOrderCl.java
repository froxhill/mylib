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
		
		//�¶���,��ɶ���
		
		OrderBeanBo obb=new OrderBeanBo();
		
		//�õ�mycart
		MyCart mc=(MyCart)request.getSession().getAttribute("mycart");
		UserBean ub=(UserBean)request.getSession().getAttribute("loginUserinfo");
		obb.addOrder(ub.getUserid(), 0, mc.getAllPrice(),mc);
		
//		���͵����ʼ�
		SendMailToSomeone smts=new SendMailToSomeone();
	
		String mailbody="<table width=\"70%\" border=\"1\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" class=\"comm\">"+
		"<tr>"+
        "<td align=\"center\">������</td>"+
        "<td align=\"center\">��Ʒ������</td>"+
        "<td align=\"center\">�۸�</td>"+
        "<td align=\"center\">����</td>"+
        "</tr>";
		
		ArrayList al=obb.getOrderDetailBean(obb.getOrderId());
	  	for(int i=0;i<al.size();i++){
	  	OrderDetailBean odb=(OrderDetailBean)al.get(i);
	  	
	  		
	  	mailbody+="<tr>"+
	    "<td align=\"center\">"+odb.getOrderId()+"</td>"+
	    "<td align=\"center\">"+odb.getGoodsName()+"</td>"+
	    "<td align=\"center\">"+odb.getPrice()+"Ԫ</td>"+
	    "<td align=\"center\">"+odb.getNums()+"</td>"+
	    "</tr>";
	  	
	  	}
  
	  	mailbody+="</table>";
	  	//���͵���Ϊ��������İѶ������͵��ͻ�ע����ʼ��С�
	  
	//	smts.send("����ʱ�й������ж���", mailbody, "hanshunping@tsinghua.org.cn","ping-han@sohu.com","xxxx","smtp.sohu.com");
	
		//����������ϸ��Ϣ�õ�
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
