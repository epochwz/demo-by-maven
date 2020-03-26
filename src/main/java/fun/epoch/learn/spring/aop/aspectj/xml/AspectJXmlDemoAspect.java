package fun.epoch.learn.spring.aop.aspectj.xml;

import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;

/**
 * AOP 的切面类
 */
@Component
public class AspectJXmlDemoAspect {
    public void beforeAdvice(JoinPoint joinPoint) { // 可以使用方法参数 JoinPoint 对象获取切点信息
        System.out.println("\n========== 前置通知 ========== " + joinPoint);
    }
}
