package fun.epoch.learn.spring.aop.aspectj.xml;

import fun.epoch.learn.spring.aop.target.ProductDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:fun/epoch/learn/spring/aop/aspectj/xml/applicationContext.xml")
public class AspectJXmlTest {
    @Autowired
    ProductDao productDao;

    @Test(expected = RuntimeException.class)
    public void test() {
        productDao.save();
        productDao.update();
        productDao.delete();
        productDao.find();
        productDao.findOne();
        productDao.findAll();
    }
}
