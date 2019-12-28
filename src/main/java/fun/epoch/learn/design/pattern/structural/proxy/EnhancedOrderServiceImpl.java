package fun.epoch.learn.design.pattern.structural.proxy;

public class EnhancedOrderServiceImpl implements IOrderService {
    private IOrderDao iOrderDao = new OrderDaoImpl(); // Spring 可以自动注入，此处直接手动创建

    @Override
    public int saveOrder(Order order) {
        System.out.println("Service 层处理订单...");
        System.out.println("Service 层调用 Dao 层保存订单...");
        System.out.println("Service 层保存订单前进行核验...");
        int row = iOrderDao.insert(order);
        System.out.println("Service 层确认订单已保存...");
        return row;
    }
}
