package com.sina.util;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sina.domain.Users;
final public class HibernateUtil {
	private static SessionFactory sessionFactory=null;
	//ʹ���ֲ߳̾�ģʽ
	private static ThreadLocal<Session> threadLocal=new ThreadLocal<Session>();
	private HibernateUtil(){};
	static {
		sessionFactory=new Configuration().configure().buildSessionFactory();
	}
	
	//��ȡȫ�µ�ȫ�µ�sesession
	public static Session openSession(){
		return sessionFactory.openSession();
	}
	//��ȡ���̹߳�����session
	public static Session getCurrentSession(){
		
		Session session=threadLocal.get();
		//�ж��Ƿ�õ�
		if(session==null){
			session=sessionFactory.openSession();
			//��session�������õ� threadLocal,�൱�ڸ�session�Ѿ����̰߳�
			threadLocal.set(session);
		}
		return session;
		
		
	}
	
	//�ṩһ��ͳһ�Ĳ�ѯ����
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
			throw new RuntimeException("������");
			// TODO: handle exception
		}finally{
			if(session!=null&& session.isOpen()){
				session.close();
			}
		}
		return list;
	}
	
	
}
