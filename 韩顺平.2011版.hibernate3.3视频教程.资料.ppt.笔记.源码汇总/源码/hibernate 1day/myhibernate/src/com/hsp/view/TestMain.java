package com.hsp.view;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hsp.domain.Employee;
import com.hsp.utils.MySessionFactory;

public class TestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		SessionFactory sessionFactory= MySessionFactory.getSessionFactory();
		Session session=sessionFactory.openSession();
		//查询可以不使用事务
		Employee emp=(Employee) session.load(Employee.class, 3);
		System.out.println(emp.getName()+" "+emp.getEmail());
		session.close();
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
		emp.setName("小名");
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
