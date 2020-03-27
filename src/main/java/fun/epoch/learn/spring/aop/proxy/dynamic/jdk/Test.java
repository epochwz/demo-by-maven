package fun.epoch.learn.spring.aop.proxy.dynamic.jdk;

import fun.epoch.learn.spring.aop.target.IUserDao;
import fun.epoch.learn.spring.aop.target.UserDao;

public class Test {
    public static void main(String[] args) {
        IUserDao userDao = new UserDao();
        userDao.save();
        userDao.update();
        userDao.find();
        userDao.delete();
    }
}
