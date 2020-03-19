package fun.epoch.learn.design.pattern.structural.proxy;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Order {
    private Integer userId;
    private Object orderInfo;
}
