package fun.epoch.learn.spring.aop.target;

import org.springframework.stereotype.Component;

@Component
public class ProductDao {
    public void save() {
        System.out.println("保存商品...");
    }

    public String update() {
        System.out.println("更新商品...");
        return "Hello World!";
    }

    public void delete() {
        System.out.println("删除商品...");
    }

    public void find() {
        System.out.println("查找商品...");
    }

    public void findOne() {
        System.out.println("查找单个商品...");
    }

    public void findAll() {
        System.out.println("查找所有商品...");
        throw new RuntimeException("查找商品时抛出异常啦！！！");
    }
}
