package com.book_loan_app.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Aspect
public class LogAspect {
private int count=0;


    @Pointcut("execution(* com.book_loan_app.controller.BookManagerController*(..))")
    public void allControllerMethod() {
    }

    @AfterReturning("allControllerMethod()")
    public void afterReturningMethod(JoinPoint joinPoint) {
        count++;
        System.out.println("number of hits :"+count);
        System.out.println("mehtod name: "
                + joinPoint.getSignature().getName()
                + " time: " + LocalDateTime.now());
    }

    @Pointcut("execution(* com.book_loan_app.controller.BookManagerController.save*(..))")
    public void BorrowPayBookPointCut() {
    }

    @AfterReturning("BorrowPayBookPointCut()")
    public void payBookMethod(JoinPoint joinPoint) {
        System.out.println("mehtod name: "
                + joinPoint.getSignature().getName()
                + " time: " + LocalDateTime.now());
    }
}
