package com.sprinngcore.standalone.collections;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		
		ApplicationContext con = new ClassPathXmlApplicationContext("config8.xml");
	Person person1=con.getBean("person1",Person.class);
	System.out.println(person1);
	System.out.println(person1.getFriends().getClass().getName());
	
	System.out.println("______________________________________");
	System.out.println(person1.getFeeStructure());
	System.out.println("+++++++++++++++++++++++++++++");
	System.out.println(person1.getProperties());
	}
}
