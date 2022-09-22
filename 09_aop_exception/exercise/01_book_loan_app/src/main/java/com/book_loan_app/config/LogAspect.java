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



    @Pointcut("execution(* com.book_loan_app.controller.BookManagerController.saveBorrowBook(..))")
    public void borrowBookPointCut() {
    }

    @AfterReturning("borrowBookPointCut()")
    public void borrowBookMethod(JoinPoint joinPoint) {
        System.out.println("mehtod name: "
                + joinPoint.getSignature().getName()
                + " time: " + LocalDateTime.now());
    }

    @Pointcut("execution(* com.book_loan_app.controller.BookManagerController.savePayBook(..))")
    public void payBookPointCut() {
    }

    @AfterReturning("payBookPointCut()")
    public void payBookMethod(JoinPoint joinPoint) {
        System.out.println("mehtod name: "
                + joinPoint.getSignature().getName()
                + " time: " + LocalDateTime.now());
    }
}
