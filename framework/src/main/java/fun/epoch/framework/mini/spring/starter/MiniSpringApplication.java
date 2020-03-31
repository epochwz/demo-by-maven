package fun.epoch.framework.mini.spring.starter;

import fun.epoch.framework.mini.spring.beans.BeanFactory;
import fun.epoch.framework.mini.spring.core.classscanner.ClassScanner;
import fun.epoch.framework.mini.spring.web.server.TomcatServer;
import fun.epoch.framework.mini.spring.web.servlet.DispatcherServlet;
import org.apache.catalina.LifecycleException;

import java.io.IOException;
import java.util.List;

public class MiniSpringApplication {
    private static final int DEFAULT_PORT = 8080;

    public static void run(Class<?> clazz, String[] args) {
        try {
            int port = args != null && args.length > 0 ? Integer.parseInt(args[0]) : DEFAULT_PORT;
            new TomcatServer(port).addServlet("/", "DispatcherServlet", new DispatcherServlet()).start();
            System.out.println("启动 Tomcat 成功：正在监听 [localhost:" + port + "]");
            List<Class<?>> classes = ClassScanner.scan(clazz.getPackage().getName());
            BeanFactory.initBeans(classes);
        } catch (LifecycleException e) {
            System.out.println("启动 Tomcat 失败：" + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
