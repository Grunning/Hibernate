package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionUtil {
	
	private static SessionFactory factory;
	//ThreadLocal 线程独占
	
	static {
		Configuration cfg = new Configuration();
		factory = 
				cfg.configure().buildSessionFactory();
	}
	
	public static Session getSession() {
		return factory.openSession();
	}
	
}
