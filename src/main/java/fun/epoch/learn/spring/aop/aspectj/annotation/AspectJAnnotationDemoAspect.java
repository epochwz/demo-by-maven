package fun.epoch.learn.spring.aop.aspectj.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
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
    public void beforeAdvice(JoinPoint joinPoint) { // 可以使用方法参数 JoinPoint 对象获取切点信息
        System.out.println("\n========== 前置通知 ========== " + joinPoint);
    }

    @AfterReturning(value = "execution(* fun.epoch.learn.spring.aop..*(..))", returning = "returnValue")
    public void afterReturningAdvice(Object returnValue) { // 可以通过 returning 属性定义方法参数的名称，而该方法参数就是切点方法的返回值
        System.out.println("========== 后置通知 ========== 返回值：" + returnValue);
        System.out.println();
    }
}
