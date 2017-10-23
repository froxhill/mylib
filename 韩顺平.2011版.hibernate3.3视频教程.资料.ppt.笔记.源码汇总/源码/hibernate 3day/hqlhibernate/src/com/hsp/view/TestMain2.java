package com.hsp.view;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.hsp.util.*;
import com.sina.domain.Course;
import com.sina.domain.Studcourse;
import com.sina.domain.Student;
public class TestMain2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//��������ʹ����ǿ��HibernateUtil�����curd.
	/*	String hql="select sname,saddress from Student where sdept=? and sage>?";
		String parameters[]={"�����ϵ","3"};
		List<Object[]> list= HibernateUtil.executeQuery(hql,parameters);
		for(Object[] s: list){
			System.out.println(s[0].toString()+" "+s[1].toString());
		}*/
		
		//ʹ�ù��߷�ҳ
	/*	String hql="select sname,saddress from Student order by sage";
		String parameters[]=null;
		List<Object[]> list= HibernateUtil.
		executeQueryByPage(hql, parameters, 2, 3) ;
		for(Object[] s: list){
			System.out.println(s[0].toString()+" "+s[1].toString());
		}*/
		
		/*���*/
	/*	Course c=new Course();
		c.setCname("servlet");
		c.setCid(4L);
		HibernateUtil.save(c);*/
		
		//�����޸�/ɾ��
	/*	String hql="update Student set sage=sage+1 where sdept=?";
		String parameters[]={"�����ϵ"};
		try {
			HibernateUtil.executeUpdate(hql, parameters);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			// TODO: handle exception
		}*/
		//����ʾ����ѡ����21�ſγ̵�ѧ����Ϣ
	/*	String hql="select student.sname,student.sdept from Studcourse where course.cid=?";
		String parameters[]={"21"};
		List<Object[]> list=HibernateUtil.executeQuery(hql, parameters);
		for(Object[] s:list){
			System.out.println(s[0].toString()+" "+s[1].toString());
		}*/
		
	/*	String hql="from Studcourse where course.cid=21";
		List<Studcourse> list=HibernateUtil.executeQuery(hql, null);
		//������������һ���½����.
		for(Studcourse sc:list){
			System.out.println(sc.getGrade()+sc.getStudent().getSname());
		}*/

		//��ѯ�������10���ѧ�� criteria
		
		Session s=HibernateUtil.getCurrentSession();
		Transaction tx=s.beginTransaction();
		Criteria cri=s.createCriteria(Student.class);
		//��Ӽ�������
		cri.add(Restrictions.gt("sage", new Long(10)));
		List<Student> list=cri.list();
		for(Student s1: list){
			System.out.println(s1.getSname());
		}
		
		tx.commit();
	}

}
