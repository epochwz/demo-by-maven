package fun.epoch.learn.spring.aop.proxy.dynamic.cglib;

import fun.epoch.learn.spring.aop.target.ProductDao;

public class Test {
    public static void main(String[] args) {
        ProductDao productDao = new ProductDao();
        productDao = new CGLibDynamicProxy<>(productDao).createProxy();
        productDao.save();
        productDao.update();
        productDao.find();
        productDao.delete();
    }
}
