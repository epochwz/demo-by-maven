package fun.epoch.learn.design.pattern.structural.proxy;

public class OrderDaoImpl implements IOrderDao {
    @Override
    public int insert(Order order) {
        System.out.println("Dao 层成功保存订单...");
        return 1;
    }
}
