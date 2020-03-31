package fun.epoch.framework.mini.spring.web.mvc;

import fun.epoch.framework.mini.spring.beans.Component;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Component
public @interface Controller {
    String value() default "";
}
