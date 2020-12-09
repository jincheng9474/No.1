package com.zjc.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @Aspect 注解表示切面（类）
 * @Order 注解表示切面的执行顺序。数字越小，越优先执行
 */
@Order(2)
@Aspect
@Component
public class AV {

    /**
     * 切入点表达式复用<br/>
     * 1 先定义一个空方法<br/>
     * 2 在方法上使用注解@Pointcut来定义一个切入点表达式 <br/>
     * 3 在需要使用切入点表达式的位置，使用方法调用代替即可<br/>
     */
    @Pointcut(value = "execution(public int com.zjc.pojo.Calculator.add(int,int))")
    public static void pointcut1(){}


    /**
     * @Before注解表示前置通知<br/>
     * execution(public int com.zjc.pojo.Calculator.add(int , int)) 叫切入点表达式<br/>
     */
    @Before(value = "pointcut1()")
    public static void logBefore(JoinPoint joinPoint) {
        /**
         * JoinPoint joinPoint 表示连接点<br/>
         * joinPoint.getSignature().getName() 获取方法名<br/>
         * joinPoint.getArgs() 获取方法的参数<br/>
         */
        System.out.println("V  前置通知：" + joinPoint.getSignature().getName()
                + ", 参数是： " + Arrays.asList(joinPoint.getArgs()));
    }

    /**
     * @After 表示后置通知<br/>
     */
    @After(value = "pointcut1()")
    public static void logAfter(JoinPoint joinPoint) {
        System.out.println("V  后置通知：" + joinPoint.getSignature().getName()
                + " , 参数是： " + Arrays.asList(joinPoint.getArgs()));
    }

    /**
     * @AfterReturning 注解表示返回通知 <br/>
     *  1 在返回通知的方法中追加一个参数Object result，用来接收返回值<br/>
     *  2 在@AfterReturning注解中，使用属性returning = "result" 指定使用哪个参数来接收返回值
     */
    @AfterReturning(value = "pointcut1()",returning = "result")
    public static void logAfterReturning(JoinPoint joinPoint , Object result) {
        System.out.println("V  返回通知 ：" + joinPoint.getSignature().getName() + " , 返回值是：" + result );
    }

    /**
     * @AfterThrowing 注解表示异常通知<br/>
     * 1 在异常通知的参数列表中追加一个参数Exception ex用于接收抛出的异常<br/>
     * 2 在异常通知注解中使用属性 throwing = "参数名" 指明用哪个参数来接收抛出的异常<br/>
     */
    @AfterThrowing(value = "pointcut1()" , throwing = "ex")
    public static void logAfterThrowing(JoinPoint joinPoint, Exception ex) {
        System.out.println("V  异常通知：" + joinPoint.getSignature().getName() + " , 抛出的异常是：" + ex);
    }



}
