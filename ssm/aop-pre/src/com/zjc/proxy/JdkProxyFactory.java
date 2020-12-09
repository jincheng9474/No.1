package com.zjc.proxy;

public class JdkProxyFactory {

//    public static void main(String[] args) {
//        /**
//         * 新需求1，给计算器的每一个方法都添加上日志操作。记录下运算名，和运算参数 <br/>
//         * 新需求2，需要记录每个运算之后的结果。<br/>
//         * 新需求3，记录如果运算出现异常。记录异常信息 <br/>
//         */
//        Calculator calculate = new Calculator();
//
//        Calculate proxy = (Calculate) createJdkProxy(calculate,new LogInvocationHandler(calculate));
//
//        System.out.println(proxy.add(100, 100));
//        System.out.println("============================");
//        System.out.println(proxy.div(100, 0));
//
//    }
//
//
//    /**
//     * 给目标对象添加日志操作
//     */
//    static class LogInvocationHandler implements InvocationHandler{
//
//        // 目标对象
//        Object target;
//
//        public LogInvocationHandler(Object target) {
//            this.target = target;
//        }
//
//        /**
//         * @param proxy     代理对象实例<br/>
//         * @param method    调用方法的反射对象<br/>
//         * @param args      调用方法时传递的参数<br/>
//         * @return      invoke()方法的返回值，就是代理对象方法的返回值<br/>
//         * @throws Throwable
//         */
//        @Override
//        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//
//            try {
//                LogUtils.logBefore(method.getName(),args);
//                //            调用目标对象的方法
//                Object result = method.invoke(target,args );
//
//                LogUtils.logAfterReturning(method.getName(), result);
//                return result;
//            } catch (Exception e) {
//                LogUtils.logAfterThrowing(method.getName(),e);
//                throw new RuntimeException(e);
//            }
//
//        }
//    }
//
//    public static Object createJdkProxy(Object target, InvocationHandler invocationHandler){
//        /**
//         * Proxy是jdk中反射包下提供的一个工具类，专门用来创建代理对象<br/>
//         * newProxyInstance()是创建一个代理对象实例<br/>
//         *  第一个参数是，类加载器<br/>
//         *  第二个参数是，目标对象和代理对象都需要统一实现的接口 <br/>
//         *  第三个参数是：InvocationHandler 接口实现类。它有一个方法invoke() 这个方法在每次调用代理对象方法的时候就会自动调用<br/>
//         *  InvocationHandler#invoke()方法里需要干两件事情：  <br/>
//         *      1 调用目标对象的方法 <br/>
//         *      2 执行增强的操作 <br/>
//         */
//        return Proxy.newProxyInstance(
//                target.getClass().getClassLoader(),
//                target.getClass().getInterfaces(),
//                invocationHandler);
//    }

}
