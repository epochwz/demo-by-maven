package fun.epoch.learn.design.principle.compositionaggregation.v2;

public class MySQLDBConnection extends DBConnection {
    @Override
    public String getConnection() {
        return "MySQL 数据库连接";
    }
}
