package com.hsp.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//����һ��������,���Է���ȫ�µ�session
//���Կ��Է��غ��̰߳�session
public class HibernateUtil {

	private static SessionFactory sessionFactory =null;
	//��Щ����Ա�õ����̰߳󶨵�session,��ϣ����hibernate.cfg.xml����,
	//������ʹ�� ThreadLocal (�ֲ߳̾�ģʽ)
	private static ThreadLocal threadLocal=new ThreadLocal();
	
	static{
		try {
			sessionFactory=new Configuration().configure().buildSessionFactory();	
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e.getMessage());
			// TODO: handle exception
		}
		
	}
	private HibernateUtil(){};
	
	//����ȫ��session
	public static Session getSession(){
		return sessionFactory.openSession();
	}
	//����һ�����̰߳󶨵�session
	public static Session getThreadLocalSession(){
		//return sessionFactory.getCurrentSession();
		//�ȴ� threadLocatȡ������
		Session s=(Session) threadLocal.get();
		//���ȡ������,�ʹ���һ���µ�,
		//���ȡ�ĳ�������ֱ�ӷ���,
		if(s==null){
			s=sessionFactory.openSession();
			threadLocal.set(s);
		}
		return s;
	}
	
	//�رպ��̰߳󶨵�session
	public static void closeThreadLocalSession(){
		
		Session s=(Session) threadLocal.get();
		if(s!=null&&s.isOpen()){
			s.close();
			threadLocal.set(null);
		}
	}
	
}
