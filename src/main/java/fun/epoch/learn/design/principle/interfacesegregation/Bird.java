package fun.epoch.learn.design.principle.interfacesegregation;

public class Bird implements IEatAnimalAction, IFlyAnimalAction {
    @Override
    public void eat() {

    }

    @Override
    public void fly() {

    }

    // @Override // 编译出错：接口职责隔离，无需实现不必要的接口方法
    // public void swim() {
    //     // 接口的职责过重，从而导致其实现类依赖一些不需要的接口方法，产生大量 “空实现”
    // }
}
