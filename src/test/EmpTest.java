package test;

import java.math.BigDecimal;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import util.SessionUtil;
import entities.Emp;

public class EmpTest {
	
	@Test
	public void saveEmp() {
		Session session = 
				SessionUtil.getSession();
		session.beginTransaction();
		Emp emp = new Emp();
		emp.setEname("xiababa");
		emp.setAge(23);
		emp.setSalary(new BigDecimal(100.00));
		session.save(emp);
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	public void deleteEmp() {
		Session session = 
				SessionUtil.getSession();
		session.beginTransaction();
		String hql = "delete from Emp e where e.id = ?";
		Query query = session.createQuery(hql);
		query.setInteger(0, 11);
		query.executeUpdate();
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	public void updateEmp() {
		Session session = 
				SessionUtil.getSession();
		session.beginTransaction();
		Emp emp = 
				(Emp)session.get(Emp.class, 8);
		emp.setEname("lalala");
		session.update(emp);
		session.getTransaction().commit();
		session.close();
	}
	
}
