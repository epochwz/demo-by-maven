package fun.epoch.framework.mini.spring.core.classscanner;

import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class JarFileClassScanner {
    public static List<String> collectClassNamesFromJar(URL url, String packagePath, boolean recursive) throws IOException {
        JarFile jarFile = ((JarURLConnection) url.openConnection()).getJarFile();
        return JarFileClassScanner.collectClassNamesFromJar(jarFile, packagePath, recursive);
    }

    /**
     * 从 Jar 文件中获取指定包路径下所有类的完整类名
     *
     * @param jarPath     Jar 文件路径 (eg. /path/xxx.jar)
     * @param packagePath 指定包路径 (eg. fun/epoch/demo)
     * @param recursive   是否递归遍历子包
     * @return 类的完整类名
     */
    public static List<String> collectClassNamesFromJar(String jarPath, String packagePath, boolean recursive) throws IOException {
        return collectClassNamesFromJar(new JarFile(jarPath), packagePath, recursive);
    }

    /**
     * 从 Jar 文件中获取指定包路径下所有类的完整类名
     *
     * @param jarFile     Jar 文件
     * @param packagePath 指定包路径 (eg. fun/epoch/demo)
     * @param recursive   是否递归遍历子包
     * @return 类的完整类名
     */
    public static List<String> collectClassNamesFromJar(JarFile jarFile, String packagePath, boolean recursive) {
        List<String> classNames = new ArrayList<>();

        boolean isPackageTraversed = false;

        Enumeration<JarEntry> entries = jarFile.entries();
        while (entries.hasMoreElements()) {
            String fileName = entries.nextElement().getName();

            // 如果当前文件不在目标包路径中，且程序曾经遍历过目标包路径，则表示目标包中的文件已经遍历完毕了，程序可以提前退出
            if (!fileName.startsWith(packagePath) && isPackageTraversed) break;

            // 如果当前文件不在目标包路径中，可以直接跳过
            if (!fileName.startsWith(packagePath)) continue;

            isPackageTraversed = true;

            // 如果当前文件不是类文件，可以直接跳过
            if (!fileName.endsWith(".class")) continue;

            // 如果不要求递归扫描的话，则可以直接跳过子包中的文件
            if (!recursive && !packagePath.equals(currentPackage(fileName))) continue;

            // 提取类文件的完整类名并添加集合中
            classNames.add(fileName.replace("/", ".").substring(0, fileName.lastIndexOf(".")));
        }

        return classNames;
    }

    // 获取类文件 fileName 的包路径
    private static String currentPackage(String fileName) {
        String currentPackagePath = "";
        int index = fileName.lastIndexOf("/");
        if (index != -1) {
            currentPackagePath = fileName.substring(0, index);
        }
        return currentPackagePath;
    }
}
