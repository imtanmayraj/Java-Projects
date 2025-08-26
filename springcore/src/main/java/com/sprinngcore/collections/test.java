package com.sprinngcore.collections;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    public static void main(String[] args) {
        // Load Spring Configuration
        ApplicationContext context = new ClassPathXmlApplicationContext("config2.xml"); // FIXED

        // Fetch Bean
        Emp emp1 = (Emp) context.getBean("emp1");

        // Print Details
        System.out.println("Employee Name: " + emp1.getName());
        System.out.println("Phones: " + emp1.getPhones());
        System.out.println("Addresses: " + emp1.getAddresses());
        System.out.println("courses:"+emp1.getCourses());
   
    
    System.out.println(emp1.getPhones().getClass().getName());
}
}
