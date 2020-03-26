package fun.epoch.learn.spring.aop.aspectj.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
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

    @Around("execution(* fun.epoch.learn.spring.aop..delete(..))")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("========== 环绕前通知 ==========");
        Object returnValue = null; // 只要不调用 joinPoint.proceed(); 就可以阻止目标方法执行
        System.out.println("========== 环绕后通知 ==========");
        return returnValue;
    }

    @AfterThrowing(value = "execution(* fun.epoch.learn.spring.aop.target.ProductDao.findAll(..))", throwing = "e")
    public void afterThrowingAdvice(Throwable e) { // 可以通过 throwing 属性定义方法参数的名称，而该方法参数就是切点方法抛出的异常对象
        System.out.println("========== 异常抛出通知 ========== 异常信息：" + e.getMessage());
    }
}
