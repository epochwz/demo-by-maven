package fun.epoch.framework.mini.spring.web.server;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class TomcatServer {
    private Tomcat tomcat;

    public TomcatServer(int port) {
        tomcat = new Tomcat();
        tomcat.setPort(port);
    }

    public void start() throws LifecycleException {
        tomcat.start();

        // Tomcat 常驻线程
        new Thread(() -> tomcat.getServer().await(), "TOMCAT_AWAIT_THREAD").start();
    }
}
