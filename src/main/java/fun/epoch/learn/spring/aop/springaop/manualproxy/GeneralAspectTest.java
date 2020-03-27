package fun.epoch.learn.spring.aop.springaop.manualproxy;

import fun.epoch.learn.spring.aop.target.IUserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:fun/epoch/learn/spring/aop/springaop/manualproxy/generaladvisor/applicationContext.xml")
public class GeneralAspectTest {
    @Resource(name = "userDao")
    private IUserDao userDao;

    @Test
    public void test() {
        userDao.save();
        userDao.update();
        userDao.find();
        userDao.delete();
    }
}
