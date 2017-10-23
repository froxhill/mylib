package com.hsp.view;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;


import com.hsp.domain.IdCard;
import com.hsp.domain.Person;

import com.hsp.util.HibernateUtil;

public class TestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//���һ��Person/idcard
		
		Session s=null;
		Transaction tx=null;
		
		try {
			//����ʹ�û���ģ��������.
			s=HibernateUtil.getCurrentSession();
			tx=s.beginTransaction();
		
			Person p1=new Person();
			p1.setId(1234);
			p1.setName("˳ƽ");
			IdCard idCard=new IdCard();
			idCard.setId(1900);
			idCard.setValidateDte(new Date());
			
			idCard.setPerson(p1);//��ʾidCard����������p1�������.
			s.save(p1);//�ȱ�����
			s.save(idCard);
			
			tx.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();
			}
		}finally{
			
			if(s!=null && s.isOpen()){
				s.close();
			}
		}
		
		
	
		
		
	}

	

}
