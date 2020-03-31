package fun.epoch.framework.mini.spring.web.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class HandlerManager {
    private static final Map<String, MappingHandler> handlers = new ConcurrentHashMap<>();

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
