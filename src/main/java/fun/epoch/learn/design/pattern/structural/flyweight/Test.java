package fun.epoch.learn.design.pattern.structural.flyweight;

public class Test {
    public static final String[] departments = new String[]{"RD", "QA", "PM", "BD"};

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            String department = departments[(int) (Math.random() * departments.length)];
            Employee manager = EmployeeFactory.getManager(department);
            manager.report();
        }
    }
}
