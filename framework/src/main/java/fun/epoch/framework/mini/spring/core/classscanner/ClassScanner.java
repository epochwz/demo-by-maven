package fun.epoch.framework.mini.spring.core.classscanner;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 类扫描器
 */
public class ClassScanner {
    public static List<Class<?>> scan(String packageName) throws IOException {
        return scan(packageName, true)
                .stream()
                .map(ClassScanner::classForName)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    /**
     * 获取指定包下所有类的完整类名
     *
     * @param packageName 指定的包名 (eg. fun.epoch.demo)
     * @param recursive   是否递归遍历子包
     * @return 指定包下所有类的完整类名
     */
    public static List<String> scan(String packageName, boolean recursive) throws IOException {
        String packagePath = packageName.replace(".", "/");
        URL url = Thread.currentThread().getContextClassLoader().getResource(packagePath);

        if (url != null) {
            switch (url.getProtocol()) {
                case "file":
                    return FileSystemClassScanner.collectClassNamesFromFile(url, recursive);
                case "jar":
                    return JarFileClassScanner.collectClassNamesFromJar(url, packagePath, recursive);
                default:
                    break;
            }
        }

        return new ArrayList<>();
    }

    private static Class<?> classForName(String className) {
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
