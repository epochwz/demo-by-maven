package fun.epoch.learn.design.pattern.structural.facade;

public class Test {
    public static void main(String[] args) {
        PointsGift pointsGift = new PointsGift("《Java 从入门到放弃》");
        System.out.println("使用积分兑换礼物：" + pointsGift.getName());

        String shippingOrderNo = "";

        // 使用外观模式简化一系列子系统的调用 (外部程序无需深入了解各个子系统是如何协调工作的)
        GiftExchangeService giftExchangeService = new GiftExchangeService();
        shippingOrderNo = giftExchangeService.exchangeGift(pointsGift);

        System.out.println("礼物的物流订单号：" + shippingOrderNo);
    }
}
