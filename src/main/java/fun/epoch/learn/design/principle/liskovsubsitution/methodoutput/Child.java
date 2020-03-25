package fun.epoch.learn.design.principle.liskovsubsitution.methodoutput;

import java.util.HashMap;

public class Child extends Parent {
    @Override
    public HashMap<String, String> method() {
        return new HashMap<>();
    }
}
