package fun.epoch.learn.design.pattern.structural.proxy.dynamicproxy;

import fun.epoch.learn.design.pattern.structural.proxy.Order;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class OrderServiceDynamicProxy {
    // 需要代理的对象
    private Object target;

    public OrderServiceDynamicProxy(Object target) {
        this.target = target;
    }

    // 生成的代理对象
    private Object proxy;

    // 获取生成的代理对象
    public Object proxy() {
        if (proxy == null) {
            Class<?> clazz = target.getClass();
            proxy = Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), new ProxyHandler());
        }
        return proxy;
    }

    /**
     * 代理类的代理逻辑
     */
    private class ProxyHandler implements InvocationHandler {
        /**
         * 增强 proxy 的 method
         *
         * @param proxy  生成的代理对象
         * @param method 需要增强的方法
         * @param args   目标方法的参数
         * @return method 的返回值
         */
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Object arg = args[0];

            // 动态代理：预处理
            before(arg);

            // 原始处理
            Object result = method.invoke(target, arg);

            // 动态代理：后处理
            after();

            return result;
        }

        private void before(Object arg) {
            System.out.println("动态代理：预处理...");
            if (arg instanceof Order) {
                depot((Order) arg);
            }
        }

        private void after() {
            System.out.println("动态代理：后处理...");
        }

        // 分库
        private void depot(Order order) {
            int userId = order.getUserId();
            int dbRouter = userId % 2;
            System.out.println("动态代理：预处理... 分库 ---- 将订单分配到数据库【db" + dbRouter + "】进行数据处理...");
        }
    }
}
