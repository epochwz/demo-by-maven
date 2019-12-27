package fun.epoch.learn.design.pattern.structural.flyweight;

public class Manager implements Employee {
    // 内部状态：不同的 Manager 共享的状态
    private String title;
    // 外部状态：不同的 Manager 独有的状态
    private String department;


    public Manager(String department) {
        this.department = department;
        this.title = department + " 部门经理";
        System.out.print("创建 " + title + " --> ");
    }

    @Override
    public void report() {
        System.out.println(title + "开始汇报...");
    }
}
