//package com.sapient.util;
//
//import javax.persistence.EntityManager;
//
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class HibernateConfigUtil {
//	
//	@Autowired
//	private EntityManager entitymanager;
//
//	@Bean
//	public SessionFactory getSessionFactory() throws Exception {
//		if(entitymanager.unwrap(SessionFactory.class)==null) {
//			throw new Exception("factory is not hibernate factory");
//		}
//		return entitymanager.unwrap(SessionFactory.class);
//	}
//}
