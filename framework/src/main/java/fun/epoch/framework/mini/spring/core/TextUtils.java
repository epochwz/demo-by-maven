package fun.epoch.framework.mini.spring.core;

/**
 * 文本工具
 */
public class TextUtils {
    public static boolean isBlank(String str) {
        return !isNotBlank(str);
    }

    public static boolean isNotBlank(String str) {
        return str != null && str.replaceAll("\\s", "").length() > 0;
    }
}