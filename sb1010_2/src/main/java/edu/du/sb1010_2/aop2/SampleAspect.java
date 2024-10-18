package edu.du.sb1010_2.aop2;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Aspect
@Component
public class SampleAspect {

    @Around("execution(* *..aop2.*Greet.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("===== Around Advice =====");
        System.out.println("▼ ▼ ▼ ▼ ▼ ▼");
        Object result = joinPoint.proceed();
        System.out.println("▲ ▲ ▲ ▲ ▲ ▲");
        return result;
    }

    @Before("execution(* *..aop2.*Greet.*(..))")
    public void beforeAdvice(JoinPoint joinPoint) {
        System.out.println("===== Before Advice =====");
        System.out.println(new SimpleDateFormat("yyyy/MM/dd").format(new java.util.Date()));
        System.out.println(String.format("method: %s", joinPoint.getSignature().getName()));
    }

    @After("execution(* *..aop2.*Greet.*(..))")
    public void afterAdvice(JoinPoint joinPoint) {
        System.out.println("===== After Advice =====");
        System.out.println(new SimpleDateFormat("yyyy/MM/dd").format(new java.util.Date()));
        System.out.println(String.format("method: %s", joinPoint.getSignature().getName()));
    }
}
