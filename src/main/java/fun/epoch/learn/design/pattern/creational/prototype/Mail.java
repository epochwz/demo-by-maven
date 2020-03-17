package fun.epoch.learn.design.pattern.creational.prototype;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class Mail implements Cloneable {
    private String name;
    private String address;
    private String content;

    private Map<String, Object> configurations;

    public Mail() {
        this.configurations = heavyInitialization();
    }

    public Mail(String content) {
        this();
        this.content = content;
    }

    // 模拟创建 Mail 对象时，初始化 configurations 十分消耗资源，但后续获取所有 Mail 对象时却没必要再次初始化该属性
    private Map<String, Object> heavyInitialization() {
        System.out.println("\ncreate mail start...");
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(1000);
                System.out.println("create mail spent " + (i + 1) + "s");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("create mail over.");
        return new HashMap<>();
    }

    @Override
    protected Mail clone() throws CloneNotSupportedException {
        return (Mail) super.clone();
    }
}
