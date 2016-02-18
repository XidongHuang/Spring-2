package com.tony.spring.aop.helloworld;

public class Main {
public static void main(String[] args) {
//	ArithmeticCalulator arithmeticCalulator = null;
//	arithmeticCalulator = new ArithmeticCalulatorLoggingImpl();
	
	ArithmeticCalulator target = new ArithmeticCalulatorImpl();
	ArithmeticCalulator proxy = new ArithmeticCalculatorLoggingProxy(target).getLoggingProxy();
	
	System.out.println(proxy.getClass().getName());
	
	int result = proxy.add(1, 2);
	System.out.println("-->"+ result);
	
	result = proxy.sub(4, 2);
	
	System.out.println("-->"+ result);
}
}
