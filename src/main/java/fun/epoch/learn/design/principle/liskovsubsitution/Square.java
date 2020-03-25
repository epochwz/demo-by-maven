package fun.epoch.learn.design.principle.liskovsubsitution;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Square extends Rectangle {
    private long sideLength;

    @Override
    public long getLength() {
        return getSideLength();
    }

    @Override
    public long getWidth() {
        return getSideLength();
    }

    @Override
    public void setLength(long length) {
        setSideLength(length);
    }

    @Override
    public void setWidth(long width) {
        setSideLength(width);
    }
}
