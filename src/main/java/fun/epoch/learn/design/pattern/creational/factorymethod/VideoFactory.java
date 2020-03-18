package fun.epoch.learn.design.pattern.creational.factorymethod;

import fun.epoch.learn.design.pattern.creational.factorymethod.videos.JavaVideo;
import fun.epoch.learn.design.pattern.creational.factorymethod.videos.PythonVideo;

// 代码演进：各个对象的创建逻辑逐渐变得十分复杂，简单工厂日益臃肿，因此难以维护
public class VideoFactory {
    public static Video getVideo(int day) {
        switch (day % 7) {
            case 0:
                // 各种复杂的数据预处理
                // 各种复杂的数据预处理
                // 各种复杂的数据预处理
                // 各种复杂的数据预处理
                // 各种复杂的数据预处理
                // 各种复杂的数据预处理
                // 各种复杂的数据预处理
                // 各种复杂的数据预处理
                // 各种复杂的数据预处理
                // 各种复杂的数据预处理

                // 各种复杂的初始化逻辑
                // 各种复杂的初始化逻辑
                // 各种复杂的初始化逻辑
                // 各种复杂的初始化逻辑
                // 各种复杂的初始化逻辑
                // 各种复杂的初始化逻辑
                // 各种复杂的初始化逻辑
                // 各种复杂的初始化逻辑
                // 各种复杂的初始化逻辑
                // 各种复杂的初始化逻辑
                return new PythonVideo();
            case 1:
                // 各种复杂的数据预处理
                // 各种复杂的数据预处理
                // 各种复杂的数据预处理
                // 各种复杂的数据预处理
                // 各种复杂的数据预处理
                // 各种复杂的数据预处理
                // 各种复杂的数据预处理
                // 各种复杂的数据预处理
                // 各种复杂的数据预处理
                // 各种复杂的数据预处理

                // 各种复杂的初始化逻辑
                // 各种复杂的初始化逻辑
                // 各种复杂的初始化逻辑
                // 各种复杂的初始化逻辑
                // 各种复杂的初始化逻辑
                // 各种复杂的初始化逻辑
                // 各种复杂的初始化逻辑
                // 各种复杂的初始化逻辑
                // 各种复杂的初始化逻辑
                // 各种复杂的初始化逻辑
                return new JavaVideo();
            default:
                return null;
        }
    }
}
