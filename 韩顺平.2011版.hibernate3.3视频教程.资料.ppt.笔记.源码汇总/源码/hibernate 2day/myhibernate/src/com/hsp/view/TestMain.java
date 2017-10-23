package com.hsp.view;

import java.sql.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hsp.domain.Employee;
import com.hsp.utils.*;
public class TestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		
		

	}



	public static void querytest() {
		//ʹ��Query �ӿ�(PreparedStatement)�����hql(sql)����ѯ
		//hql���Ű���,�����û�����shunping�Ĺ�Ա
		Session session = null;
		Transaction ts=null;
		try {
			session=HibernateUtil.getThreadLocalSession();
			ts=session.beginTransaction();
			//������һ��Ҫע��, hql�������� ��
			Query query=session.createQuery("from Employee where name='shunping'"); // PreparedStatement ps
			List<Employee> list=query.list(); // ResultSet rs=ps.executeQuery();rs->hibernte->list
			//��ǿfor
			for(Employee e: list){
				System.out.println(e.getEmail()+" "+e.getName()+" "+e.getId());
			}
			ts.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if(ts!=null){
				ts.rollback();
			}
			// TODO: handle exception
		}finally{
			
			if(session!=null&&session.isOpen()){
				session.close();
			}
		}
	}



	public static void getload() {
		//		//get load ��������ʲô
		//		
				Session session = null;
				Transaction ts=null;
				try {
					session=MySessionFactory.getSessionFactory().getCurrentSession();
					ts=session.beginTransaction();
					Employee emp=(Employee) session.get(Employee.class, 76);
				
					ts.commit();
				} catch (Exception e) {
					e.printStackTrace();
					if(ts!=null){
						ts.rollback();
					}
					// TODO: handle exception
				}finally{
					
					if(session!=null&&session.isOpen()){
						session.close();
					}
				}
	}

	
	
	public static void delEmp() {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory= MySessionFactory.getSessionFactory();
		Session session=sessionFactory.openSession();
		//ɾ��һ����Ա,�ȵõ������޸�
		Transaction ts=session.beginTransaction();
		
		Employee emp=(Employee) session.load(Employee.class, 2);
		session.delete(emp);
		ts.commit();
	}

	//����
	public static void updateEmp() {
		SessionFactory sessionFactory= MySessionFactory.getSessionFactory();
		Session session=sessionFactory.openSession();
		//�޸�һ����Ա,�ȵõ������޸�
		Transaction ts=session.beginTransaction();
		//load���������ڻ�ȡ ָ�� �����Ķ��󣨼�¼.��
		Employee emp=(Employee)session.load(Employee.class, 1);
		emp.setName("С��");//update
		
		ts.commit();
	}
	
	//�޸Ĺ�Ա
	

	//���һ����Ա
	private static void addEmpoyee() {
		//1.�õ�Configuration
		Configuration configuration= new Configuration().configure();
		//2.�õ�SessionFactory(�Ự����������һ�����������࣬���Ҫ��֤��һ��Ӧ�ó�����ֻ����һ��)
		SessionFactory sessionFactory=configuration.buildSessionFactory();
		
		//3. ��SessionFactory��ȡ��һ��Session����(����ʾ �����ݿ�ĳ�һ�λỰ)
		Session session=sessionFactory.openSession();
		//4. ��ʼһ������
		Transaction transaction = session.beginTransaction();
		//����һ���������ݿ�(�־û�һ������)
		Employee emp=new Employee();
		emp.setEmail("kk@sohu.com");
		emp.setHiredate(new java.util.Date());
		emp.setName("shunping");
		//��Ҫ��id,��Ϊ����������
		session.save(emp);//insert into employee (name,id,...) value(?,?,?)
		transaction.commit();
	}

}
