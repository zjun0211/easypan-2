package com.easypan.annotation;

import com.easypan.enums.VerifyRegexEnum;

import java.lang.annotation.*;

/**
 * @author 王哲
 * @ClassName VerifyParam
 * @create 2023--六月--下午5:44
 * @Description 参数校验注解
 * @Version V1.0
 */
@Target({ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface VerifyParam {
    //参数最小长度
    int min() default -1;
    //参数最大长度
    int max() default -1;
    //参数是否校验
    boolean required() default false;
    //参数校验正则表达式
    VerifyRegexEnum regex() default VerifyRegexEnum.NONE;

}
