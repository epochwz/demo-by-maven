package fun.epoch.learn.design.pattern.structural.facade;

public class PointsPaymentService {
    public boolean pay(PointsGift pointsGift) {
        System.out.println("\t积分兑换支付系统：" + pointsGift.getName() + " 已使用积分支付成功");
        return true;
    }
}
