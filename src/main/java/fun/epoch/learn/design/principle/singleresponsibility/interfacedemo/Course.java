package fun.epoch.learn.design.principle.singleresponsibility.interfacedemo;

public interface Course {
    // 职责一：课程信息
    void getName();

    void getVideo();

    // 职责二：课程管理
    void buy();

    void refund();

    // 两个职责之间存在关联关系 (相互影响)：比如退款后就无法获取课程信息了
}
