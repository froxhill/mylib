package com.hsp.view;



import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hsp.domain.Employee;
import com.hsp.util.HibernateUtil;

public class TestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//添加一条记录
		
		Session session=null;
		Transaction ts=null;
		try {
			session=HibernateUtil.getCurrentSession();
			ts=session.beginTransaction();
			Employee e=new Employee();
			e.setEmail("ggg");
			e.setHiredate(new Date());
			e.setName("abcd");
			session.persist(e);
			ts.commit();
		} catch (Exception e) {
			if(ts!=null){
				ts.rollback();
			}
			throw new RuntimeException(e.getMessage());
			// TODO: handle exception
		}finally{
			if(session!=null && session.isOpen()){
				session.close();
			}
		}
		
	}

}
