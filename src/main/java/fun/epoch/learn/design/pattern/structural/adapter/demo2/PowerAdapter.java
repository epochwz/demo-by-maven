package fun.epoch.learn.design.pattern.structural.adapter.demo2;

public class PowerAdapter implements DC5V {
    private AC220V ac220V;

    public PowerAdapter(AC220V ac220V) {
        this.ac220V = ac220V;
    }

    @Override
    public int outputDC5V() {
        int input = ac220V.outputAC220V();
        int output = transformer(input);
        System.out.println("输出直流电 " + output + "V");
        return output;
    }

    /**
     * 适配方法：使用变压器将 交流电 适配成 直流电
     *
     * @param input 输入电压
     * @return 输出电压
     */
    private int transformer(int input) {
        int output = input / 44;
        System.out.println("\t--适配：使用变压器进行变压");
        System.out.println("\t--输入：AC" + input + "V");
        System.out.println("\t--输出：DC" + output + "V");
        return output;
    }
}
