package hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entities.Emp;


public class SessionFactoryTest {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		SessionFactory factory = cfg.configure().buildSessionFactory();
		Session session = factory.openSession();
		Emp emp = 
				(Emp)session.get(Emp.class, 10);
		System.out.println(emp.toString());
//		System.out.println(session);
	}
}
