package fun.epoch.learn.spring.aop.aspectj.annotation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * AOP 的切面类
 */
@Component
@Aspect
public class AspectJAnnotationDemoAspect {
    @Before("execution(* *(..))")
    public void beforeAdvice() {
        System.out.println("\n========== 前置通知 ==========");
    }
}
