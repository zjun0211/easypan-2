package com.easypan.annotation;

import java.lang.annotation.*;

/**
 * @author 王哲
 * @ClassName GlobalIterceptor
 * @create 2023--六月--下午5:41
 * @Description 全局拦截器
 * @Version V1.0
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface GlobalIterceptor {

    //校验参数
    boolean verifyParam() default false;

}
