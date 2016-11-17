package com.phantom.springbean.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class WriteSomething {
	@Pointcut("execution(* com.phantom.springbean.aop.*.*(..))")
	private void writePoint() {}
	
	@Before("writePoint()")
	public void writeBefore() {
		System.out.println("Write someting by writeBefore");
	}
	
	@After("writePoint()")
	public void writeAfter() {
		System.out.println("Write someting by writeAter");
	}
	
	@AfterReturning(pointcut="writePoint()", returning="returnVal")
	public void writeAfterReturning(Object returnVal) {
		System.out.println("Write return: " + returnVal.toString() + " by writeAfterReturning");
	}
	
	@AfterThrowing(pointcut="writePoint()", throwing="e")
	public void writeAfterThrowing(IllegalArgumentException e) {
		System.out.println("Throwing exception " + e.toString() + "by writeAfterThrowing");
	}
}
