package com.hsp.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

final public class MySessionFactory {

	private static SessionFactory sessionFactory=null;
	
	private static Configuration configuration=null;
	static{
		configuration=new Configuration().configure();
		sessionFactory=configuration.buildSessionFactory();
	}
	
	private MySessionFactory(){};
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	
	
	
	
}
