package com.ys.springframework.annotation;

import java.lang.annotation.*;

/**
 * @Author: yangshuang
 * @Description:
 * @Date: 2020/3/30 21:17
 * @Version: 1.0
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface YSRequestParam {
    String value() default "";
}
