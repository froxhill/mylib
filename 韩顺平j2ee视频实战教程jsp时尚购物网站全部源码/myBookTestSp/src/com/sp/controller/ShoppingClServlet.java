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

		//�õ�bookId,��Ҫ����Ļ�����ӵ����ﳵ
		String goodsId=request.getParameter("goodsIdSp");
		
		//��session��ȡ������
		MyCart mc=(MyCart)request.getSession().getAttribute("mycart");
		
		if(mc==null){
			
			//˵��û�е�¼��,��ʱ�Ϳ��Դ���һ�����ﳵ��������session
			mc=new MyCart();
			request.getSession().setAttribute("mycart", mc);
		}
		
		//���ﳵ�����ѡ�еĻ���
		mc.addGoods(goodsId, "1");
		
		//ȡ�����׼����ʾ
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
