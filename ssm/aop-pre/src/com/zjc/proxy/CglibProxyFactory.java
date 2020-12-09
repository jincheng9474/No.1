package com.zjc.proxy;

public class CglibProxyFactory {

//    public static void main(String[] args) {
//        // 目标对象
//        Calculator calculator = new Calculator();
//        // Cglib代理对象
//        Calculator cglibProxy = (Calculator) createCglibProxy(calculator,new LogMethodInterceptor(calculator));
//
//        cglibProxy.add(100, 100);
//        System.out.println("===================");
//        cglibProxy.div(100, 0);
//    }
//
//    /**
//     * Cglib代理，的日志业务操作
//     */
//    static class LogMethodInterceptor implements MethodInterceptor{
//
//        Object target;
//
//        public LogMethodInterceptor(Object target) {
//            this.target = target;
//        }
//
//        /**
//         * @param proxy     代理对象实例
//         * @param method    调用方法的反射对象
//         * @param args      调用方法时的参数
//         * @param methodProxy   调用方法反射对象的代理对象
//         * @return 代理方法的返回值
//         * @throws Throwable
//         */
//        @Override
//        public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
//
//            try {
//                // 前置增强 || 前置通知
//                // 记录运算操作，以及参数
//                LogUtils.logBefore(method.getName(), args);
//                // 调用 目标 方法
//                Object result = method.invoke(target, args);
//                // 记录返回值
//                // 返回增强 || 返回通知
//                LogUtils.logAfterReturning(method.getName(), result);
//                return result;
//            } catch (Exception e) {
//                // 记录异常信息
//                // 异常增强 || 异常通知
//                LogUtils.logAfterThrowing(method.getName(), e);
//                throw new RuntimeException(e);
//            }
//
//        }
//    }
//
//
//    public static Object createCglibProxy(Object target,MethodInterceptor methodInterceptor) {
//        // 创建一个用于增强的工具类
//        Enhancer enhancer = new Enhancer();
//
//        // 在给定的class字节码的基础之上。生成一个代理
//        enhancer.setSuperclass(target.getClass());
//        /**
//         * MethodInterceptor 接口，也是用于做增强的接口 <br/>
//         * 每次调用cglib代理对象方法时，都会执行，MethodInterceptor#intercept();<br/>
//         * 也就是，我们需要在MethodInterceptor#intercept()方法中做两件事情：<br/>
//         *      1 调用目标对象的方法 <br/>
//         *      2 执行增强的操作 <br/>
//         */
//        enhancer.setCallback(methodInterceptor);
//
//        // 创建代理对象
//        return enhancer.create();
//    }

}
