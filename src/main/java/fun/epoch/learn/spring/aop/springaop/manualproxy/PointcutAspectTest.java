package fun.epoch.learn.spring.aop.springaop.manualproxy;

import fun.epoch.learn.spring.aop.target.ProductDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:fun/epoch/learn/spring/aop/springaop/manualproxy/pointcutadvisor/applicationContext.xml")
public class PointcutAspectTest {
    @Resource(name = "productDao")
    private ProductDao productDao;

    @Test
    public void test() {
        productDao.save();
        productDao.update();
        productDao.find();
        productDao.delete();
    }
}
