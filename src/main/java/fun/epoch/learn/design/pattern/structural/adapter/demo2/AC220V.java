package fun.epoch.learn.design.pattern.structural.adapter.demo2;

public class AC220V {
    public int outputAC220V() {
        int output = 220;
        System.out.println("输出交流电 " + output + "V");
        return output;
    }
}
