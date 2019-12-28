package fun.epoch.learn.design.pattern.structural.proxy.dynamicproxy;

import fun.epoch.learn.design.pattern.structural.proxy.IOrderService;
import fun.epoch.learn.design.pattern.structural.proxy.Order;
import fun.epoch.learn.design.pattern.structural.proxy.OrderServiceImpl;

public class Test {
    public static void main(String[] args) {
        // 目标对象
        IOrderService targetObject = new OrderServiceImpl();
        // 代理对象
        IOrderService proxyObject = (IOrderService) new OrderServiceDynamicProxy(targetObject).proxy();
        // 使用代理
        proxyObject.saveOrder(new Order((int) (Math.random() * 10), new Object()));
    }
}
