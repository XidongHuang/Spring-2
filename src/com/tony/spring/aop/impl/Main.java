package com.tony.spring.aop.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
public static void main(String[] args) {
	
	
	//1. Create Spring's IOC container
	ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	//2. Gain bean instance from IOC container
	ArithmeticCalulator arithmeticCalulator = (ArithmeticCalulator)ctx.getBean(ArithmeticCalulator.class);
	
	//3. Use bean
	int result = arithmeticCalulator.add(3, 6);
	System.out.println("result " + result);
	
	result = arithmeticCalulator.div(6, 2);
	System.out.println(result);
}
}
