package fun.epoch.learn.design.principle.liskovsubsitution;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Rectangle implements Quadrangle {
    private long length;
    private long width;
}
