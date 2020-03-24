package fun.epoch.learn.design.principle.demeter;

public class Boss {
    // 符合迪米特法则：TeamLeader 是 Course 的 “朋友”，可以进行交流
    public void commandCheckNumber(TeamLeader teamLeader) {
        teamLeader.checkNumberOfCourse();
    }
}
