package com.sp.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserBeanBo {

	private Connection ct=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	
	//用户名返回一个用户的全部信息
	public UserBean getUserBean (String username){
		
		
		UserBean ub=new UserBean();
		
		try {
			
			
			String sql="select * from users where username=?";
			
			ct=new ConnDB().getConn();
			ps=ct.prepareStatement(sql);
			ps.setString(1, username);
			rs=ps.executeQuery();
			
			if(rs.next()){
				
				ub.setUserid(rs.getInt(1));
				ub.setUsername(rs.getString(2));
				ub.setTruename(rs.getString(3));
				ub.setPasswd(rs.getString(4));
				ub.setEmail(rs.getString(5));
				ub.setPhone(rs.getString(6));
				ub.setAddress(rs.getString(7));
				ub.setGrade(rs.getInt(8));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally{
			
			this.close();
		}
		return ub;
	}
	
	
	//用户登录验证
	
	public boolean checkUser(String u,String p){
		
		boolean b=false;
		try {
			
			String sql="select passwd from users where username=?";
			ct=new ConnDB().getConn();
			ps=ct.prepareStatement(sql);
			ps.setString(1, u);
			rs=ps.executeQuery();
			
			if(rs.next()){
				
				
				//得到数据库中的密码
				String passwd=rs.getString(1);
				if(passwd.equals(p)){
					
					b=true;
				}
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
