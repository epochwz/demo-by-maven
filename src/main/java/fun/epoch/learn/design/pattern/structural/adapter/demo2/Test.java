package fun.epoch.learn.design.pattern.structural.adapter.demo2;

public class Test {
    public static void main(String[] args) {
        AC220V ac220V = new AC220V();
        DC5V dc5V = new PowerAdapter(ac220V);
        dc5V.outputDC5V();
    }
}
