package com.ys.springframework.annotation;

import java.lang.annotation.*;

/**
 * @Author: yangshuang
 * @Description:
 * @Date: 2020/3/30 21:16
 * @Version: 1.0
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface YSAutowire {
    String value() default "";
}
