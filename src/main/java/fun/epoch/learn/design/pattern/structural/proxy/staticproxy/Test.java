package fun.epoch.learn.design.pattern.structural.proxy.staticproxy;

import fun.epoch.learn.design.pattern.structural.proxy.EnhancedOrderServiceImpl;
import fun.epoch.learn.design.pattern.structural.proxy.IOrderService;
import fun.epoch.learn.design.pattern.structural.proxy.Order;
import fun.epoch.learn.design.pattern.structural.proxy.OrderServiceImpl;

public class Test {
    public static void main(String[] args) {
        // 目标对象
        IOrderService targetObject = new OrderServiceImpl();
        // 代理对象
        IOrderService proxyObject = new OrderServiceStaticProxy(targetObject);
        // 使用代理
        proxyObject.saveOrder(new Order((int) (Math.random() * 10), new Object()));

        for (int i = 0; i < 3; i++) {
            System.out.println((i + 1) + "s");
        }

        // ！！注意：同一个静态代理类可以代理同一个接口的不同实现类

        // 目标对象
        targetObject = new EnhancedOrderServiceImpl();
        // 代理对象
        proxyObject = new OrderServiceStaticProxy(targetObject);
        // 使用代理
        proxyObject.saveOrder(new Order((int) (Math.random() * 10), new Object()));
    }
}
