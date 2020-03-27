package fun.epoch.learn.spring.aop.proxy.dynamic.cglib;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CGLibDynamicProxy<T> implements MethodInterceptor {
    private T target;

    public CGLibDynamicProxy(T target) {
        this.target = target;
    }

    public T createProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return (T) enhancer.create();
    }

    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        // 增强目标对象的特定方法 (预处理)
        if ("save".equals(method.getName())) {
            System.out.println("CGLib 动态代理：权限校验...");
        }
        // 执行目标对象的原始方法
        Object returnValue = method.invoke(target, args); // 等价于 methodProxy.invokeSuper(proxy, args);
        // 增强目标对象的所有方法 (后处理)
        System.out.println();
        return returnValue;
    }
}
