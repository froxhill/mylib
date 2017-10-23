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
		//使用Query 接口(PreparedStatement)，完成hql(sql)语句查询
		//hql入门案例,检索用户名是shunping的雇员
		Session session = null;
		Transaction ts=null;
		try {
			session=HibernateUtil.getThreadLocalSession();
			ts=session.beginTransaction();
			//这里大家一定要注意, hql语句是针对 类
			Query query=session.createQuery("from Employee where name='shunping'"); // PreparedStatement ps
			List<Employee> list=query.list(); // ResultSet rs=ps.executeQuery();rs->hibernte->list
			//增强for
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
		//		//get load 的区别是什么
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
		//删除一个雇员,先得到，再修改
		Transaction ts=session.beginTransaction();
		
		Employee emp=(Employee) session.load(Employee.class, 2);
		session.delete(emp);
		ts.commit();
	}

	//更新
	public static void updateEmp() {
		SessionFactory sessionFactory= MySessionFactory.getSessionFactory();
		Session session=sessionFactory.openSession();
		//修改一个雇员,先得到，再修改
		Transaction ts=session.beginTransaction();
		//load方法是用于获取 指定 主键的对象（记录.）
		Employee emp=(Employee)session.load(Employee.class, 1);
		emp.setName("小名");//update
		
		ts.commit();
	}
	
	//修改雇员
	

	//添加一个雇员
	private static void addEmpoyee() {
		//1.得到Configuration
		Configuration configuration= new Configuration().configure();
		//2.得到SessionFactory(会话工厂，这是一个重量级的类，因此要保证在一个应用程序中只能有一个)
		SessionFactory sessionFactory=configuration.buildSessionFactory();
		
		//3. 从SessionFactory中取出一个Session对象(它表示 和数据库的出一次会话)
		Session session=sessionFactory.openSession();
		//4. 开始一个事务
		Transaction transaction = session.beginTransaction();
		//保存一个对象到数据库(持久化一个对象)
		Employee emp=new Employee();
		emp.setEmail("kk@sohu.com");
		emp.setHiredate(new java.util.Date());
		emp.setName("shunping");
		//不要给id,因为它是自增的
		session.save(emp);//insert into employee (name,id,...) value(?,?,?)
		transaction.commit();
	}

}
