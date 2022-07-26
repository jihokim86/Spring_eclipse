package com.spring.ex01;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LoggingAdvice implements MethodInterceptor {

	public Object invoke(MethodInvocation invocation) throws Throwable{
			System.out.println("[메소드 호출 전 : LoggnAdvice");
			System.out.println(invocation.getMethod()+"메소드 호출 전");
			
			Object object = invocation.proceed();
			
			System.out.println("[메소드 호출 후 : loggingAdive");
			System.out.println(invocation.getMethod()+"메소드 호출 후");
		return object;
	}
	
}
