package com.sina.util;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sina.domain.Users;
final public class HibernateUtil {
	private static SessionFactory sessionFactory=null;
	//使用线程局部模式
	private static ThreadLocal<Session> threadLocal=new ThreadLocal<Session>();
	private HibernateUtil(){};
	static {
		sessionFactory=new Configuration().configure().buildSessionFactory();
	}
	
	//获取全新的全新的sesession
	public static Session openSession(){
		return sessionFactory.openSession();
	}
	//获取和线程关联的session
	public static Session getCurrentSession(){
		
		Session session=threadLocal.get();
		//判断是否得到
		if(session==null){
			session=sessionFactory.openSession();
			//把session对象设置到 threadLocal,相当于该session已经和线程绑定
			threadLocal.set(session);
		}
		return session;
		
		
	}
	
	//提供一个统一的查询方法
	public static List executeQuery(String hql){
		Session session=null;
		Transaction ts=null;
		List list=null;
		try {
			
			session=HibernateUtil.getCurrentSession();
			ts=session.beginTransaction();
			list= session.createQuery(hql).list();

			ts.commit();
			
			
		} catch (Exception e) {
			
			if(ts!=null){
				ts.rollback();
			}
			throw new RuntimeException("错误了");
			// TODO: handle exception
		}finally{
			if(session!=null&& session.isOpen()){
				session.close();
			}
		}
		return list;
	}
	
	
}
