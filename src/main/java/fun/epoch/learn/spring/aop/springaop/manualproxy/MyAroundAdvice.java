package fun.epoch.learn.spring.aop.springaop.manualproxy;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyAroundAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("========== 环绕前通知 ==========");
        Object returnValue = invocation.proceed();
        System.out.println("========== 环绕后通知 ==========");
        return returnValue;
    }
}
