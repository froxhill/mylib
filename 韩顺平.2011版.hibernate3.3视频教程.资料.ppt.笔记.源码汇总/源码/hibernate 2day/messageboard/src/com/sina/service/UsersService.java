package com.sina.service;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sina.domain.Users;
import com.sina.util.HibernateUtil;

public class UsersService {
	//��֤�û��Ƿ�Ϸ�
	public Users checkUser(Users users){
		
/*		Session session=null;
		Transaction ts=null;
		try {
			
			session=HibernateUtil.getCurrentSession();
			ts=session.beginTransaction();
			List<Users> list= session.createQuery("from Users where name='"
					+users.getName()+"' and passwd='"+users.getPasswd()+"'").list();
			
			if(list.size()==1){
				users=list.get(0);
			}else{
				users=null;
			}
			
			ts.commit();
			
			
		} catch (Exception e) {
			
			if(ts!=null){
				ts.rollback();
			}
			throw new RuntimeException("������");
			// TODO: handle exception
		}finally{
			if(session!=null&& session.isOpen()){
				session.close();
			}
		}
		return users;*/
		
		String hql="from Users where name='"
			+users.getName()+"' and passwd='"+users.getPasswd()+"'";
		List<Users>  list=HibernateUtil.executeQuery(hql);
		if(list.size()==1){
			return list.get(0);
		}else{
			return null;
		}
	}
}
