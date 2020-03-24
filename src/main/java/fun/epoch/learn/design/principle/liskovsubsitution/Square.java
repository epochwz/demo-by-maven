package fun.epoch.learn.design.principle.liskovsubsitution;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Square implements Quadrangle {
    private long sideLength;

    @Override
    public long getLength() {
        return getSideLength();
    }

    @Override
    public long getWidth() {
        return getSideLength();
    }
}
