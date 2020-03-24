package fun.epoch.learn.design.principle.openclose.v1;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PythonCourse implements Course {
    private Integer id;
    private String name;
    private Double price;

    @Override
    public Double getDiscountPrice(double discount) {
        this.price *= discount; // 模拟修改现有实现类时，容易引发风险：获取折扣价格时可能不小心修改了课程原价
        return getPrice();
    }
}
