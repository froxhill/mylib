package com.hsp.view;



import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hsp.util.HibernateUtil;
import com.sina.domain.Studcourse;
import com.sina.domain.Student;

public class TestMain {

	public static void main(String[] args) {
		
		//�����Ǿ���˵��hqlʹ��
		Session session=null;
		Transaction tx=null;
		try {
			session=HibernateUtil.getCurrentSession();
			tx=session.beginTransaction();
			//���磬��ʾ����ѧ�����Ա������.
			Query query=session.createQuery("from Student where sdept=? and sage>?");
			
			query.setString(0, "�����ϵ");
			query.setString(1, "2");
			List <Student> list=query.list();
			for(int i=0;i<list.size();i++){
				Student s= list.get(i);
				System.out.println(s.getSname()+" "+s.getSage());
			}
			
			//����������20~22֮���ѧ��
			
		/*	List list=session.createQuery("select distinct sage,ssex,sname from Student where sage between 20 and 22").list();
			for(int i=0;i<list.size();i++){
				Object []  objs=(Object[]) list.get(i);
				System.out.println(objs[0].toString()+" "+objs[1].toString()+objs[2].toString());
			}*/
			
			//��ѯ�����ϵ������ϵ��ѧ����Ϣ
			
			/*List<Student> list=session.createQuery("from Student where sdept not in ('�����ϵ','����ϵ')").list();
			//ȡ��1. for ��ǿ
			for(Student s:list){
				System.out.println(s.getSname()+" "+s.getSaddress()+" "+s.getSdept());
			}
			*/
			//��ʾ����ϵ��ѧ����ƽ������
		/*	List<Object[]> list=session.createQuery("select avg(sage),sdept from  Student group by sdept").list();
			//ȡ��1. for ��ǿ
			for(Object[] obj:list){
				System.out.println(obj[0].toString()+" "+obj[1].toString());
			}*/
			
			//having��ʹ��
			//1.�Է����ѯ��Ľ��������ɸѡ:��������ʾ��������3��ϵ����
			//a. ��ѯ����ϵ�ֱ��ж���ѧ��.
			
	/*		List<Object[]> list=session.createQuery("select count(*) as c1,sdept from  Student group by sdept having count(*)>3").list();
			//ȡ��1. for ��ǿ
			for(Object[] obj:list){
				System.out.println(obj[0].toString()+" "+obj[1].toString());
			}*/
			
			//2��ѯŮ������200�˵�ϵ
			//a.��ѯ����ϵ��Ů���ж����
		/*	List<Object[]> list=session.
			createQuery("select count(*) as c1,sdept from  Student where ssex='F' group by sdept").list();
			//ȡ��1. for ��ǿ
			for(Object[] obj:list){
				System.out.println(obj[0].toString()+" "+obj[1].toString());
			}*/
			
			//		1.��ѯ�����ϵ��������?->������Ƿ��ص���һ������
			//��ʱ���ǵ�ȡ����ֱ��ȡ��list->object ������ list->Object[]
	/*		List<Object[]> list=session.
			createQuery("select sage from  Student where sdept='�����ϵ'").list();
			//ȡ��1. for ��ǿ
			for(Object obj:list){
				System.out.println(obj.toString());
			}*/
//					2.��ѯ��ѧ���Ƕ���?
/*			List<Object[]> list=session.
			createQuery("select sum(grade) from Studcourse").list();
			//ȡ��1. for ��ǿ
			for(Object obj:list){
				System.out.println(obj.toString());
			}*/
//					3.��ѯѡ��11�ſγ̵���߷ֺ���ͷ�.
/*			List<Object[]> list=session.
			createQuery("select 11,max(grade),min(grade) from Studcourse where course.cid=11").list();
			//ȡ��1. for ��ǿ
			for(Object[] obj:list){
				System.out.println(obj[0].toString()+" max="+obj[1].toString()+" min="+obj[2].toString());
			}*/
			//4.��ʾ���ƿ��Բ�����ѧ��������(Student-student)����Ŀ(Course-course)�ͷ���(Studcourse-studcourse)
			
		/*	List<Object[]> list=session.
			createQuery("select student.sname,course.cname,grade from Studcourse where grade>=60").list();
			//ȡ��1. for ��ǿ
			for(Object[] obj:list){
				System.out.println(obj[0].toString()+" "+obj[1].toString()+" "+obj[2].toString());
			}*/
			
			//���������Ŀ�������ѧ������.(ѧ����ϰ!)
			
			/*List<Object[]> list=session.
			createQuery("select count(*),student.sdept from Studcourse where grade<60 group by student.sdept").list();
			//ȡ��1. for ��ǿ
			for(Object[] obj:list){
				System.out.println(obj[0].toString()+" "+obj[1].toString());
			}*/
			
			//�밴��ѧ���������С->��ȡ����3����5��ѧ��
		/*	List<Student> list=session.createQuery
			("from Student  order by sage").setFirstResult(2)
			.setMaxResults(3).list();
			for(Student s: list){
				System.out.println(s.getSname()+" "+s.getSage());
			}*/
			
			
			
			tx.commit();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();
			}
			throw new RuntimeException(e.getMessage());
			// TODO: handle exception
		}finally{
			if(session!=null&&session.isOpen()){
				session.close();
			}
			
		}
		
	}
	
	//��ҳ����
	private static void showResultByPage(int pageSize){
		//���÷�ҳ�ı���
		int pageNow=1;
		int pageCount=1;//����
		int rowCount=1;//�����Ҫ��ѯ
		
		Session session=null;
		Transaction tx=null;
		try {
			session=HibernateUtil.getCurrentSession();
			tx=session.beginTransaction();
			
			//��ѯ��rowcount
			rowCount=Integer.parseInt(session.createQuery("select count(*) from Student").uniqueResult().toString());
			pageCount=(rowCount-1)/pageSize+1;
			
			//�������ǿ���ѭ������ʾÿҳ����Ϣ
			for(int i=1;i<=pageCount;i++){
				System.out.println("************��"+i+"ҳ************");
				List<Student> list=session.createQuery("from Student").setFirstResult((i-1)*pageSize)
				.setMaxResults(pageSize).list();
				for(Student s: list){
					System.out.println(s.getSname()+" "+s.getSdept());
				}
				
			}
			
			tx.commit();
			
		}catch(Exception e){
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();
			}
			throw new RuntimeException(e.getMessage());
		}finally{
			if(session!=null&&session.isOpen()){
				session.close();
			}
		}
		
	}
	

	private static void query2() {
		//�����Ǿ���˵��hqlʹ��
		Session session=null;
		Transaction tx=null;
		try {
			session=HibernateUtil.getCurrentSession();
			tx=session.beginTransaction();
			//hql
			//1.������ѧ�����ֺ�����ϵ
			//ԭ��: �ڽ���jdbc������˵���� Ҫ��ѯʲô�ֶξͲ�ѯʲô�ֶΣ���Ҫselect * from ��
			//������hibernate ,������ʵ���Բ���ѭ�������,�������ǰ�������������Զ���ѯ
			//�������ǻ���Ҫ�������ȡ����������
			
			
			List list=session.createQuery("select sname,sdept from Student").list();
			
			for(int i=0;i<list.size();i++){
				Object []  objs=(Object[]) list.get(i);
				System.out.println(objs[0].toString()+" "+objs[1].toString());
			}
			System.out.println("****************");
			//���ʹ��iterator
			Iterator it=list.iterator();
			while(it.hasNext()){
				Object [] objs=(Object[]) it.next();
				System.out.println(objs[0].toString()+" "+objs[1].toString());
			}
			
			tx.commit();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();
			}
			throw new RuntimeException(e.getMessage());
			// TODO: handle exception
		}finally{
			if(session!=null&&session.isOpen()){
				session.close();
			}
			
		}
	}

	public static void query1() {
		//�����Ǿ���˵��hqlʹ��
		Session session=null;
		Transaction tx=null;
		try {
			session=HibernateUtil.getCurrentSession();
			tx=session.beginTransaction();
			//hql
			//1.�������е�ѧ��
			List<Student> list=session.createQuery("from Student").list();
			//ȡ��1. for ��ǿ
			for(Student s:list){
				System.out.println(s.getSname()+" "+s.getSaddress());
			}
			System.out.println("*****************");
			//2. ʹ��iterator
			Iterator<Student> iterator=list.iterator();
			while(iterator.hasNext()){
				Student s=iterator.next();
				System.out.println(s.getSname()+" "+s.getSage());
			}
			
			tx.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();
			}
			throw new RuntimeException(e.getMessage());
			// TODO: handle exception
		}finally{
			if(session!=null&&session.isOpen()){
				session.close();
			}
			
		}
	}
}
