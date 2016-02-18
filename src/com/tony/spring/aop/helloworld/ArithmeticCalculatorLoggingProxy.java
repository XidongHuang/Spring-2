package com.tony.spring.aop.helloworld;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ArithmeticCalculatorLoggingProxy {

	
	//The object needs to be proxy
	private ArithmeticCalulator target;
	
	public ArithmeticCalculatorLoggingProxy(ArithmeticCalulator target) {
		this.target = target;
	}
	
	public ArithmeticCalulator getLoggingProxy(){
		
		ArithmeticCalulator proxy = null;
		
		//Which class loader for loading the "Agent object"
		ClassLoader loader = target.getClass().getClassLoader();
		//Agent object's type, what kinds of method in it
		Class[] interfaces = new Class[]{ArithmeticCalulator.class};
		//The code should be launched When invoking the methods of agent object 
		InvocationHandler h = new InvocationHandler() {
			
			/**
			 * 
			 * proxy: The agent object that is returning. In default, it does not use this object in invoke method
			 * method: THe method is invoked
			 * args: The parameters that are passed when invoking method
			 * 
			 */
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				
				String methodName = method.getName();
				//log
				System.out.println("The method" + method + "begins with " + Arrays.asList(args));
				//Invoke method
				Object result = method.invoke(target, args);
				//log
				System.out.println("the method " + methodName + " ends with " + result);
				return result;
			}
		};
		proxy = (ArithmeticCalulator)Proxy.newProxyInstance(loader, interfaces, h);
		
		return proxy;
	}
	
	
}
