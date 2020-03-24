package fun.epoch.learn.design.principle.compositionaggregation.v1;

public class PostgreSQLDBConnection extends DBConnection {
    @Override
    public String getConnection() {
        return "PostgreSQL 数据库连接";
    }
}
