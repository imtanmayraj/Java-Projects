package com.sprinngcore.ci;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;




public class Test {

	public static void main(String[] args) {
		
		 ApplicationContext context = new ClassPathXmlApplicationContext("config4.xml"); // FIXED

	        // Fetch Bean
	        Person p = (Person) context.getBean("person");
	        System.out.println(p);
	        
	        addition add= (addition) context.getBean("add");
	        add.dosum();
	
	}
}
