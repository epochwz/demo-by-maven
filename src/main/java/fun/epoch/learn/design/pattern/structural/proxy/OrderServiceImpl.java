package fun.epoch.learn.design.pattern.structural.proxy;

public class OrderServiceImpl implements IOrderService {
    private IOrderDao iOrderDao = new OrderDaoImpl(); // Spring 可以自动注入，此处直接手动创建

    @Override
    public int saveOrder(Order order) {
        System.out.println("Service 层调用 Dao 层保存订单...");
        return iOrderDao.insert(order);
    }
}
