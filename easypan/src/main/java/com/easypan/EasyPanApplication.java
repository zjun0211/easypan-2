package com.easypan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author 王哲
 * @ClassName EasyPanApplication
 * @create 2023--六月--上午9:06
 * @Description 启动类
 * @Version V1.0
 */
@SpringBootApplication(scanBasePackages = {"com.easypan"})
@MapperScan("com.easypan.mappers")
@EnableTransactionManagement
@EnableAsync
@EnableScheduling
public class EasyPanApplication {
    public static void main(String[] args) {
        SpringApplication.run(EasyPanApplication.class, args);
    }
}
