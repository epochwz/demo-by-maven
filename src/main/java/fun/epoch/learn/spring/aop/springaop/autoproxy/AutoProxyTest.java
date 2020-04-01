package fun.epoch.learn.spring.aop.springaop.autoproxy;

import fun.epoch.learn.spring.aop.target.IUserDao;
import fun.epoch.learn.spring.aop.target.ProductDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:fun/epoch/learn/spring/aop/springaop/autoproxy/AutoProxyByAdvisor.xml")
public class AutoProxyTest {
    @Autowired
    private IUserDao userDao;

    @Autowired
    private ProductDao productDao;

    @Test
    public void test() {
        userDao.save();
        userDao.update();
        userDao.find();
        userDao.delete();

        System.out.println("\n============================================================\n");

        productDao.save();
        productDao.update();
        productDao.find();
        productDao.delete();
    }
}
