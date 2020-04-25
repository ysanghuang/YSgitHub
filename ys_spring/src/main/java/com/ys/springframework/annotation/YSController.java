package com.ys.springframework.annotation;

import java.lang.annotation.*;

/**
 * @Author: yangshuang
 * @Description:
 * @Date: 2020/3/30 21:08
 * @Version: 1.0
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
//Documented注解表明这个注释是由 javadoc记录的，在默认情况下也有类似的记录工具。 如果一个类型声明被注释了文档化，它的注释成为公共API的一部分。
@Documented
public @interface YSController {
    String value() default "";
}
