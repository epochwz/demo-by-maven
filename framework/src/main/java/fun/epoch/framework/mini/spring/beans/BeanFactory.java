package fun.epoch.framework.mini.spring.beans;

import fun.epoch.framework.mini.spring.web.mvc.Controller;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class BeanFactory {
    private static final Map<Class<?>, Object> beans = new ConcurrentHashMap<>();

    public static Object getBean(Class<?> clazz) {
        return beans.get(clazz);
    }

    public static void initBeans(List<Class<?>> classList) {
        List<Class<?>> beans = classList.stream().filter(BeanFactory::isBean).collect(Collectors.toList());

        while (beans.size() != 0) {
            int remainSize = beans.size();
            beans.removeIf(BeanFactory::createBeanSuccess);
            if (remainSize == beans.size()) {
                throw new RuntimeException("初始化 Bean 时发生循环依赖！！！");
            }
        }

        System.out.println("扫描到的 Bean: ");
        BeanFactory.beans.values().forEach(System.out::println);
    }

    private static boolean createBeanSuccess(Class<?> bean) {
        try {
            Object instance = bean.newInstance();
            for (Field field : bean.getDeclaredFields()) {
                if (field.getAnnotation(Autowired.class) != null) {
                    Object dependence = getBean(field.getType());
                    // 当前 Bean 的某个属性所依赖的 Bean 尚未初始化，因此先跳过当前 Bean 的初始化
                    if (dependence == null) return false;
                    field.setAccessible(true);
                    field.set(instance, dependence);
                }
            }
            beans.put(bean, instance);
            return true;
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return false;
    }

    private static boolean isBean(Class<?> clazz) {
        return clazz.getAnnotation(Controller.class) != null || clazz.getAnnotation(Component.class) != null;
    }
}
