package com.zjc.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @Aspect 注解表示切面（类）
 */

public class LogUtils {
    /**
     * 切入点表达式复用
     * 1.先定义一个空方法
     * 2.在方法上使用注解@Pointcut来定义一个切入点表达式
     * 3.在需要使用切入点表达是的位置，使用方法调用代替即可
     */

    public static void pointcut1() {}
    /**
     * @Before注解表示前置通知<br/>
     * execution(public int com.zjc.pojo.Calculator.add(int , int)) 叫切入点表达式<br/>
     */
    public static void logBefore(JoinPoint joinPoint) {
        /**
         * JoinPoint joinPoint表示连接点
         * JoinPoint.getSignature().getName()获取方法名
         * JoinPoint.getArgs()获取方法参数
         */
        System.out.println("前置通知：" + joinPoint.getSignature().getName()
                + "，参数是：" + Arrays.asList(joinPoint.getArgs()));
    }

    /**
     * @After表示后置通知
     */
    public static void logAfter(JoinPoint joinPoint) {
        System.out.println("后置通知：" + joinPoint.getSignature().getName()
                + "，参数是：" + Arrays.asList(joinPoint.getArgs()));
    }

    /**
     * @AfterReturning注解表示返回通知
     * 1.在返回通知的方法中追加一个参数Object result，用来接受返回值
     * 2.在 @AfterReturning注解中，使用returning = "result"指定使用哪个参数来接收返回值
     */
    public static void logAfterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("返回通知：" + joinPoint.getSignature().getName() + ",返回值是:" + result);
    }

    /**
     * @AfterThrowing直接表示异常通知
     * 1.在异常通知的参数列表中追加一个参数Exception e用于接收抛出的的异常
     * 2.在异常通知注解中使用属性 throwing = "参数名"指明那个参数用来接收抛出的异常
     */
    public static void logAfterThrowing(JoinPoint joinPoint, Exception e) {
        System.out.println("异常通知：" + joinPoint.getSignature().getName() + ",抛出的异常是：" + Arrays.asList(e));
    }

    /**
     * @Around表示环绕通知
     * 1.环绕通知方法一定要把目标方法的返回值返回
     * 2.环绕通知会在普通通之前执行
     * 3.环绕通知收到异常一定要往外抛出异，否则普通异常通知就不会执行
     */
    public static Object around(ProceedingJoinPoint proceedingJoinPoint) {
        //一个环绕通知可以解决前面四个通知的问题，同时它还需要调用自己的目标方法
        Object result = null;
        try {
            try {
                System.out.println("环绕 前置");
                //执行目标方法
                result = proceedingJoinPoint.proceed();
            } finally {
                System.out.println("环绕 后置");
            }
            System.out.println("环绕 返回");
            return result;
            } catch (Throwable throwable) {
                throwable.printStackTrace();
                System.out.println("环绕 异常");
                throw new RuntimeException(throwable);
            }
    }
}
