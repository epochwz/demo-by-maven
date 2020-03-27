package fun.epoch.learn.spring.aop.proxy.dynamic.jdk;

import java.lang.reflect.Proxy;

public class JdkDynamicProxy<T> {
    private T target;

    public JdkDynamicProxy(T target) {
        this.target = target;
    }

    public T createProxy() {
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), (proxy, method, args) -> {
            // 增强目标对象的特定方法 (预处理)
            if ("save".equals(method.getName())) {
                System.out.println("JDK 动态代理：权限校验...");
            }
            // 执行目标对象的原始方法
            Object returnValue = method.invoke(target, args);
            // 增强目标对象的所有方法 (后处理)
            System.out.println();
            return returnValue;
        });
    }
}
