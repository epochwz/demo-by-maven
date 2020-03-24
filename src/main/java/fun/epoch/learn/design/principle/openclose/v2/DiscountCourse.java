package fun.epoch.learn.design.principle.openclose.v2;

import lombok.AllArgsConstructor;

/**
 * 适配器模式：在不改变现有类 (Course) 的前提下扩展其功能 (获取折扣价格), 符合开闭原则
 */
@AllArgsConstructor
public class DiscountCourse implements Course {
    private Course course;

    public Double getDiscountPrice(double discount) {
        return course.getPrice() * discount;
    }

    @Override
    public Integer getId() {
        return course.getId();
    }

    @Override
    public String getName() {
        return course.getName();
    }

    @Override
    public Double getPrice() {
        return course.getPrice();
    }
}
