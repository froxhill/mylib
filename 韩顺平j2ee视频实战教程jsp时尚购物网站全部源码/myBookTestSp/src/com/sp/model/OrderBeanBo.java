package com.sp.model;
import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
public class OrderBeanBo {

	private Connection ct=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	private int orderId=0;
	
	
	public int getOrderId(){
		return  this.orderId;
	}
	//得到订单的详细信息
	public ArrayList getOrderDetailBean(int orderId){
		
		
		ArrayList al=new ArrayList();
		try {
			
			String sql="select distinct orderDetail.ordesIid,goods.goodsName,goods.goodsPrice ,orderDetail.nums"+
			" from orderDetail,goods where ordesIid=? and goods.goodsId in (Select orderDetail.goodsId from orderDetail where ordesIid=?)";
			
			ct=new ConnDB().getConn();
			
			ps=ct.prepareStatement(sql);
			ps.setInt(1, orderId);
			ps.setInt(2,orderId);
			
			rs=ps.executeQuery();
			
			while(rs.next()){
				
				
				OrderDetailBean odb=new OrderDetailBean();
				odb.setOrderId(rs.getInt(1));
				odb.setGoodsName(rs.getString(2));
				odb.setPrice(rs.getFloat(3));
				odb.setNums(rs.getInt(4));
				
				al.add(odb);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally{
			
			this.close();
		}
		return al;
	}
	
	//得到订单的信息
	public OrderInfoBean getOrderInfoBean(){
		
		OrderInfoBean oib=new OrderInfoBean();
		
		try {
			
			String sql="select ordersId ,truename,address,postcode,phone,totalPrice,username,email from users,orders"+ 
			" where ordersId=? and users.userid = (select orders.userid from orders where ordersId=?)";
			
			ct=new ConnDB().getConn();
			ps=ct.prepareStatement(sql);
			ps.setInt(1, this.orderId);
			ps.setInt(2, this.orderId);
			rs=ps.executeQuery();
			
			if(rs.next()){
				
				oib.setOrdersId(rs.getInt(1));
				oib.setTruename(rs.getString(2));
				oib.setAddress(rs.getString(3));
				oib.setPostcode(rs.getString(4));
				oib.setPhone(rs.getString(5));
				oib.setTotalPrice(rs.getFloat(6));
				oib.setUsername(rs.getString(7));
				oib.setEmail(rs.getString(8));
				
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally{
			
			this.close();
		}
		
		return oib;
	}
	
	
	//增加订单
	public boolean addOrder(int userId,int isPay,float totalPrice,MyCart mc){
		
		boolean b=false;
		String sql="insert into orders (userId,isPayed,totalPrice) values(?,?,?)";	
		try {
			
			ct=new ConnDB().getConn();
			
			ps=ct.prepareStatement(sql);
			ps.setInt(1, userId);
			ps.setInt(2, isPay);
			ps.setFloat(3, totalPrice);
			
			
			
			if(ps.executeUpdate()==1){
				
				//得到刚刚插入的id
				sql="select max(ordersId) id from orders";
				
				ps=ct.prepareStatement(sql);
				
				rs=ps.executeQuery();
				
				if(rs.next()){
					
					
					this.orderId=rs.getInt(1);
					
					//Statement .准备整体提交
					Statement sm=ct.createStatement();
					
					
					ArrayList al=mc.showAllMyCart();
					
					
					for(int i=0;i<al.size();i++){
						
						GoodsBean gb=(GoodsBean)al.get(i);
						//得到购物车中的id,和数量
						int goodsId=gb.getGoodsId();
						String num=mc.goodsNum(goodsId+"");
						
						sql="insert into orderDetail values('"+orderId+"','"+goodsId+"','"+num+"')";
						
						sm.addBatch(sql);
						
						
						
					}
					
					//整体提交
					int []re=sm.executeBatch();
					
					for(int i=0;i<re.length;i++){
						
						System.out.println("返回的结果是:"+re[i]);
					}
				}
				
				b=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally{
			
			this.close();
		}
		
		return b;
	}
	
//	关闭资源
	public void close(){
		
		try {
			
			if(rs!=null){
				
				rs.close();
				rs=null;
			}
			if(ps!=null){
				
				ps.close();
				ps=null;
			}
			if(ct!=null){
				
				ct.close();
				ct=null;
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
