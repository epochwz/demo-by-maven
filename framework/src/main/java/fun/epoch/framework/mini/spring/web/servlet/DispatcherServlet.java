package fun.epoch.framework.mini.spring.web.servlet;

import fun.epoch.framework.mini.spring.web.handler.HandlerManager;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) {
        HandlerManager.handle(req, resp);
    }
}
