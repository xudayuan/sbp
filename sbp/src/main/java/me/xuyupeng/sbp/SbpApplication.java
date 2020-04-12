package me.xuyupeng.sbp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 项目的入口
 * SpringBootApplication注解包括三个注解
 * 1 EnableAutoConfiguration 借助Import注解的支持，收集和注册特定场景相关的Bean定义
 */
@SpringBootApplication
public class SbpApplication {

    /**
     * Spring boot的启动入口
     *
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(SbpApplication.class, args);
    }

}
