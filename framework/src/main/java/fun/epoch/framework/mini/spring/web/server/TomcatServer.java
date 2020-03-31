package fun.epoch.framework.mini.spring.web.server;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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

    private StandardContext context;

    public TomcatServer addServlet(String pattern, String servletName, Servlet servlet) {
        if (context == null) {
            context = new StandardContext();
            context.setPath("");
            context.addLifecycleListener(new Tomcat.FixContextListener());
            tomcat.getHost().addChild(context);
        }

        Tomcat.addServlet(context, servletName, servlet);
        context.addServletMappingDecoded(pattern, servletName);
        System.out.println(String.format("注册 Servlet[%s:%s]", servletName, pattern));

        return this;
    }

    public static void main(String[] args) throws LifecycleException {
        new TomcatServer(9999)
                .addServlet("/hello", "hello", new HttpServlet() {
                    @Override
                    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
                        resp.getWriter().write("response hello to " + req.getRequestURI());
                    }
                })
                .addServlet("/hi", "hi", new HttpServlet() {
                    @Override
                    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
                        resp.getWriter().write("response hi to " + req.getRequestURI());
                    }
                })
                .start();
    }
}
