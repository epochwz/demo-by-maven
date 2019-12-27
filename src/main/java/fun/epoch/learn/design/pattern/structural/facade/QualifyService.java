package fun.epoch.learn.design.pattern.structural.facade;

public class QualifyService {
    public boolean isAvailable(PointsGift pointsGift) {
        System.out.println("\t积分兑换校验系统：" + pointsGift.getName() + " 已通过积分数量校验");
        return true;
    }
}
