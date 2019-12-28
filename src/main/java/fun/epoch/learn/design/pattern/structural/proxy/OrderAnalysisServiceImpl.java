package fun.epoch.learn.design.pattern.structural.proxy;

public class OrderAnalysisServiceImpl implements IOrderAnalysisService {
    @Override
    public void analyzeOrder(Order order) {
        System.out.println("分析订单：" + order);
    }
}
