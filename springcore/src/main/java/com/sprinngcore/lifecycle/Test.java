package com.sprinngcore.lifecycle; // ✅ Fixed package name

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	
    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("config5.xml");
//        System.out.println("++++++++++++++++Lifecycle using xml++++++++++++++");
//        Samosa s1 = (Samosa) context.getBean("s1");
//        System.out.println(s1);
//        
       context.registerShutdownHook(); // ✅ Ensures destroy methods are called
//    
//    System.out.println("++++++++++++++++Lifecycle using interface++++++++++++++");
//    
//    Pepsi p1=(Pepsi)context.getBean("p1");
//    System.out.println(p1);
        
        Example eg=(Example)context.getBean("eg");
        System.out.println(eg);
    }
}
