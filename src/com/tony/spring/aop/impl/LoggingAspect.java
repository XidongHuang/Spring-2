package com.tony.spring.aop.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//Announce this class to a "aspect": put this class into IOC container, then announce it as aspect
@Aspect
@Component
public class LoggingAspect {

	//Announce this method will be executed before the method
	@Before("execution(public int com.tony.spring.aop.impl.ArithmeticCalulatorImpl.*(int, int))")
	public void beforeMethod(JoinPoint joinPoint){

		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		
		System.out.println("The method begins " + methodName + " begins with " + args);
		
	}
	
	//After method: it runs after target method executed (No matter whether exception or not)
	//Cannot gain target method result in "aftermethod"
	@After("execution(public int com.tony.spring.aop.impl.ArithmeticCalulatorImpl.*(int, int))")
	public void afterMethod(JoinPoint joinPoint){
		
		String methodName = joinPoint.getSignature().getName();
		
		System.out.println("The method " + methodName + " ends");
		
		
	}
	
	
}
