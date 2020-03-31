package fun.epoch.framework.mini.spring.starter;

import fun.epoch.framework.mini.spring.web.server.TomcatServer;
import org.apache.catalina.LifecycleException;

public class MiniSpringApplication {
    private static final int DEFAULT_PORT = 8080;

    public static void run(Class<?> clazz, String[] args) {
        try {
            int port = args != null && args.length > 0 ? Integer.parseInt(args[0]) : DEFAULT_PORT;
            new TomcatServer(port).start();
            System.out.println("启动 Tomcat 成功：正在监听 [localhost:" + port + "]");
        } catch (LifecycleException e) {
            System.out.println("启动 Tomcat 失败：" + e.getMessage());
            e.printStackTrace();
        }
    }
}
