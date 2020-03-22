package fun.epoch.learn.design.pattern.structural.facade;

public class Test {
    public static void main(String[] args) {
        PointsGift pointsGift = new PointsGift("《Java 从入门到放弃》");
        System.out.println("使用积分兑换礼物：" + pointsGift.getName());

        String shippingOrderNo = "";

        PointsPaymentService pointsPaymentService = new PointsPaymentService();
        QualifyService qualifyService = new QualifyService();
        ShippingService shippingService = new ShippingService();

        if (qualifyService.isAvailable(pointsGift)) {
            if (pointsPaymentService.pay(pointsGift)) {
                shippingOrderNo = shippingService.shipGift(pointsGift);
            }
        }

        System.out.println("礼物的物流订单号：" + shippingOrderNo);
    }
}
