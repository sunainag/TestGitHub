//package com.example.springboot;
//
//import static org.junit.Assert.*;
//import javax.transaction.Transactional;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.orm.hibernate4.HibernateTemplate;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.transaction.TransactionConfiguration;
//
//import com.concretepage.config.AppConfig;
//import com.concretepage.dao.IPersonDao;
//import com.concretepage.entity.Person;
//
//@RunWith(SpringJUnit4ClassRunner.class)
///*
// * Spring provides SpringJUnit4ClassRunner that implements the functionality of
// * JUnit4ClassRunner. JUnit4ClassRunner is provided by JUnit. In the demo @Test
// * is provided by SpringJUnit4ClassRunner.
// */
//@ContextConfiguration(classes = AppConfig.class)
///*
// * @ContextConfiguration annotation uses the application context being used in
// * the application. In our case, we are using AppConfig.java for bean
// * definition.
// */
//@TransactionConfiguration(defaultRollback = true)
///*
// * Suppose if transaction is completed successfully, and test case has finished
// * the data testing and then if we want to remove it from database, then
// * TransactionConfiguration annotation works. To achieve it defaultRollback must
// * be true.
// */
//@Transactional
///*
// * tells the test case that if transaction does not complete then revert other
// * transactions.
// */
//
//public class Spring4JUnit4Test {
//
//	private IPersonDao personDao;
//	private HibernateTemplate  hibernateTemplate;
//	
//	@Test
//	 public void savePersonTest(){
//		personDao.savePerson();
//		Person person = hibernateTemplate.get(Person.class, 1);
//		assertEquals("Ram", person.getName());
//	}
//
//}
