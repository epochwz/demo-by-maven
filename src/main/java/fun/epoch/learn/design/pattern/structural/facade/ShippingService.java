package fun.epoch.learn.design.pattern.structural.facade;

public class ShippingService {
    public String shipGift(PointsGift pointsGift) {
        System.out.println("\t积分兑换物流系统：" + pointsGift.getName() + " 已成功进入物流系统");
        return System.currentTimeMillis() + ""; // 物流订单号
    }
}
