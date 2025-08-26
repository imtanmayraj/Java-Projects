package com.sprinngcore.auto.wire;
import com.sprinngcore.auto.wire.Emp; // ✅ Correct import

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//import com.sprinngcore.collections.Emp;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("config6.xml"); // FIXED

        // Fetch Bean
        Emp emp1= context.getBean("emp1",Emp.class);
        System.out.println(emp1);
	}
}
