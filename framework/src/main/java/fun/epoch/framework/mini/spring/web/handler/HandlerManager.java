package fun.epoch.framework.mini.spring.web.handler;

import fun.epoch.framework.mini.spring.web.mvc.Controller;
import fun.epoch.framework.mini.spring.web.mvc.RequestMapping;
import fun.epoch.framework.mini.spring.web.mvc.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class HandlerManager {
    private static final Map<String, MappingHandler> handlers = new ConcurrentHashMap<>();

    public static void initHandlers(List<Class<?>> beans) {
        List<Class<?>> controllers = beans.stream().filter(bean -> bean.getAnnotation(Controller.class) != null).collect(Collectors.toList());
        for (Class<?> controller : controllers) {
            String basePath = "";
            RequestMapping classRequestMapping = controller.getAnnotation(RequestMapping.class);
            if (classRequestMapping != null) {
                basePath = classRequestMapping.value();
            }
            for (Method method : controller.getDeclaredMethods()) {
                RequestMapping methodRequestMapping = method.getAnnotation(RequestMapping.class);
                if (methodRequestMapping != null) {
                    String uri = basePath + methodRequestMapping.value();
                    String[] args = Arrays.stream(method.getParameters()).map(parameter -> parameter.getAnnotation(RequestParam.class).value()).toArray(String[]::new);
                    handlers.put(uri, new MappingHandler(uri, controller, method, args));
                }
            }
        }
        System.out.println("扫描到的 Handle：");
        handlers.values().forEach(System.out::println);
    }

    public static void handle(HttpServletRequest request, HttpServletResponse response) {
        handlers.getOrDefault(request.getRequestURI(), DefaultMappingHandler).handle(request, response);
    }

    private static MappingHandler DefaultMappingHandler = new MappingHandler() {
        @Override
        public void handle(HttpServletRequest request, HttpServletResponse response) {
            try {
                response.getWriter().write("404 Not Found for request uri: " + request.getRequestURI());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    };
}
