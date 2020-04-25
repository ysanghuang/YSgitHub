package com.ys.springframework.annotation;

import java.lang.annotation.*;

/**
 * @Author: yangshuang
 * @Description:
 * @Date: 2020/3/30 21:12
 * @Version: 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface YSService {
    String value() default "";
}
