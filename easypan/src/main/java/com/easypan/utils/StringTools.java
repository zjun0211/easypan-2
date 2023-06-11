package com.easypan.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.DigestUtils;

/**
 * @author 王哲
 * @ClassName StringTools
 * @create 2023--六月--上午10:55
 * @Description String工具类
 * @Version V1.0
 */
public class StringTools extends StringUtils {

    /**
     * 获取随机数
     * @param count
     * @return str
     */
    public static final String getRandomNumber(Integer count){
        String str = "";
        for (int i = 0; i < count; i++) {
            str += (int)(Math.random()*10);
        }
        return str;
    }

    /**
     * MD5加密
     * @param password
     * @return str
     */
    public static final String getMD5(String password) {
        //判空
        if (StringUtils.isBlank(password)) {
            return null;
        }
        return DigestUtils.md5DigestAsHex(password.getBytes());
    }

}
