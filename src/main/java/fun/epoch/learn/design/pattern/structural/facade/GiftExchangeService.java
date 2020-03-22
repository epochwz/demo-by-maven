package fun.epoch.learn.design.pattern.structural.facade;

// 外观模式：屏蔽一系列子系统的低层接口，并对外提供统一的高层接口，从而简化外部程序的调用
public class GiftExchangeService {
    PointsPaymentService pointsPaymentService = new PointsPaymentService();
    QualifyService qualifyService = new QualifyService();
    ShippingService shippingService = new ShippingService();

    public String exchangeGift(PointsGift pointsGift) {
        if (qualifyService.isAvailable(pointsGift)) {
            if (pointsPaymentService.pay(pointsGift)) {
                return shippingService.shipGift(pointsGift);
            }
        }
        return "";
    }
}
