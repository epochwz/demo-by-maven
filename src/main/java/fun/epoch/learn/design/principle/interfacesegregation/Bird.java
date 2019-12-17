package fun.epoch.learn.design.principle.interfacesegregation;

public class Bird implements IAnimalAction {
    @Override
    public void eat() {

    }

    @Override
    public void fly() {

    }

    @Override
    public void swim() {
        // 接口的职责过重，从而导致其实现类依赖一些不需要的接口方法，产生大量 “空实现”
    }
}
