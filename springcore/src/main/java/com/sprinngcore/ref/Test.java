package com.sprinngcore.ref;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sprinngcore.collections.Emp;

public class Test {
public static void main(String []args) {
	ApplicationContext context = new ClassPathXmlApplicationContext("config3.xml"); 
	
  A temp1 = (A) context.getBean("aref");
  System.out.println(temp1.getX());
  
  System.out.println(temp1.getOb().getY());
  System.out.println(temp1);
  
}
}
 