package fun.epoch.learn.design.pattern.structural.proxy.staticproxy;

import fun.epoch.learn.design.pattern.structural.proxy.IOrderService;
import fun.epoch.learn.design.pattern.structural.proxy.Order;

public class OrderServiceStaticProxy implements IOrderService {
    private IOrderService iOrderService;

    public OrderServiceStaticProxy(IOrderService iOrderService) {
        this.iOrderService = iOrderService;
    }

    @Override
    public int saveOrder(Order order) {
        // 静态代理：预处理
        before(order);

        // 原始处理
        int result = iOrderService.saveOrder(order);

        // 静态代理：后处理
        after();

        return result;
    }

    private void before(Order order) {
        System.out.println("静态代理：预处理...");
        if (order != null) {
            depot(order);
        }
    }

    // 分库
    private void depot(Order order) {
        int userId = order.getUserId();
        int dbRouter = userId % 2;
        System.out.println("静态代理：预处理... 分库 ---- 将订单分配到数据库【db" + dbRouter + "】进行数据处理...");
    }

    private void after() {
        System.out.println("静态代理：后处理...");
    }
}
