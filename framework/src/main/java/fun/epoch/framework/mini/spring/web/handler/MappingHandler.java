package fun.epoch.framework.mini.spring.web.handler;

import fun.epoch.framework.mini.spring.beans.BeanFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class MappingHandler {
    private String uri;
    private Class<?> clazz;
    private Method method;
    private String[] args;

    public MappingHandler() {
    }

    public MappingHandler(String uri, Class<?> clazz, Method method, String[] args) {
        this.uri = uri;
        this.clazz = clazz;
        this.method = method;
        this.args = args;
    }

    public void handle(HttpServletRequest request, HttpServletResponse response) {
        if (uri.equals(request.getRequestURI())) {
            try {
                Object[] params = Arrays.stream(args).map(request::getParameter).toArray();
                Object object = BeanFactory.getBean(clazz);
                Object result = method.invoke(object, params);
                response.getWriter().write(result.toString());
            } catch (IllegalAccessException | InvocationTargetException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        return "MappingHandler{" +
                "uri='" + uri + '\'' +
                ", clazz=" + clazz +
                ", method=" + method +
                ", args=" + Arrays.toString(args) +
                '}';
    }
}
