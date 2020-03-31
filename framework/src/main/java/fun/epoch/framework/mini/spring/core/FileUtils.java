package fun.epoch.framework.mini.spring.core;

import java.io.*;
import java.util.Properties;

/**
 * 文件工具
 */
public class FileUtils {
    // private static final Logger logger = LoggerFactory.getLogger(FileUtils.class);

    public static boolean save(String filePath, Properties properties) {
        try {
            boolean isFileExist = createFile(filePath, "");
            if (isFileExist) {
                properties.store(new FileWriter(filePath), "");
                return true;
            }
        } catch (IOException e) {
            // logger.error("FileUtils: save properties to {} error \n", e);
        }
        return false;
    }

    /**
     * 复制文件：二进制文件
     *
     * @param srcPath 源文件
     * @param desPath 目标文件
     * @return 文件是否复制成功
     */
    public static boolean copy(String srcPath, String desPath) {
        try {
            FileInputStream in = new FileInputStream(srcPath);
            byte[] bytes = new byte[in.available()];
            while (in.available() > 0) {
                in.read(bytes);
            }
            return createFile(desPath, bytes);
        } catch (IOException e) {
            // logger.error("FileUtils: copy binary file error \n", e);
        }
        return false;
    }

    /**
     * 复制文件
     *
     * @param srcPath 源文件
     * @param desPath 目标文件
     * @return 文件是否复制成功
     */
    public static boolean copyFile(String srcPath, String desPath) {
        return createFile(desPath, readFile(srcPath).getBytes());
    }

    /**
     * 更新文件
     *
     * @param filePath 目标文件
     * @param oldStr   旧字符串
     * @param newStr   新字符串
     * @return 文件是否更新成功
     */
    public static boolean updateFile(String filePath, String oldStr, Object newStr) {
        return updateFile(filePath, oldStr, newStr, 0);
    }

    /**
     * 更新文件
     *
     * @param filePath 目标文件路径
     * @param oldStr   正则表达式
     * @param newStr   新字符串
     * @param num      替换次数( num=0 时全局替换)
     * @return 文件是否更新成功
     */
    public static boolean updateFile(String filePath, String oldStr, Object newStr, int num) {
        if (newStr == null || oldStr == null) {
            // logger.error("FileUtils.updateFile: oldStr or newStr cannot be null");
            return false;
        }

        String content = readFile(filePath);

        String str = String.valueOf(newStr);
        // 全局替换
        if (num == 0) {
            content = content.replaceAll(oldStr, str);
        }
        // 局部替换
        for (int i = 0; i < num; i++) {
            content = content.replaceFirst(oldStr, str);
        }

        return createFile(filePath, content);
    }

    /**
     * 创建文件
     *
     * @param filePath 文件路径
     * @param contents 文件内容(字符串数组)
     * @return 文件是否创建成功
     */
    public static boolean createFile(String filePath, String... contents) {
        StringBuilder builder = new StringBuilder();
        if (contents != null) {
            for (String str : contents) {
                builder.append(str);
            }
        }
        String content = builder.toString();
        return createFile(filePath, content.getBytes());
    }

    /**
     * 创建文件
     *
     * @param bytes    文件字节流
     * @param filePath 文件路径
     * @return 文件是否创建成功（若文件已存在，则删除并重新创建）
     */
    public static boolean createFile(String filePath, byte[] bytes) {
        if (!deleteFile(filePath)) {
            return false;
        }

        if (TextUtils.isBlank(filePath)) {
            // logger.error("FileUtils.createFile: create file [{}] failed: filePath is blank", filePath);
            return false;
        }

        boolean mkdirs = new File(filePath).getParentFile().mkdirs();// 创建父级目录

        try (
                RandomAccessFile raf = new RandomAccessFile(filePath, "rw")
        ) {
            raf.write(bytes);
            return true;
        } catch (IOException e) {
            // logger.error("FileUtils.createFile: create file [{}] failed \n", filePath, e);
            return false;
        }
    }

    /**
     * 删除文件
     *
     * @param filePath 目标文件
     * @return 仅当文件存在且删除失败时返回 false
     */
    public static boolean deleteFile(String filePath) {
        if (filePath != null) {
            File file = new File(filePath);
            if (file.exists() && file.isFile() && !file.delete()) {
                // logger.error("FileUtils.deleteFile: delete file [{}] failed!", filePath);
                return false;
            }
        }

        return true;
    }

    /**
     * 递归删除目录/文件
     *
     * @param path 待删除目录/文件的路径
     * @return 删除结果
     */
    public static boolean delete(String path) {
        executeFileRecursive(path, File::delete);
        executeChildFolders(path, target -> delete(target.getPath()));
        return new File(path).delete();
    }

    /**
     * 读取文件
     *
     * @param filePath 目标文件
     * @return 文件内容字符串
     */
    public static String readFile(String filePath) {
        StringBuilder builder = new StringBuilder();

        try (
                BufferedReader reader = new BufferedReader(new FileReader(filePath))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line).append("\r\n");
            }
        } catch (IOException e) {
            // logger.error("FileUtils.readFile: read file [{}] failed \n", filePath, e);
        }

        return builder.toString();
    }

    /**
     * 对目录中的文件执行递归操作
     *
     * @param folderPath 目录路径
     * @param task       任务
     */
    public static void executeFileRecursive(String folderPath, IFileTask task) {
        executeChilds(folderPath, target -> {
            if (target.isFile()) {
                executeFile(target.getPath(), task);
            } else {
                executeFileRecursive(target.getPath(), task);
            }
        });
    }

    /**
     * 对目录的子目录执行操作
     *
     * @param folderPath 目录路径
     * @param task       任务
     */
    public static void executeChildFolders(String folderPath, IFileTask task) {
        executeChilds(folderPath, target -> executeFolder(target.getPath(), task));
    }

    /**
     * 对目录的子文件执行操作
     *
     * @param folderPath 目录路径
     * @param task       任务
     */
    public static void executeChildFiles(String folderPath, IFileTask task) {
        executeChilds(folderPath, target -> executeFile(target.getPath(), task));
    }

    /**
     * 对目录的子目录/文件执行操作
     *
     * @param folderPath 目录路径
     * @param task       任务
     */
    public static void executeChilds(String folderPath, IFileTask task) {
        executeFolder(folderPath, target -> {
            File[] files = target.listFiles();
            if (files != null) {
                for (File file : files) {
                    task.execute(file);
                }
            }
        });
    }

    /**
     * 对目录执行操作
     *
     * @param folderPath 目录
     * @param task       任务
     */
    public static void executeFolder(String folderPath, IFileTask task) {
        if (folderPath != null && task != null) {
            File file = new File(folderPath);
            if (file.isDirectory()) {
                task.execute(file);
            }
        }
    }

    /**
     * 对文件执行操作
     *
     * @param filePath 文件路径
     * @param task     任务
     */
    public static void executeFile(String filePath, IFileTask task) {
        if (filePath != null && task != null) {
            File file = new File(filePath);
            if (file.isFile()) {
                task.execute(file);
            }
        }
    }

    /**
     * 对文件/目录执行操作
     *
     * @param path 文件/目录路径
     * @param task 任务
     */
    public static void execute(String path, IFileTask task) {
        if (path != null && task != null) {
            File file = new File(path);
            if (file.exists()) {
                task.execute(file);
            }
        }
    }

    /**
     * 文件操作接口
     */
    public interface IFileTask {
        void execute(File target);
    }
}