package fun.epoch.framework.mini.spring.core.classscanner;

import fun.epoch.framework.mini.spring.core.FileUtils;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class FileSystemClassScanner {
    static List<String> collectClassNamesFromFile(URL url, boolean recursive) {
        return collectClassNamesFromFile(url.getPath(), recursive);
    }

    /**
     * 从文件系统中获取指定包下所有类的完整类名
     *
     * @param packageAbsolutePath 指定包的绝对路径 (eg. /path/fun/epoch/demo)
     * @param recursive           是否递归遍历子包
     * @return 类的完整类名
     */
    static List<String> collectClassNamesFromFile(String packageAbsolutePath, boolean recursive) {
        ExtractClassNameTask task = new ExtractClassNameTask();
        if (recursive) {
            FileUtils.executeFileRecursive(packageAbsolutePath, task);
        } else {
            FileUtils.executeChildFiles(packageAbsolutePath, task);
        }
        return task.extractClassNames();
    }

    /**
     * 任务：从类文件路径中提取出类的完整类名
     */
    private static class ExtractClassNameTask implements FileUtils.IFileTask {
        private List<String> classNames = new ArrayList<>();

        @Override
        public void execute(File target) {
            String classFilePath = target.getPath();
            if (classFilePath.endsWith(".class")) {
                classNames.add(classFilePath
                        .substring(classFilePath.indexOf("classes") + 8, classFilePath.lastIndexOf("."))
                        .replace("\\", ".") // Windows 路径
                        .replace("/", ".") // Linux 路径
                );
            }
        }

        List<String> extractClassNames() {
            return classNames;
        }
    }
}
