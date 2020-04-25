package com.ys.springframework.annotation;

import java.lang.annotation.*;

/**
 * @Author: yangshuang
 * @Description:
 * @Date: 2020/3/30 21:14
 * @Version: 1.0
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface YSRequestMapping {
    String value() default "";
}
