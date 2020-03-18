package fun.epoch.learn.design.pattern.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

public class EmployeeFactory {
    private static final Map<String, Employee> map = new HashMap<>();

    public static Employee getManager(String department) {
        if (!map.containsKey(department)) {
            map.put(department, new Manager(department));
        }
        return map.get(department);
    }
}
