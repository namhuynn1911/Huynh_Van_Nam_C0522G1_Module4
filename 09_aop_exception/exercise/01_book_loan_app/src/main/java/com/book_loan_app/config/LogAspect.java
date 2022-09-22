package com.book_loan_app.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
@Aspect
public class LogAspect {

    @Pointcut("execution(* com.book_loan_app.controller.BookManagerController.show*(..))")
    public void allMethodPointCut() {
    }

    @Before("allMethodPointCut()")
    public void beforeCallMethod(JoinPoint joinPoint) {
        System.out.println("Start method name book: "
                + joinPoint.getSignature().getName()
                + "time: " + LocalDateTime.now());
    }

    @AfterReturning("allMethodPointCut()")
    public void afterThrowingCallMethod(JoinPoint joinPoint) {
        System.out.println("End mehtod name: "
                + joinPoint.getSignature().getName()
                + " time: " + LocalDateTime.now());
    }
}
