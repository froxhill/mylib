package com.hsp.view;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hsp.domain.Department;
import com.hsp.domain.Student;
import com.hsp.util.HibernateUtil;

public class TestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		//ͨ����ȡһ��sesion,��hibernate�������(config->����hibernate.cfg.xml)
		Session s=null;
		Transaction tx=null;
		
		try {
			//����ʹ�û���ģ��������.
			s=HibernateUtil.getCurrentSession();
			tx=s.beginTransaction();
			
			//��ѯ����1�Ų��ŵ�ѧ��
			String hql="from Student where dept.id=1";
			
			tx.commit();
			
		} catch (Exception e) {
			if(tx!=null){
				tx.rollback();
			}
		}finally{
			
			if(s!=null && s.isOpen()){
				s.close();
			}
		}
		
	
		
		
	}

	//��ȡĳ��ѧ��
	public static Student getStudent() {
		// TODO Auto-generated method stub
		//ͨ����ȡһ��sesion,��hibernate�������(config->����hibernate.cfg.xml)
		Session s=null;
		Transaction tx=null;
		Student student1=null;
		try {
			//����ʹ�û���ģ��������.
			s=HibernateUtil.getCurrentSession();
			tx=s.beginTransaction();
			
			//��ѯ3��ѧ��
			student1=(Student) s.get(Student.class, 3);
			//��ʾ��ʼ���������
			//Hibernate.initialize(student1.getDept());
			//System.out.println(student1.getName()+" ���ڲ���="
			//		+student1.getDept().getName());//session����.
			tx.commit();
			
		} catch (Exception e) {
			if(tx!=null){
				tx.rollback();
			}
		}finally{
			
			if(s!=null && s.isOpen()){
				s.close();
			}
		}
		
		return student1;
	}

	public static void add() {
		// TODO Auto-generated method stub
		//ͨ����ȡһ��sesion,��hibernate�������(config->����hibernate.cfg.xml)
		Session s=null;
		Transaction tx=null;
		try {
			//����ʹ�û���ģ��������.
			s=HibernateUtil.getCurrentSession();
			tx=s.beginTransaction();
			//���3��ѧ�����Ͳ���,����Ҫ��ѧ�����䵽�ò���
			Student stu=new Student();
			stu.setName("�ν�8");
			Student stu2=new Student();
			stu2.setName("�ֳ�8");
			Department d=new Department();
			d.setName("����8");
			Department d2=new Department();
			d2.setName("���²�8");
			stu.setDept(d);//ָ����ѧ�����ĸ�����
			stu2.setDept(d2);
			//����ȱ���ѧ��
			s.save(stu);
			s.save(d);
			s.save(stu2);
			s.save(d2);
			
			//С����:Ӧ���ȱ����������ٱ���Ӷ���
			
			tx.commit();
			
		} catch (Exception e) {
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
